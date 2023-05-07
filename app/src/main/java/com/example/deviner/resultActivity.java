package com.example.deviner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class resultActivity extends AppCompatActivity {
    MaterialCardView home;
    TextView correctt,wrongt,resultatt,resultatscore;
    ImageView resultatimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultactivity);
        home=findViewById(R.id.returnhome);
        wrongt=findViewById(R.id.scorewrong);
        correctt=findViewById(R.id.scorecorrect);
        resultatscore=findViewById(R.id.result_res);
        resultatt=findViewById(R.id.text_reslutat);
        resultatimg=findViewById(R.id.img_resultat);
        int correct=getIntent().getIntExtra("correct",0);
        int wrong=getIntent().getIntExtra("wrong",0);
        int score=correct*5;
        correctt.setText(""+correct);
        wrongt.setText(""+wrong);
        resultatscore.setText(""+score);
        if(correct>=0&&correct<=2){
            resultatt.setText("You have to take the test again");
            resultatimg.setImageResource(R.drawable.ic_sad);
        } else if (correct>=3&&correct<=5){
            resultatt.setText("You have to try a little more  ");
            resultatimg.setImageResource(R.drawable.ic_neutral);
        }
        else if (correct>=6&&correct<=8){
            resultatt.setText("You are very good congratulations");
            resultatimg.setImageResource(R.drawable.ic_smile);
        }
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(resultActivity.this,activity_jeux.class));
                finish();
            }
        });
    }
}