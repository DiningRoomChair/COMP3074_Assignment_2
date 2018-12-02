package com.example.nehaal.assignment_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Navigation extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_general_schedule:
                Intent i1 = new Intent(Navigation.this,General_Schedule.class);
                startActivity(i1);
                return true;

            case R.id.item_my_schedule:
                Intent i2 = new Intent(Navigation.this,My_Schedule.class);
                startActivity(i2);
                return true;

            case R.id.item_speakers:
                Intent i3 = new Intent(Navigation.this,Speakers.class);
                startActivity(i3);
                return true;

            case R.id.item_maps:
                Intent i4 = new Intent(Navigation.this,Maps.class);
                startActivity(i4);
                return true;

            case R.id.item_attendees:
                Intent i5 = new Intent(Navigation.this,Attendees.class);
                startActivity(i5);
                return true;

            case R.id.item_sponsors:
                Intent i6 = new Intent(Navigation.this,Sponsors.class);
                startActivity(i6);
                return true;

            case R.id.item_twitter:
                Intent i7 = new Intent(Navigation.this,Twitter.class);
                startActivity(i7);
                return true;

            default:
                Toast.makeText(this,"default",Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
