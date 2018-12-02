package com.example.nehaal.assignment_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Speakers extends Navigation {

    DatabaseHelper db;

    Button btnAdd;
    Button btnRefresh;

    ListView list;

    ArrayList<String> listItems;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);

        SharedPreferences sharedpreferences = getSharedPreferences("com.example.nehaal.assignment1", MODE_PRIVATE);
        String username = sharedpreferences.getString("username", "");

        setTitle("Hello, " + username + ".");

        db = new DatabaseHelper(this);

        listItems = new ArrayList<>();

        btnAdd = findViewById(R.id.btnAdd);
        btnRefresh = findViewById(R.id.btnRefresh);
        list = findViewById(R.id.list);

        //method to display all data.
        viewData();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(view.getContext(), display.class);

                String name = list.getItemAtPosition(position).toString();

                //call all records
                Cursor cursor = db.viewData();

                //move cursor to the specific record that user selected
                cursor.moveToPosition(position);

                //get the values
                String affiliation = cursor.getString(2);
                String email = cursor.getString(3);
                String bio = cursor.getString(4);

                //send values to display.java
                i.putExtra("name",name);
                i.putExtra("affiliation", affiliation);
                i.putExtra("email", email);
                i.putExtra("bio", bio);

                startActivity(i);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Speakers.this,details_activity.class);
                startActivity(i);
            }
        });
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clears the list and displays updated database.
                listItems.clear();
                viewData();
            }
        });

    }


    private void viewData() {
        Cursor cursor = db.viewData();

        //check if there are records
        if(cursor.getCount() == 0)
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        else{
            //loop through db and get the name.
            while(cursor.moveToNext()){
                listItems.add(cursor.getString(1));//index at 1 is name, index at 0 is id
            }

            //display the names on to the list view.
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
            list.setAdapter(adapter);

        }
    }
}
