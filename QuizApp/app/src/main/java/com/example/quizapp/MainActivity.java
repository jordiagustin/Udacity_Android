package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Correct edit text answer variables
    //We can use strings.xml resources for translations
    String question1 = String.valueOf(R.string.germany); //"Germany";
    String question4Language1 = String.valueOf(R.string.english); //"English"
    String question4Language2 = String.valueOf(R.string.mandarin_chinese); //"Mandarin Chinese";
    String question4Language3 = String.valueOf(R.string.hindi); //"Hindi";
    String question4Language4 = String.valueOf(R.string.spanish); //"Spanish";
    String question4Language5 = String.valueOf(R.string.french); //"French";
    String question4Language6 = String.valueOf(R.string.arabic); //"Arabic";
    String question5 = String.valueOf(R.string.vilna); //"Vilna";
    String question9 = String.valueOf(R.string.portuguese); //"Portuguese";

    //Total user points
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create check result button
        Button checkResultBt = (Button) findViewById(R.id.check_result_button);

        //Check result button listener
        checkResultBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkResult(view);
            }
        });
    }

    /**
     * Method called when the CHECK RESULT button is pressed
     */
    public void checkResult(View view){

        /*
            QUESTION 1
         */
        //Create question 1 edit text
        EditText q1et = (EditText) findViewById(R.id.question1);
        //Call checkAnswer1 method
        checkAnswer1(q1et.getText().toString());

        /*
            QUESTION 2
         */
        //Create question 2 check box answers
        CheckBox q2cbFrance, q2cbHungary, q2cbUk, q2cbAll;
        q2cbFrance = (CheckBox) findViewById(R.id.question2_cb_1);
        q2cbHungary = (CheckBox) findViewById(R.id.question2_cb_2);
        q2cbUk = (CheckBox) findViewById(R.id.question2_cb_3);
        q2cbAll = (CheckBox) findViewById(R.id.question2_cb_4);
        //Call checkAnswer2 method
        checkAnswer2(q2cbFrance.isChecked(), q2cbHungary.isChecked(), q2cbUk.isChecked(), q2cbAll.isChecked());

        /*
            QUESTION 3
         */
        //Create question 3 radio button answers
        RadioButton q3rbCanada, q3rbChina, q3rbUS, q3rbNone;
        q3rbCanada = (RadioButton) findViewById(R.id.question3_rb_1);
        q3rbChina = (RadioButton) findViewById(R.id.question3_rb_2);
        q3rbUS = (RadioButton) findViewById(R.id.question3_rb_3);
        q3rbNone = (RadioButton) findViewById(R.id.question3_rb_4);
        //Call checkAnswer3 method
        checkAnswer3(q3rbNone.isChecked());

        /*
            QUESTION 4
         */
        //Create question 4 edit texts
        EditText q4et1 = (EditText) findViewById(R.id.question4_et_1);
        EditText q4et2 = (EditText) findViewById(R.id.question4_et_2);
        EditText q4et3 = (EditText) findViewById(R.id.question4_et_3);
        EditText q4et4 = (EditText) findViewById(R.id.question4_et_4);
        EditText q4et5 = (EditText) findViewById(R.id.question4_et_5);
        EditText q4et6 = (EditText) findViewById(R.id.question4_et_6);
        //Call checkAnswer 4 method
        checkAnswer4(q4et1.getText().toString(), q4et2.getText().toString(), q4et3.getText().toString(),
                q4et4.getText().toString(),q4et5.getText().toString(), q4et6.getText().toString());

         /*
            QUESTION 5
        */
        //Create question 5 edit text
        EditText q5et = (EditText) findViewById(R.id.question5);
        //Call checkAnswer5 method
        checkAnswer5(q5et.getText().toString());

        /*
            QUESTION 6
         */
        //Create question 6 radio button answers
        RadioButton q6rb28, q6rb52, q6rb35, q6rbNone;
        q6rb28 = (RadioButton) findViewById(R.id.question6_rb_1);
        q6rb52 = (RadioButton) findViewById(R.id.question6_rb_2);
        q6rb35 = (RadioButton) findViewById(R.id.question6_rb_3);
        q6rbNone = (RadioButton) findViewById(R.id.question6_rb_4);
        //Call checkAnswer6 method
        checkAnswer6(q6rbNone.isChecked());

        /*
            QUESTION 7
         */
        //Create question 7 radio button answers
        RadioButton q7rbGaelic, q7rbCatalan, q7rbGerman, q7rbNone;
        q7rbGaelic = (RadioButton) findViewById(R.id.question7_rb_1);
        q7rbCatalan = (RadioButton) findViewById(R.id.question7_rb_2);
        q7rbGerman = (RadioButton) findViewById(R.id.question7_rb_3);
        q7rbNone = (RadioButton) findViewById(R.id.question7_rb_4);
        //Call checkAnswer 7 method
        checkAnswer7(q7rbCatalan.isChecked());


        /*
            QUESTION 8
         */
        //Create question 8 check box answers
        CheckBox q2cbRome, q2cbWarsaw, q2cbManchester, q2cbOsaka;
        q2cbRome = (CheckBox) findViewById(R.id.question8_cb_1);
        q2cbWarsaw = (CheckBox) findViewById(R.id.question8_cb_2);
        q2cbManchester = (CheckBox) findViewById(R.id.question8_cb_3);
        q2cbOsaka = (CheckBox) findViewById(R.id.question8_cb_4);
        //Call checkAnswer 8 method
        checkAnswer8(q2cbRome.isChecked(), q2cbWarsaw.isChecked(), q2cbManchester.isChecked(), q2cbOsaka.isChecked());

        /*
            QUESTION 9
         */
        //Create question 9 edit text
        EditText q9et = (EditText) findViewById(R.id.question9);
        //Call checkAnswer9 method
        checkAnswer9(q9et.getText().toString());

        /*
            QUESTION 10
         */
        //Create question 10 radio button answers
        RadioButton q10rbBasketball, q10rbBaseball, q10rbAmFootball, q10rbIceHockey;
        q10rbBasketball = (RadioButton) findViewById(R.id.question10_rb_1);
        q10rbBaseball = (RadioButton) findViewById(R.id.question10_rb_2);
        q10rbAmFootball = (RadioButton) findViewById(R.id.question10_rb_3);
        q10rbIceHockey = (RadioButton) findViewById(R.id.question10_rb_4);
        //Call checkAnswer 10 method
        checkAnswer10(q10rbAmFootball.isChecked());

        showResults(); //When all the check questions are done we can show the results
    }

    /**
     * Method called to check question 1 answer
     *
     * @param answer is the name of the written country in the edit text
     */
    public void checkAnswer1(String answer){
        if(answer.equalsIgnoreCase(question1)){
           points ++;
       }
    }

    /**
     * Method called to check question 2 answer
     *
     * @params France, Hungary, UK, All are the 4 different options
     */
    public void checkAnswer2(boolean France, boolean Hungary, boolean UK, boolean All){
        if(France == true && Hungary == true) {
            points ++;
        }
    }

    /**
     * Method called to check question 3 answer
     *
     * @param isNoneChecked is the correct answer
     */
    public void checkAnswer3(boolean isNoneChecked){
        if(isNoneChecked == true) {
            points ++;
        }
    }

    /**
     * Method called to check question 4 answer
     *
     * @params language1, language2, language3, language4, language5, language6 are the ordered languages
     */
    public void checkAnswer4(String language1, String language2, String language3, String language4, String language5, String language6){
        if(
                (language1.equalsIgnoreCase(question4Language1)) && (language2.equalsIgnoreCase(question4Language2)) &&
                        (language3.equalsIgnoreCase(question4Language3)) && (language4.equalsIgnoreCase(question4Language4)) &&
                                (language5.equalsIgnoreCase(question4Language5))&& (language6.equalsIgnoreCase(question4Language6))
        ) {
            points ++;
        }
    }

    /**
     * Method called to check question 5 answer
     *
     * @param answer is the name of the written country in the edit text
     */
    public void checkAnswer5(String answer){
        if(answer.equalsIgnoreCase(question5)){
            points ++;
        }
    }

    /**
     * Method called to check question 6 answer
     *
     * @param isCatalanChecked is the correct answer
     */
    public void checkAnswer7(boolean isCatalanChecked){
        if(isCatalanChecked == true) {
            points ++;
        }
    }

    /**
     * Method called to check question 7 answer
     *
     * @param isNoneChecked is the correct answer
     */
    public void checkAnswer6(boolean isNoneChecked){
        if(isNoneChecked == true) {
            points ++;
        }
    }

    /**
     * Method called to check question 8 answer
     *
     * @params Rome, Warsaw, Manchester, Osaka
     */
    public void checkAnswer8(boolean Rome, boolean Warsaw, boolean Manchester, boolean Osaka){
        if(Manchester == true && Osaka == true) {
            points ++;
        }
    }

    /**
     * Method called to check question 9 answer
     *
     * @param answer is the name of the written language in the edit text
     */
    public void checkAnswer9(String answer){
        if(answer.equalsIgnoreCase(question9)){
            points ++;
        }
    }

    /**
     * Method called to check question 10 answer
     *
     * @param isAmFootballChecked is the correct answer
     */
    public void checkAnswer10(boolean isAmFootballChecked){
        if(isAmFootballChecked == true) {
            points ++;
        }
    }

    /**
     * Method called to show results
     */
    public void showResults(){

       /* Not working...
       if(points < 1){
            Toast.makeText(this, "Ouch! "+R.string.your_score_is +points+ R.string.point, Toast.LENGTH_LONG).show();
        }else if(points < 2){
            Toast.makeText(this, "Ouch! "+R.string.your_score_is +points+ R.string.points, Toast.LENGTH_LONG).show();
        }else if(points < 5){
            Toast.makeText(this, +R.string.you_have_no_pass_the_test + R.string.your_score_is +points+ R.string.points + R.string.try_again, Toast.LENGTH_LONG).show();
        }else if(points < 7 || points < 8){
            Toast.makeText(this, R.string.your_score_is +points+ R.string.points +R.string.not_bad, Toast.LENGTH_LONG).show();
        }else if(points < 10){
            Toast.makeText(this, R.string.your_score_is +points+ R.string.points +R.string.good_job, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, R.string.your_score_is +points+ R.string.points +"PERFECT!", Toast.LENGTH_LONG).show();
        }*/

        if(points < 1){
            Toast.makeText(this, "Ouch! Your score is "+points+" points", Toast.LENGTH_SHORT).show();
        }else if(points < 2){
            Toast.makeText(this, "Ouch! Your score is just "+points+" point", Toast.LENGTH_SHORT).show();
        }else if(points < 5){
            Toast.makeText(this, "Yo have not pass the test. Your score is "+points+" points. Try again!", Toast.LENGTH_SHORT).show();
        }else if(points < 7){
            Toast.makeText(this, "Your score is "+points+" points, not bad! But you can do it better!", Toast.LENGTH_SHORT).show();
        }else if(points < 8){
            Toast.makeText(this, "Your score is "+points+" points, not bad! But you can do it better!", Toast.LENGTH_SHORT).show();
        }else if(points < 10){
            Toast.makeText(this, "Your score is "+points+" points, good job!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Your score is "+points+" points, PERFECT!", Toast.LENGTH_SHORT).show();
        }
        resetPoints(); //reset score when the test result is showed
    }
    /**
     * Method called to reset score
     */
    public void resetPoints(){
        points = 0;
    }
}