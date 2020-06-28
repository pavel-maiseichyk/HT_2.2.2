package com.example.ht_222;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class CalendarActivity extends AppCompatActivity {

    Button button;

    CalendarView startTime;
    CalendarView endTime;

    long startTimeSeconds;
    long endTimeSeconds;

    String startTimeString;
    String endTimeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        init();
    }

    public void onClick(View view) {
        check();
    }

    public void init() {
        button = findViewById(R.id.buttonCheck);
        startTime = findViewById(R.id.startTime);
        endTime = findViewById(R.id.endTime);

        startTime.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int monthS, int dayOfMonth) {
                GregorianCalendar startTimeCalendar = new GregorianCalendar();
                int month = monthS + 1;
                startTimeCalendar.set(year, month, dayOfMonth);
                startTimeSeconds = startTimeCalendar.getTimeInMillis();

                startTimeString = dayOfMonth + "." + month + "." + year;
            }
        });

        endTime.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int monthS, int dayOfMonth) {
                GregorianCalendar endTimeCalendar = new GregorianCalendar();
                int month = monthS + 1;
                endTimeCalendar.set(year, month, dayOfMonth);
                endTimeSeconds = endTimeCalendar.getTimeInMillis();

                endTimeString = dayOfMonth + "." + month + "." + year;
            }
        });
    }

    @SuppressLint("ShowToast")
    public void check() {
        if (startTimeSeconds < endTimeSeconds) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Начальное время: ").append(startTimeString).append("\nКонечное время: ").append(endTimeString);
            Toast.makeText(this, stringBuilder, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Ошибочка...", Toast.LENGTH_LONG).show();
        }
    }
}