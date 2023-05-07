package com.example.deviner;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class dev_mots extends AppCompatActivity {
    private String[] words = {"ordinateur", "pc","nokia","television","voiture", "maison", "chien", "pomme"}; // Liste de mots à deviner
    private String selectedWord; // Le mot sélectionné pour la devinette
    private char[] displayWord; // Le mot affiché à l'utilisateur avec les lettres devinées
    private int numTries = 6; // Le nombre d'essais autorisés
    private int numCorrect = 0; // Le nombre de lettres correctement devinées

    private TextView tvDisplayWord;
    private EditText etLetterGuess;
    private Button btnGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_mots);

        tvDisplayWord = findViewById(R.id.tvDisplayWord);
        etLetterGuess = findViewById(R.id.etLetterGuess);
        btnGuess = findViewById(R.id.btnGuess);
        // Sélectionne un mot aléatoire de la liste de mots
        Random rand = new Random();
        int wordIndex = rand.nextInt(words.length);
        selectedWord = words[wordIndex];
        // Initialise le mot affiché avec des tirets pour chaque lettre
        displayWord = new char[selectedWord.length()];
        for (int i = 0; i < selectedWord.length(); i++) {
            displayWord[i] = '-';
        }
        tvDisplayWord.setText(new String(displayWord));
                // Ajoute un listener au bouton de devinette
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String letterGuess = etLetterGuess.getText().toString().toLowerCase();
                etLetterGuess.setText("");
                if (letterGuess.length() == 1 && Character.isLetter(letterGuess.charAt(0))) {
                    char guessedLetter = letterGuess.charAt(0);
                    // Vérifie si la lettre devinée est dans le mot sélectionné
                    boolean foundLetter = false;
                    for (int i = 0; i < selectedWord.length(); i++) {
                        if (selectedWord.charAt(i) == guessedLetter) {
                            displayWord[i] = guessedLetter;
                            numCorrect++;
                            foundLetter = true;
                        }
                    }
                    // Met à jour le mot affiché
                    tvDisplayWord.setText(new String(displayWord));
                    // Vérifie si le joueur a gagné ou perdu
                    if (numCorrect == selectedWord.length()) {
                        tvDisplayWord.setText("Gagné !");
                        btnGuess.setEnabled(false);
                    } else if (!foundLetter) {
                        numTries--;
                        if (numTries == 0) {
                            tvDisplayWord.setText("Perdu ! Le mot était : " + selectedWord);
                            btnGuess.setEnabled(false);
                        }
                    }
                }
            }
        });
    }
}
