package com.example.nehaal.assignment_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class details_activity extends AppCompatActivity {

    DatabaseHelper db;

    EditText editName;
    EditText editAffiliation;
    EditText editEmail;
    EditText editBio;

    Button btnSave;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        db = new DatabaseHelper(this);

        editName = findViewById(R.id.editName);
        editAffiliation = findViewById(R.id.editAffiliation);
        editEmail = findViewById(R.id.editEmail);
        editBio = findViewById(R.id.editBio);

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //get all user entered data
                String name = editName.getText().toString();
                String affiliation = editAffiliation.getText().toString();
                String email = editEmail.getText().toString();
                String bio = editBio.getText().toString();

                //check if an fields are empty. if fields are not empty, add to database.
                if(!name.equals("") && !affiliation.equals("") && !email.equals("") && !bio.equals("")){
                    db.insertData(name, affiliation, email, bio);
                    editName.setText("");
                    editAffiliation.setText("");
                    editEmail.setText("");
                    editBio.setText("");
                    finish();
                }else{
                    //inform user to fill all fields. Also reset all fields
                    Toast.makeText(details_activity.this, "Please fill all fields", Toast.LENGTH_LONG).show();
                    editName.setText("");
                    editAffiliation.setText("");
                    editEmail.setText("");
                    editBio.setText("");
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
