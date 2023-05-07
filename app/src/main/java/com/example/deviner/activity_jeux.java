package com.example.deviner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class activity_jeux extends AppCompatActivity {
LinearLayout quizz,nombre,mots;
AppCompatButton about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);
        quizz=findViewById(R.id.quizz);
        nombre=findViewById(R.id.nbr);
        mots=findViewById(R.id.mot);
        about=findViewById(R.id.button5);
        quizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_jeux.this,BasicQuiz.class));
            }

        });
        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_jeux.this,dev_nombre.class));
            }

        });
        mots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_jeux.this,dev_mots.class));
            }

        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_jeux.this,aboutActivity.class));
            }

        });


    }
}