package com.example.nehaal.assignment_1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.io.FileOutputStream;
import java.util.Date;

public class Survey extends Navigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        SharedPreferences sharedpreferences = getSharedPreferences("com.example.nehaal.assignment1", MODE_PRIVATE);
        String username = sharedpreferences.getString("username", "");

        setTitle("Hello, " + username + ".");
    }

    public void submitClick(View view){
        Date currdate = new Date();
        EditText ETanswer1 = findViewById(R.id.answer1);
        EditText ETanswer2 = findViewById(R.id.answer2);
        EditText ETanswer3 = findViewById(R.id.answer3);

        String timestamp = currdate.toString();
        String answer1 = ETanswer1.getText().toString();
        String answer2 = ETanswer2.getText().toString();
        String answer3 = ETanswer3.getText().toString();

        String filename = "survey.txt";
        String fileanswer = "<" + timestamp + ">\t<" + answer1 + "\t" + answer2 + "\t" + answer3 + ">\n";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileanswer.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
