package com.example.deviner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class aboutActivity extends AppCompatActivity {
    MaterialCardView rtnhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        rtnhome=findViewById(R.id.rtnhome);
        rtnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(aboutActivity.this,activity_jeux.class));
                finish();
            }
        });
    }
}