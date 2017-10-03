package com.teamjsnbd.ieltsassistor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PracticeTrueFalseType extends AppCompatActivity {
    private String passage = " More than ten years ago, while taking the temperature of the universe,\n" +
            " astronomers found something odd.\n" +
            " They discovered that a patch of sky, spanning the width of 20 moons, was unusually cold.\n" +
            " The astronomers were measuring the thermal radiation that bathes the entire universe,\n" +
            " a glowing relic of the big bang.To gaze at this cosmic microwave background,\n" +
            " or CMB, is to glimpse the primordial1 universe, a time when it was less than 400,000 years old.\n" +
            " The CMB blankets the sky, and looks pretty much the same everywhere, \n" +
            " existing at a feebly cold temperature of 2.725 kelvins -\n" +
            " just a couple degrees warmer than absolute zero.\n" +
            " But armed with the newly launched WMAP satellite,\n" +
            " the astronomers had set out to probe temperature variations as tiny as one part in 100,000.\n" +
            " Born from the quantum froth that was the universe a half-moment after the big bang, \n" +
            "those random fluctuations help scientists understand what the cosmos is made of and how it all came to be.";
    private String[] questionSet ={
            "1. Astronomers often find something odd on the sky.\n",
            "2.The CMB is the thermal radiation across the entire universe.\n",
            "3.The CMB varies from extremely low to very high temperatures.\n",
            "4.Investigation of fluctuations of temperature in the space help scientists to understand what the cosmos is made of.\n",
            "5. The cosmic supervoid is the largest structure in the universe.\n"};
    private String infoOfQuestions = "Do the following statements agree with the information given in Reading Passage?" +"\n" +
            "In boxes 1–5, choose\n" +"\n" +
            "TRUE : if the statement agrees with the information\n" +
            "FALSE: if the statement contradicts the information\n" +
            "NOT GIVEN : if there is no information on this\n";

    private String[] answerSet = {"Not Given", "True", "False", "True", "Not Given" };
    private int questionNumber = 0;

    private TextView stringPassageTF;
   //private TextView questionsOfTF;
    private TextView infoOfTF;

    private TextView autoQuestion;
    private TextView resultViewTF;

    private RadioGroup radioGroup;
    private RadioButton radioOption1;
    private RadioButton radioOption2;
    private RadioButton radioOption3;

    private Button nextQuestion;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_true_false_type);
        stringPassageTF = (TextView)findViewById(R.id.stringPassageTF);
        //questionsOfTF = (TextView)findViewById(R.id.questionsOfTF);
        infoOfTF = (TextView)findViewById(R.id.InfoOfTF);

        autoQuestion = (TextView)findViewById(R.id.questionsOfTF) ;
        resultViewTF = (TextView)findViewById(R.id.resultViewTF);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupTF);
        radioOption1 = (RadioButton) findViewById(R.id.radioOption1TF);
        radioOption2 = (RadioButton) findViewById(R.id.radioOption2TF);
        radioOption3 = (RadioButton) findViewById(R.id.radioOption3TF);

        nextQuestion = (Button) findViewById(R.id.nextQuestionTF);

        stringPassageTF.setText(passage);
        infoOfTF.setText(infoOfQuestions);
        //questionsOfTF.setText(questionSet);
        updateQuestion();

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("True False NG");
        getSupportActionBar().setSubtitle("Reading Practics");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,  int checkedId) {

                String correctAnswer = answerSet[questionNumber];

                switch (checkedId) {
                    case R.id.radioOption1TF:
                        if(correctAnswer.equals("True")) {
                            resultViewTF.setText("Your Answer is Correct");
                        } else {
                            resultViewTF.setText("Your Answer is Incorrect. Correct Answer is: " + correctAnswer);
                        }
                        break;

                    case R.id.radioOption2TF:
                        if(correctAnswer.equals("False")) {
                            resultViewTF.setText("Your Answer is Correct");
                        } else {
                            resultViewTF.setText("Your Answer is Incorrect. Correct Answer is: " + correctAnswer);
                        }
                        break;

                    case R.id.radioOption3TF:
                        if(correctAnswer.equals("Not Given")) {
                            resultViewTF.setText("Your Answer is Correct");
                        } else {
                            resultViewTF.setText("Your Answer is Incorrect. Correct Answer is: " + correctAnswer);
                        }
                        break;
                }

                resultViewTF.setVisibility(View.VISIBLE);
            }
        });

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(radioGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Please Select an answer", Toast.LENGTH_SHORT).show();
                } else {
                    if(questionNumber < questionSet.length - 1) {
                        questionNumber++;
                        updateQuestion();
                    } else {
                        Toast.makeText(getApplicationContext(), "No more Question", Toast.LENGTH_SHORT).show();
                        finish();
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

    private void updateQuestion() {
        radioGroup.clearCheck();
        resultViewTF.setVisibility(View.GONE);
        autoQuestion.setText(questionSet[questionNumber]);
    }
}


