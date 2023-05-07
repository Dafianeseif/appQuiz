package com.example.deviner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private Button started;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        started=findViewById(R.id.btn_start);
        started.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,activity_jeux.class));
            finish();
        });
    }
}