package com.teamjsnbd.ieltsassistor;

import android.content.Intent;
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
    private String[] passage;
    private String[][] questionSet ={
            {"1. Astronomers often find something odd on the sky.\n",
            "2.The CMB is the thermal radiation across the entire universe.\n",
            "3.The CMB varies from extremely low to very high temperatures.\n",
            "4.Investigation of fluctuations of temperature in the space help scientists to understand what the cosmos is made of",
            "5. The cosmic supervoid is the largest structure in the universe.\n"},

            {"1. Africa had the warmest July day ever on July.",
            "2. The temperature is rising due to the increased level of carbon dioxide in the atmosphere.",
            "3. 2015 might be the hottest year in the history.",
            "4.\tRecord warming was recorded in various seas, such as Black and Azov Sea.",
            "5.\tThe year 2015 might very well consist of a number of very warm months."},

            {"1.\tCanadian English is considered more like British English by canadians.",
            "2.\tAccording to the secod paragraph, Canadian English is pretty similar to British, with some minor differences.",
            "3.\tThe St Lawrence River was colonised by Canadians in 1600.",
            "4.\tCanadian English is considered neither American nor not American.",
            "5.\tThe fifth paragraph states that many English-speaking countries adopted changes in pronounciation."}
    };

    private String infoOfQuestions = "Do the following statements agree with the information given in Reading Passage?" +"\n" +
            "In boxes 1–5, choose\n" +"\n" +
            "TRUE : if the statement agrees with the information\n" +
            "FALSE: if the statement contradicts the information\n" +
            "NOT GIVEN : if there is no information on this\n";

    private String[][] answerSet = {
            {"Not Given", "True", "False", "True", "Not Given" },
            {"False", "True", "True", "Not Given", "True" },
            {"True", "True", "False", "False", "Not Given" }
    };

    private String[] passageHeading = {"The Largest Thing in the Universe", "The hottest month",
            "Is there such a thing as Canadian English? If so, what is it?"};

    private int questionNumber = 0;
    private int fetched_passageNumber = 1;

    private TextView stringPassageTF;
    private TextView questionsOfTF;
    private TextView infoOfTF;
    private TextView passageTitleTF;
    private TextView resultViewTF;

    private RadioGroup radioGroupTF;
    private RadioButton radioOption1TF;
    private RadioButton radioOption2TF;
    private RadioButton radioOption3TF;

    private Button nextQuestionTF;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_true_false_type);

        passage = getResources().getStringArray(R.array.tfPassagesList);
        fetched_passageNumber = getIntent().getIntExtra("passage_no", 0);
        fetched_passageNumber--;

        stringPassageTF = (TextView)findViewById(R.id.stringPassageTF);
        questionsOfTF = (TextView)findViewById(R.id.questionsOfTF);
        infoOfTF = (TextView)findViewById(R.id.InfoOfTF);
        resultViewTF = (TextView)findViewById(R.id.resultViewTF);
        passageTitleTF = (TextView) findViewById(R.id.passageTitleTF);

        radioGroupTF = (RadioGroup) findViewById(R.id.radioGroupTF);
        radioOption1TF = (RadioButton) findViewById(R.id.radioOption1TF);
        radioOption2TF = (RadioButton) findViewById(R.id.radioOption2TF);
        radioOption3TF = (RadioButton) findViewById(R.id.radioOption3TF);

        nextQuestionTF = (Button) findViewById(R.id.nextQuestionTF);

        stringPassageTF.setText(passage[fetched_passageNumber]);
        infoOfTF.setText(infoOfQuestions);
        //questionsOfTF.setText(questionSet);
        updateQuestion();

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("True False NG");
        getSupportActionBar().setSubtitle("Reading Practice");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        radioGroupTF.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,  int checkedId) {

                String correctAnswer = answerSet[fetched_passageNumber][questionNumber];

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

        nextQuestionTF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(radioGroupTF.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Please Select an answer", Toast.LENGTH_SHORT).show();
                } else {
                    if(questionNumber < 4) {
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
        radioGroupTF.clearCheck();
        resultViewTF.setVisibility(View.GONE);
        questionsOfTF.setText(questionSet[fetched_passageNumber][questionNumber]);
        passageTitleTF.setText(passageHeading[fetched_passageNumber]);
    }
}


