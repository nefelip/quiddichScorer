package com.exaple.android.quidditchscores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int SlytherinPoints = 0;
    int GriffindorPoints = 0;
    /*  playGame: as long this is true the game continues
    *   when the player scores the snitch the game ends
    * */
    boolean playGame=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Display the Slytherin's score */
    public void displayForSlytherin() {
        TextView scoreView = (TextView) findViewById(R.id.slytherinScore);
        scoreView.setText(String.valueOf(SlytherinPoints));
    }

    /* Display the Griffindor's score */
    public void displayForGriffindor() {
        TextView scoreView = (TextView) findViewById(R.id.griffindorScore);
        scoreView.setText(String.valueOf(GriffindorPoints));
    }
    /* Display the result string if there is a winner or if it's a draw */
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
    /* Grifindor scores 10 points if the game is still on going */
    public void griffindorScoresQuaffle(View v) {
        if(playGame) {
            GriffindorPoints = GriffindorPoints + 10;
            displayForGriffindor();
        }
    }
    /* Grifindor scores 150 points if the game is still on going
    *   the game ends and we declare the winner*/
    public void griffindorScoresSnitch(View v) {
        if (playGame) {
            GriffindorPoints = GriffindorPoints + 150;
            displayForGriffindor();
            declaireWinner();
        }
    }

    /* Slytherin scores 10 points if the game is still on going */
    public void slytherinScoresQuaffle(View v) {
        if (playGame) {
            SlytherinPoints = SlytherinPoints + 10;
            displayForSlytherin();
        }
    }
    /* Slytherin scores 150 points if the game is still on going
     *   the game ends and we declare the winner*/
    public void SlytherinScoresSnitch(View v) {
        if (playGame) {
            SlytherinPoints = SlytherinPoints + 150;
            displayForSlytherin();
            declaireWinner();
        }
    }
    /* Game reset and starts over*/
    public void resetGame(View v){
        playGame=true;
        SlytherinPoints=0;
        GriffindorPoints=0;
        displayForSlytherin();
        displayForGriffindor();
        declaireWinner();
    }
}
