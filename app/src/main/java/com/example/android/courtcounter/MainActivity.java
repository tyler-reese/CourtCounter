package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

    public void homePlus3Points(View v) {
        home.plusPoints(3);
    }

    public void homePlus2Points(View v) {
        home.plusPoints(2);
    }

    public void homeFreeThrow(View v) {
        home.plusPoints(1);
    }

    public void homeAddFoul(View v) {
        home.addFoul();
    }

    public void visitorPlus3Points(View v) {
        visitor.plusPoints(3);
    }

    public void visitorPlus2Points(View v) {
        visitor.plusPoints(2);
    }

    public void visitorFreeThrow(View v) {
        visitor.plusPoints(1);
    }

    public void visitorAddFoul(View v) {
        visitor.addFoul();
    }

    public void resetGame(View v) {
        home.reset();
        visitor.reset();
    }
}
