package com.teamjsnbd.ieltsassistor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MCQ extends AppCompatActivity{

    private McqLibrary myMcq= new McqLibrary();

    private TextView textViewPassage;
    private TextView textViewQuestion;
    private TextView textViewResult;
    private TextView textViewExplanation;
    private TextView textViewExplanationTittle;

    private RadioGroup radioGroup;

    private RadioButton choice1;
    private RadioButton choice2;
    private RadioButton choice3;
    private RadioButton choice4;

    private Button buttonNextQuestion;

    private int correctAnswer = 0;
    private int questonNumber = 0;
    private int passageNumber = 0;
    private int totalQuestion = myMcq.getTotalQuestionCount(passageNumber);
    private int totalPassage = myMcq.getTotalPassageCount();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Practics MCQ Question");
        getSupportActionBar().setSubtitle("Reading Practics");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        textViewPassage = (TextView) findViewById(R.id.textViewPassage);
        textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        textViewExplanation = (TextView) findViewById(R.id.textViewExplanation);
        textViewExplanationTittle = (TextView) findViewById(R.id.textViewExplanationTittle);



        textViewExplanationTittle.setVisibility(View.GONE);
        textViewExplanation.setVisibility(View.GONE);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        choice1 = (RadioButton) findViewById(R.id.choice1);
        choice2 = (RadioButton) findViewById(R.id.choice2);
        choice3 = (RadioButton) findViewById(R.id.choice3);
        choice4 = (RadioButton) findViewById(R.id.choice4);

        buttonNextQuestion = (Button) findViewById(R.id.buttonNextQuestion);


        if(passageNumber < totalPassage) {
            textViewPassage.setText(myMcq.getPassage(passageNumber));
            updateQuestion();
        }






        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                choice1.setTextColor(Color.BLACK);
                choice2.setTextColor(Color.BLACK);
                choice3.setTextColor(Color.BLACK);
                choice4.setTextColor(Color.BLACK);

                switch (checkedId) {
                    case R.id.choice1:
                        if(correctAnswer == 0) {
                            updateResultTextView(true);
                        } else {
                            choice1.setTextColor(Color.RED);
                            updateResultTextView(false);
                        }
                        break;

                    case R.id.choice2:
                        if(correctAnswer == 1) {
                            updateResultTextView(true);
                        } else {
                            choice2.setTextColor(Color.RED);
                            updateResultTextView(false);
                        }
                        break;

                    case R.id.choice3:
                        if(correctAnswer == 2) {
                            updateResultTextView(true);
                        } else {
                            choice3.setTextColor(Color.RED);
                            updateResultTextView(false);
                        }
                        break;

                    case R.id.choice4:
                        if(correctAnswer == 3) {

                            updateResultTextView(true);
                        } else {
                            choice4.setTextColor(Color.RED);
                            updateResultTextView(false);
                        }
                        break;
                }

                setCorrectButtonColor();
            }
        });

        buttonNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(MCQ.this, "Please Select an answer", Toast.LENGTH_SHORT).show();
                } else {

                    if(questonNumber < totalQuestion-1) {
                        questonNumber++;
                        updateQuestion();
                        /*radioGroup.clearCheck();
                        textViewResult.setText("Please select an answer");
                        choice1.setTextColor(Color.BLACK);
                        choice2.setTextColor(Color.BLACK);
                        choice3.setTextColor(Color.BLACK);
                        choice4.setTextColor(Color.BLACK);
                        textViewExplanationTittle.setVisibility(View.GONE);
                        textViewExplanation.setVisibility(View.GONE);*/

                    } else {

                        if(passageNumber < totalPassage-1) {
                            passageNumber++;
                            questonNumber = 0;
                            totalQuestion = myMcq.getTotalQuestionCount(passageNumber);
                            textViewPassage.setText(myMcq.getPassage(passageNumber));

                            updateQuestion();
                        } else {
                            Toast.makeText(MCQ.this, "No more question", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }
                }


            }
        });
    }

    /*Back button */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void setCorrectButtonColor() {

        switch (correctAnswer) {
            case 0:
                choice1.setTextColor(Color.GREEN);
                break;
            case 1:
                choice2.setTextColor(Color.GREEN);
                break;
            case 2:
                choice3.setTextColor(Color.GREEN);
                break;
            case 3:
                choice4.setTextColor(Color.GREEN);
                break;

        }
    }


    public void updateQuestion() {

        radioGroup.clearCheck();

        textViewQuestion.setText(myMcq.getQuestion(passageNumber, questonNumber));

        choice1.setText(myMcq.getChoice1(passageNumber, questonNumber));
        choice2.setText(myMcq.getChoice2(passageNumber, questonNumber));
        choice3.setText(myMcq.getChoice3(passageNumber, questonNumber));
        choice4.setText(myMcq.getChoice4(passageNumber, questonNumber));

        choice1.setTextColor(Color.BLACK);
        choice2.setTextColor(Color.BLACK);
        choice3.setTextColor(Color.BLACK);
        choice4.setTextColor(Color.BLACK);

        textViewResult.setText("Please select an answer");
        textViewExplanationTittle.setVisibility(View.GONE);
        textViewExplanation.setVisibility(View.GONE);

       correctAnswer = myMcq.getCorrectAnswer(passageNumber, questonNumber);
    }

    public void updateResultTextView(boolean correct) {
        if(correct) {
            textViewResult.setText("Your Answer is Correct");
        } else {
            textViewResult.setText("Your Answer is Incorrect");
        }
        textViewExplanation.setText(myMcq.getExplanation(passageNumber, questonNumber));
        textViewExplanationTittle.setVisibility(View.VISIBLE);
        textViewExplanation.setVisibility(View.VISIBLE);
    }

}
