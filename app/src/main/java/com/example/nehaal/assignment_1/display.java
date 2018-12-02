package com.example.nehaal.assignment_1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class display extends AppCompatActivity {

    DatabaseHelper db;

    TextView txtName;
    TextView txtAffiliation;
    TextView txtEmail;
    TextView txtBio;

    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        db = new DatabaseHelper(this);

        txtName = findViewById(R.id.txtName);
        txtAffiliation = findViewById(R.id.txtAffiliation);
        txtEmail = findViewById(R.id.txtEmail);
        txtBio = findViewById(R.id.txtBio);

        btnBack = findViewById(R.id.btnBack);

        //retrieve all data sent from speakers
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String affiliation = i.getStringExtra("affiliation");
        String email = i.getStringExtra("email");
        String bio = i.getStringExtra("bio");

        //set the text views to display the data
        txtName.setText(name);
        txtAffiliation.setText(affiliation);
        txtEmail.setText(email);
        txtBio.setText(bio);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
