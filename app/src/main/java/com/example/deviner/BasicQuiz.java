package com.example.deviner;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicQuiz extends AppCompatActivity {
    TextView qtext,aans,bans,cans,dans;
    List<Questionitem>questionitems;
    int currentQuestions=0;
    int correct=0,wrong=0;
    Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_quiz);
        qtext=findViewById(R.id.quizText);
        aans=findViewById(R.id.aanswer);
        bans=findViewById(R.id.banswer);
        cans=findViewById(R.id.canswer);
        dans=findViewById(R.id.danswer);
        LoadAllQuestions();
        Collections.shuffle(questionitems);
        setQuestionscreen(currentQuestions);
        bans.setOnClickListener(view -> {
            if(questionitems.get(currentQuestions).getAnswer2().equals(questionitems.get(currentQuestions).getCorrect())){
                correct++;
                bans.setBackgroundResource(R.color.green);
                bans.setTextColor(getResources().getColor(R.color.white));
            }else{
                wrong++;
                bans.setBackgroundResource(R.color.red);
                bans.setTextColor(getResources().getColor(R.color.white));
            }
            if (currentQuestions<questionitems.size()-1){
                Handler handler=new Handler();
                handler.postDelayed(() -> {
                    currentQuestions++;
                    setQuestionscreen(currentQuestions);
                    bans.setBackgroundResource(R.color.white);
                    bans.setTextColor(getResources().getColor(R.color.text_secondery_color));
                },500);
            }else{
                Intent intent=new Intent(BasicQuiz.this,resultActivity.class);
                intent.putExtra("correct",correct);
                intent.putExtra("wrong",wrong);
                startActivity(intent);
                finish();
            }
        });
        aans.setOnClickListener(view -> {
            if(questionitems.get(currentQuestions).getAnswer1().equals(questionitems.get(currentQuestions).getCorrect())){
                correct++;
                aans.setBackgroundResource(R.color.green);
                aans.setTextColor(getResources().getColor(R.color.white));
            }else{
                wrong++;
                aans.setBackgroundResource(R.color.red);
                aans.setTextColor(getResources().getColor(R.color.white));
            }
            if (currentQuestions<questionitems.size()-1){
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestions++;
                        setQuestionscreen(currentQuestions);
                        aans.setBackgroundResource(R.color.white);
                        aans.setTextColor(getResources().getColor(R.color.text_secondery_color));
                    }
                },500);
            }else{
                Intent intent=new Intent(BasicQuiz.this,resultActivity.class);
                intent.putExtra("correct",correct);
                intent.putExtra("wrong",wrong);
                startActivity(intent);
                finish();
            }
        });

        cans.setOnClickListener(view -> {
            if(questionitems.get(currentQuestions).getAnswer3().equals(questionitems.get(currentQuestions).getCorrect())){
                correct++;
                cans.setBackgroundResource(R.color.green);
                cans.setTextColor(getResources().getColor(R.color.white));
            }else{
                wrong++;
                cans.setBackgroundResource(R.color.red);
                cans.setTextColor(getResources().getColor(R.color.white));
            }
            if (currentQuestions<questionitems.size()-1){
                Handler handler=new Handler();
                handler.postDelayed(() -> {
                    currentQuestions++;
                    setQuestionscreen(currentQuestions);
                    cans.setBackgroundResource(R.color.white);
                    cans.setTextColor(getResources().getColor(R.color.text_secondery_color));
                },500);
            }else{
                Intent intent=new Intent(BasicQuiz.this,resultActivity.class);
                intent.putExtra("correct",correct);
                intent.putExtra("wrong",wrong);
                startActivity(intent);
                finish();
            }
        });
        dans.setOnClickListener(view -> {
            if(questionitems.get(currentQuestions).getAnswer4().equals(questionitems.get(currentQuestions).getCorrect())){
                correct++;
                dans.setBackgroundResource(R.color.green);
                dans.setTextColor(getResources().getColor(R.color.white));
            }else{
                wrong++;
                dans.setBackgroundResource(R.color.red);
                dans.setTextColor(getResources().getColor(R.color.white));
            }
            if (currentQuestions<questionitems.size()-1){
                Handler handler=new Handler();
                handler.postDelayed(() -> {
                    currentQuestions++;
                    setQuestionscreen(currentQuestions);
                    dans.setBackgroundResource(R.color.white);
                    dans.setTextColor(getResources().getColor(R.color.text_secondery_color));
                },500);
            }else{
                Intent intent=new Intent(BasicQuiz.this,resultActivity.class);
                intent.putExtra("correct",correct);
                intent.putExtra("wrong",wrong);
                startActivity(intent);
                finish();
            }
        });


    }

    private void LoadAllQuestions() {
        questionitems=new ArrayList<>();
        String jsonquiz =LoadJsonFromAsset("easyquestions.json");
        try {
            JSONObject jsonObject=new JSONObject(jsonquiz);
            JSONArray questions =jsonObject.getJSONArray("easyquestions");
            for (int i=0;i<questions.length();i++){
                JSONObject question=questions.getJSONObject(i);
                String questionsString =question.getString("question");
                String answer1String =question.getString("answer1");
                String answer2String =question.getString("answer2");
                String answer3String =question.getString("answer3");
                String answer4sString =question.getString("answer4");
                String correctString=question.getString("correct");
                questionitems.add(new Questionitem(questionsString,answer1String,answer2String,answer3String,answer4sString,correctString));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    private String LoadJsonFromAsset(String s) {
        String json="";
        try {
            InputStream inputStream=getAssets().open(s);
            int size=inputStream.available();
            byte[] buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json =new String(buffer, "UTF-8");

        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }

    private void setQuestionscreen(int currentQuestions) {
        qtext.setText(questionitems.get(currentQuestions).getQuestion());
        aans.setText(questionitems.get(currentQuestions).getAnswer1());
        bans.setText(questionitems.get(currentQuestions).getAnswer2());
        cans.setText(questionitems.get(currentQuestions).getAnswer3());
        dans.setText(questionitems.get(currentQuestions).getAnswer4());
    }
}