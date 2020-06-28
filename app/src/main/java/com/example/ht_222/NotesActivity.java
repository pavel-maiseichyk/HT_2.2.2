package com.example.ht_222;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotesActivity extends AppCompatActivity {

    private Button buttonSave;
    private EditText editText;
    private SharedPreferences sharedPreferences;
    private static String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        init();
        initEditText();
    }

    public void init() {
        buttonSave = findViewById(R.id.buttonSave);
        editText = findViewById(R.id.editText);
        sharedPreferences = getSharedPreferences("note", MODE_PRIVATE);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String input = editText.getText().toString();
                editor.putString(KEY, input).apply();
                Toast.makeText(NotesActivity.this, "Данные сохранены", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void initEditText() {
        editText.setText(sharedPreferences.getString(KEY, ""));
    }
}