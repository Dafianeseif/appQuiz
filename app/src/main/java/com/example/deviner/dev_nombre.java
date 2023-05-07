package com.example.deviner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class dev_nombre extends AppCompatActivity {
    private EditText guessInput;
    Button submitButton,hmpage;
    private TextView resultText;
    private int randomNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_nombre);
        guessInput = findViewById(R.id.guess_input);
        submitButton = findViewById(R.id.submit_button);
        resultText = findViewById(R.id.result_text);
        hmpage = findViewById(R.id.pagehm);


        // génère un nombre aléatoire entre 1 et 100
        Random random = new Random();
        randomNumber = random.nextInt(10) + 1;
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // récupère la valeur saisie par l'utilisateur
                String guessString = guessInput.getText().toString();

                // vérifie si la valeur saisie est un nombre
                if (guessString.matches("\\d+")) {
                    int guess = Integer.parseInt(guessString);
                    // compare la valeur saisie avec le nombre aléatoire
                    if (guess == randomNumber) {
                        resultText.setText("Bravo, vous avez deviné le nombre !");
                    } else if (guess > randomNumber) {
                        resultText.setText("Le nombre à deviner est plus grand !");
                    } else {
                        resultText.setText("Le nombre à deviner est plus petit !");
                    }
                    } else {
                    // affiche un message d'erreur si la saisie n'est pas un nombre
                        Toast.makeText(dev_nombre.this, "Veuillez saisir un nombre", Toast.LENGTH_SHORT).show();
                           }
                    }
                });
        hmpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dev_nombre.this,activity_jeux.class));
                finish();
            }
        });
            }
    }

