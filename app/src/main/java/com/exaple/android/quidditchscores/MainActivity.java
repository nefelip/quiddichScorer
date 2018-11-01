package com.exaple.android.quidditchscores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int SlytherinPoints = 0;
    int GriffindorPoints = 0;
    boolean playGame=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForSlytherin() {
        TextView scoreView = (TextView) findViewById(R.id.slytherinScore);
        scoreView.setText(String.valueOf(SlytherinPoints));
    }

    public void displayForGriffindor() {
        TextView scoreView = (TextView) findViewById(R.id.griffindorScore);
        scoreView.setText(String.valueOf(GriffindorPoints));
    }

    public void declaireWinner() {
        String winner = "";
        if(SlytherinPoints == 0 &&  GriffindorPoints==0){
            TextView slytherinWin = (TextView) findViewById(R.id.slytherinWin);
            slytherinWin.setText(String.valueOf(""));

            TextView griffindorWin = (TextView) findViewById(R.id.griffindorWin);
            griffindorWin.setText(String.valueOf(""));
        }else {
            playGame=false;
            if (SlytherinPoints < GriffindorPoints) {
                TextView griffindorWin = (TextView) findViewById(R.id.griffindorWin);
                griffindorWin.setText(String.valueOf("Winner"));

                TextView slytherinWin = (TextView) findViewById(R.id.slytherinWin);
                slytherinWin.setText(String.valueOf(""));

            } else if (SlytherinPoints > GriffindorPoints) {
                TextView slytherinWin = (TextView) findViewById(R.id.slytherinWin);
                slytherinWin.setText(String.valueOf("Winner"));

                TextView griffindorWin = (TextView) findViewById(R.id.griffindorWin);
                griffindorWin.setText(String.valueOf(""));

            } else if (SlytherinPoints == GriffindorPoints) {
                TextView slytherinWin = (TextView) findViewById(R.id.slytherinWin);
                slytherinWin.setText(String.valueOf("Draw"));

                TextView griffindorWin = (TextView) findViewById(R.id.griffindorWin);
                griffindorWin.setText(String.valueOf("Draw"));
            }
        }
    }

    public void griffindorScoresQuaffle(View v) {
        if(playGame) {
            GriffindorPoints = GriffindorPoints + 10;
            displayForGriffindor();
        }
    }

    public void griffindorScoresSnitch(View v) {
        if (playGame) {
            GriffindorPoints = GriffindorPoints + 150;
            displayForGriffindor();
            declaireWinner();
        }
    }


    public void slytherinScoresQuaffle(View v) {
        if (playGame) {
            SlytherinPoints = SlytherinPoints + 10;
            displayForSlytherin();
        }
    }

    public void SlytherinScoresSnitch(View v) {
        if (playGame) {
            SlytherinPoints = SlytherinPoints + 150;
            displayForSlytherin();
            declaireWinner();
        }
    }
    public void resetGame(View v){
        playGame=true;
        SlytherinPoints=0;
        GriffindorPoints=0;
        displayForSlytherin();
        displayForGriffindor();
        declaireWinner();
    }
}
