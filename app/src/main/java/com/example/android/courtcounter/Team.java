package com.example.android.courtcounter;

import android.content.res.Resources;
import android.widget.TextView;

class Team {
    private int score = 0;
    private int fouls = 0;
    private final TextView scoreTextView;
    private final TextView foulsTextView;

    Team(TextView scoreView, TextView foulsView) {
        scoreTextView = scoreView;
        foulsTextView = foulsView;
        reset();
    }

    void plusPoints(int num) {
        updateScore(score + num);
    }

    private void updateScore(int value) {
        // Update the score and set the TextView
        score = value;
        scoreTextView.setText(String.valueOf(score));
    }

    void addFoul() {
        updateFouls(fouls + 1);
    }

    private void updateFouls(int value) {
        // Update the fouls and set the TextView
        fouls = value;
        String foulsText = Resources.getSystem().getString(R.string.fouls) + ": " + String.valueOf(fouls);
        foulsTextView.setText(foulsText);
    }

    void reset() {
        updateScore(0);
        updateFouls(0);
    }
}
