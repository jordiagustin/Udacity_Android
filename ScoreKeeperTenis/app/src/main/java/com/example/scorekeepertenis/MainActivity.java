package com.example.scorekeepertenis;

import static com.example.scorekeepertenis.R.id.game_status;
import static com.example.scorekeepertenis.R.id.playerA_games;
import static com.example.scorekeepertenis.R.id.playerA_point;
import static com.example.scorekeepertenis.R.id.playerA_sets;
import static com.example.scorekeepertenis.R.id.playerB_games;
import static com.example.scorekeepertenis.R.id.playerB_point;
import static com.example.scorekeepertenis.R.id.playerB_score;
import static com.example.scorekeepertenis.R.id.playerB_sets;
import static com.example.scorekeepertenis.R.id.reset_match;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Game score variables (15, 30, 40...) are treated as a string because they do not follow a "normal" order in their sum
    final String zero = "0";
    final String fifteen = "15";
    final String thirty = "30";
    final String forty = "40";
    final String adv = "A";

    //The app displays the game status
    final String playingStatus = "Playing match";
    final String tieBreakStatus = "TIE BREAK";
    final String playerAWins = "PLAYER A Wins the match";
    final String playerBWins = "PLAYER B Wins the match";

    //Initial values
    String playerAPoints = zero;
    String playerBPoints = zero;
    int playerASets = 0;
    int playerBSets = 0;
    int playerAGames = 0;
    int playerBGames = 0;
    int playerATieBreakPoints = 0;
    int playerBTieBreakPoints = 0;

    //By default we are not playing a tie break
    boolean tieBreak = false;

    //Initial game status
    String gameStatus = playingStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayGameStatus(gameStatus); //Initial game status

        displayPointsForPlayerA(playerAPoints); //Initial player A score
        displayPointsForPlayerB(playerBPoints); //Initial player B score

        displaySetsForPlayerA(playerASets); //Initial player A sets
        displaySetsForPlayerB(playerBSets); //Initial player B sets

        displayGamesForPlayerA(playerAGames); //Initial player A games
        displayGamesForPlayerB(playerBGames); //Initial player B games


        //Initialize player A buttons
        Button buttonUpdateScorePlayerA = (Button) findViewById(playerA_point);

        /**
         * Player  A Buttons listener
         */

        //Adds the player A button listener to the add points button
        buttonUpdateScorePlayerA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addPointsPlayerA(v);
            }
        });

        //Initialize player B buttons
        Button buttonUpdateScorePlayerB = (Button) findViewById(playerB_point);

        /**
         * Player  B Buttons listener
         */

        //Adds the player B button listener to the add points button
        buttonUpdateScorePlayerB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addPointsPlayerB(v);
            }
        });

        //Initialize reset button
        Button buttonResetMatch = (Button) findViewById(reset_match);

        //Adds the reset button listener to the reset match button
        buttonResetMatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetMatch(v);
            }
        });

    }


    /********************** PLAYER A **********************/

    /**
     * Player A Points
     */

    /**
     * Updates player A score.
     */
    public void addPointsPlayerA(View view) {

        //Shows if we are playing a tie break or it's a "normal" game
        if (gameStatus != tieBreakStatus) {
            gameStatus = playingStatus;
        }

        //Controls if we are playing a tie break or it's a "normal" game
        if (tieBreak == true) {
            playerATieBreakPoints++;
            playerAPoints = String.valueOf(playerATieBreakPoints); //Cast value int to String
            checkPlayersTieBreakPoints(); //Checks for the tiebreak current score
        } else {
            switch (playerAPoints) {
                case zero:
                    playerAPoints = fifteen;
                    break;
                case fifteen:
                    playerAPoints = thirty;
                    break;
                case thirty:
                    playerAPoints = forty;
                    break;
                case forty: //We must check for deuce or advantage
                    if (playerBPoints == forty) {
                        playerAPoints = adv;
                    } else if (playerBPoints == adv) {
                        playerAPoints = forty;
                        playerBPoints = forty;
                    } else {
                        resetPlayersPoints();
                        playerAGames++; //Player A wins the game
                    }
                    break;
                case adv:
                    resetPlayersPoints();
                    playerAGames++; //Player A wins the game
                    break;
            }
        }

        //If we have finished the tie brake shows the "normal" game score info
        if (tieBreak == false) {
            gameStatus = playingStatus;
        }

        checkPlayersGames(); //Checks the players games to increase or not the sets
        checkPlayerSets(); //Checks the player sets to determine if we have a winner

        displayGameStatus(gameStatus);

        displaySetsForPlayerA(playerASets);
        displaySetsForPlayerB(playerBSets);

        displayGamesForPlayerA(playerAGames);
        displayGamesForPlayerB(playerBGames);

        displayPointsForPlayerA(playerAPoints);
        displayPointsForPlayerB(playerBPoints);
    }

    /**
     * Displays current score for player A.
     */
    public void displayPointsForPlayerA(String score) {
        TextView scoreView = (TextView) findViewById(R.id.playerA_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays games number for player A.
     */
    public void displayGamesForPlayerA(int games) {
        TextView gamesView = (TextView) findViewById(R.id.playerA_games);
        gamesView.setText(String.valueOf(games));
    }

    /**
     * Displays sets number for player A.
     */
    public void displaySetsForPlayerA(int sets) {
        TextView gamesView = (TextView) findViewById(R.id.playerA_sets);
        gamesView.setText(String.valueOf(sets));
    }


    /********************** PLAYER B **********************/

    /**
     * Player B Points
     */

    /**
     * Updates player B score.
     */
    public void addPointsPlayerB(View view) {

        //Shows if we are playing a tie break or it's a "normal" game
        if (gameStatus != tieBreakStatus) {
            gameStatus = playingStatus;
        }
        //Controls if we are playing a tie break or it's a "normal" game
        if (tieBreak == true) {
            playerBTieBreakPoints++;
            playerBPoints = String.valueOf(playerBTieBreakPoints); //Cast value int to String
            checkPlayersTieBreakPoints(); //Checks for the tiebreak current score
        } else {
            switch (playerBPoints) {
                case zero:
                    playerBPoints = fifteen;
                    break;
                case fifteen:
                    playerBPoints = thirty;
                    break;
                case thirty:
                    playerBPoints = forty;
                    break;
                case forty:
                    if (playerAPoints == forty) {
                        playerBPoints = adv;
                        playerAPoints = forty;
                    } else if (playerAPoints == adv) {
                        playerBPoints = forty;
                        playerAPoints = forty;
                    } else {
                        resetPlayersPoints();
                        playerBGames++; //Player A wins the game
                    }
                    break;
                case adv:
                    resetPlayersPoints();
                    playerBGames++; //Player A wins the game
                    break;
            }
        }

        //If we have finished the tie brake shows the "normal" game score info
        if (tieBreak == false) {
            gameStatus = playingStatus;
        }

        checkPlayersGames(); //Checks the players games to increase or not the sets
        checkPlayerSets(); //Checks the player sets to determine if we have a winner

        displayGameStatus(gameStatus);

        displaySetsForPlayerA(playerASets);
        displaySetsForPlayerB(playerBSets);

        displayGamesForPlayerA(playerAGames);
        displayGamesForPlayerB(playerBGames);

        displayPointsForPlayerA(playerAPoints);
        displayPointsForPlayerB(playerBPoints);
    }

    /**
     * Displays current score for player B.
     */
    public void displayPointsForPlayerB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.playerB_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays games number for player B.
     */
    public void displayGamesForPlayerB(int games) {
        TextView gamesView = (TextView) findViewById(R.id.playerB_games);
        gamesView.setText(String.valueOf(games));
    }

    /**
     * Displays sets number for player A.
     */
    public void displaySetsForPlayerB(int sets) {
        TextView gamesView = (TextView) findViewById(R.id.playerB_sets);
        gamesView.setText(String.valueOf(sets));
    }


    /********************** GAME STATUS **********************/

    /*
        Determines the players games and resets it's value if a player wins a set
        Also checks if we are playing the tiebreak
     */
    public void checkPlayersGames() {
        if ((playerAGames == 6 || playerAGames == 7) && (playerBGames <= playerAGames - 2)) { //Checks 2 if there are two games of difference
            playerASets++;
            resetPlayersPoints();
            resetPlayersGames();
        } else if ((playerBGames == 6 || playerBGames == 7) && (playerAGames <= playerBGames - 2)) { //Checks 2 if there are two games of difference
            playerBSets++;
            resetPlayersPoints();
            resetPlayersGames();
        } else if (playerAGames == 6 && playerBGames == 6) { //tiebreak
            resetPlayersPoints();
            resetPlayersGames();
            tieBreak = true;
            gameStatus = tieBreakStatus;
        }

    }

    /*
        Determines the players sets and resets it's value if a player wins the match
    */
    public void checkPlayerSets() {
        if (playerASets == 3 || (playerASets == 2) && playerBSets == 0) {
            resetPlayersSets(); //Wins A
            gameStatus = playerAWins;
        } else if (playerBSets == 3 || (playerBSets == 2) && playerASets == 0) {
            resetPlayersSets(); //Wins B
            gameStatus = playerBWins;
        }
    }

    /*
        Determine the tiebreak score and it's winner
     */

    public void checkPlayersTieBreakPoints() {
        if ((playerATieBreakPoints == 6 || playerATieBreakPoints == 7) && (playerBTieBreakPoints <= playerATieBreakPoints - 2)) {
            playerASets++;
            resetPlayersPoints();
            tieBreak = false;
            resetPlayersTieBreakPoints(); //The next time we start the tie break from 0
        } else if ((playerBTieBreakPoints == 6 || playerBTieBreakPoints == 7) && (playerATieBreakPoints <= playerBTieBreakPoints - 2)) {
            playerBSets++;
            resetPlayersPoints();
            tieBreak = false;
            resetPlayersTieBreakPoints(); //The next time we start the tie break from 0
        }
    }

    public void resetPlayersPoints() {
        playerAPoints = zero;
        playerBPoints = zero;
    }

    public void resetPlayersGames() {
        playerAGames = 0;
        playerBGames = 0;
    }

    public void resetPlayersSets() {
        playerASets = 0;
        playerBSets = 0;
    }

    public void resetPlayersTieBreakPoints() {
        playerATieBreakPoints = 0;
        playerBTieBreakPoints = 0;
    }


    /**
     * Displays current game status (break points, winner...)
     */
    public void displayGameStatus(String status) {
        TextView statusView = (TextView) findViewById(game_status);
        statusView.setText(String.valueOf(status));
    }


    public void resetMatch(View view) {
        gameStatus = playingStatus;
        playerAPoints = zero;
        playerBPoints = zero;
        playerAGames = 0;
        playerBGames = 0;
        playerASets = 0;
        playerBSets = 0;

        displayGameStatus(gameStatus);

        displaySetsForPlayerA(playerASets);
        displaySetsForPlayerB(playerBSets);

        displayGamesForPlayerA(playerAGames);
        displayGamesForPlayerB(playerBGames);

        displayPointsForPlayerA(playerAPoints);
        displayPointsForPlayerB(playerBPoints);
    }

}