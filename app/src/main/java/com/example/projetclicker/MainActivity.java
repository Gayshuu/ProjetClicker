package com.example.projetclicker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int score = 0; // Score du joueur
    private int increment = 1; // augmente le score
    private TextView scoreText;
    private Button boutonIncremente;
    private Button boutonAmelioration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreText = findViewById(R.id.textScore);
        boutonIncremente = findViewById(R.id.boutonIncrementer);
        boutonAmelioration = findViewById(R.id.boutonAmelioration);

        boutonIncremente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += increment;
                scoreText.setText("Score : " + score);
            }
        });

        // bouton pour aller à la page d'amélioration
        boutonAmelioration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PageAmeliorationActivity.class);
                // on envoie les données à la page d'amélioration
                intent.putExtra("score", score);
                intent.putExtra("increment", increment);
                startActivityForResult(intent, 1); // on attend un résultat
            }
        });
    }

    // reception des données de la page d'amélioration
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            // on récupère les données de la page d'amélioration
            score = data.getIntExtra("score", score);
            increment = data.getIntExtra("increment", increment);
            scoreText.setText("Score : " + score);
        }
    }
}