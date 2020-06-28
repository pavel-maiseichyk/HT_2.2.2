package com.example.ht_222;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView help;
    Boolean check = false;
    String toastText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        help = findViewById(R.id.help);
        help.setText(R.string.help);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_openNotes:
                Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intentNotes);
                Toast.makeText(this, "Открываем записную книжку...", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_calendar:
                Intent intentCalendar = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intentCalendar);
                Toast.makeText(this, "Открываем календарик...", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendButtonClicked(View view) {
        if (!check) {
            help = findViewById(R.id.help);
            help.setText(R.string.thanks);
            check = true;
        } else
        {toastText = getString(R.string.helpToast);
        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();}
    }
}