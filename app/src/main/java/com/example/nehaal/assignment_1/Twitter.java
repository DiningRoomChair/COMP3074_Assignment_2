package com.example.nehaal.assignment_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Twitter extends Navigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);

        SharedPreferences sharedpreferences = getSharedPreferences("com.example.nehaal.assignment1", MODE_PRIVATE);
        String username = sharedpreferences.getString("username", "");

        setTitle("Hello, " + username + ".");
    }
}
