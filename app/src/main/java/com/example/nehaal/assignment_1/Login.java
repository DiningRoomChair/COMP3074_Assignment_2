package com.example.nehaal.assignment_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClick(View view){

        EditText usernameText = findViewById(R.id.txtUser);
        String username = usernameText.getText().toString();

        String sharedPrefFile = "com.example.nehaal.assignment1";
        SharedPreferences sharedpreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("username", username);
        editor.commit();

        Intent intent = new Intent(this, General_Schedule.class);
        startActivity(intent);
    }
}
