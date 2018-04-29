package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    class Team {
        private int score = 0;
        private int fouls = 0;
        private TextView scoreTextView;
        private TextView foulsTextView;

        Team(TextView scoreView, TextView foulsView) {
            scoreTextView = scoreView;
            foulsTextView = foulsView;
            reset();
        }

        void plus3Points() { updateScore(score + 3); }

        void plus2Points() { updateScore(score + 2); }

        void freeThrow() { updateScore(score + 1); }

        private void updateScore(int value) {
            // Update the score and set the TextView
            score = value;
            scoreTextView.setText(String.valueOf(score));
        }

        void addFoul() { updateFouls(fouls + 1); }

        private void updateFouls(int value) {
            // Update the fouls and set the TextView
            fouls = value;
            String foulsText = getString(R.string.fouls) + ": " + String.valueOf(fouls);
            foulsTextView.setText(foulsText);
        }

        void reset() {
            updateScore(0);
            updateFouls(0);
        }
    }

    private Team home;
    private Team visitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a home team object
        home = new Team(
                (TextView) findViewById(R.id.homeScoreTextView),
                (TextView) findViewById(R.id.homeFoulsTextView)
        );

        // Create visitor team object
        visitor = new Team(
                (TextView) findViewById(R.id.visitorScoreTextView),
                (TextView) findViewById(R.id.visitorFoulsTextView)
        );
    }

    // onClick handlers for the various buttons, below

    public void homePlus3Points(View v) { home.plus3Points(); }

    public void homePlus2Points(View v) { home.plus2Points(); }

    public void homeFreeThrow(View v) { home.freeThrow(); }

    public void homeAddFoul(View v) { home.addFoul(); }

    public void visitorPlus3Points(View v) { visitor.plus3Points(); }

    public void visitorPlus2Points(View v) { visitor.plus2Points(); }

    public void visitorFreeThrow(View v) { visitor.freeThrow(); }

    public void visitorAddFoul(View v) { visitor.addFoul(); }

    public void resetGame(View v) {
        home.reset();
        visitor.reset();
    }
}
