package com.example.projetclicker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PageAmeliorationActivity extends AppCompatActivity {

    private int score; // Score du joueur
    private int increment; // Augmente le score
    private TextView scoreText;
    private Button boutonAmeliorationX2;
    private Button boutonRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_amelioration);

        scoreText = findViewById(R.id.textScoreAmelioration);
        boutonAmeliorationX2 = findViewById(R.id.boutonAcheterX2);
        boutonRetour = findViewById(R.id.boutonRetour);

        // Récupérer les données de MainActivity
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);
        increment = intent.getIntExtra("increment", 1);

        scoreText.setText("Score : " + score);

        // bouton pour acheter l'amélioration x2
        boutonAmeliorationX2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (score >= 10) { // par exemple, coût de 10 pour l'amélioration
                    score -= 10;
                    increment = 2;
                    scoreText.setText("Score : " + score);
                }
            }
        });

        // bouton pour revenir à MainActivity
        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retourner les données à MainActivity
                Intent retourIntent = new Intent();
                retourIntent.putExtra("score", score);
                retourIntent.putExtra("increment", increment);
                setResult(RESULT_OK, retourIntent);
                finish(); // Fermer l'activité
            }
        });
    }
}