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

public class PracticeClassificationSelection extends AppCompatActivity {
    private String passage = "Researchers have found that sleep is beneficial to humans in many ways:\n" +
            "it helps us process memories, and keeps our social and emotional lives on track.\n" +
            "Yet we still do not really know how, why or even exactly when sleep evolved.\n" +
            "\n" +
            "“The cost of losing consciousness to survival is astronomical,” \n" +
            "says Matthew Walker at the University of California in Berkeley.\n" +
            " Whatever functions sleep performs, they must be so fundamentally\n" +
            "important that they far outweigh the obvious vulnerability associated with being asleep.\n" +
            "\n" +
            "This means we can confidently reject one of the simplest theories of sleep:\n" +
            " that we drift off simply because we have nothing better to do. \n" +
            "This could be described as the indolence theory of sleep. Once an animal has eaten,\n" +
            "seen off any rivals and exhausted any potential mating opportunities,\n" +
            "it effectively has an empty schedule, and losing consciousness kills time for a few hours.\n" +
            "\n" +
            "It is a fun idea, but considering that a sleeping animal is significantly more likely\n" +
            "to be caught and eaten than a waking animal,\n" +
            " this hypothesis makes “zero sense”, says Walker.\n" +
            "\n" +
            "There is now an emerging consensus on the behavioural features that define sleep,\n" +
            " and these features can be used to look for sleep in simple animals,\n" +
            " says Ravi Allada at Northwestern University in Evanston, Illinois.\n" +
            "\n" +
            "There are three main elements, says Allada. First and foremost, \n" +
            "sleep renders an animal quiet and still: muscles are not very active during sleep. \n" +
            "Second, sleep makes animals slower to respond. For instance, \n" +
            "if you make a loud noise near a sleeping animal, \n" +
            "it will react more slowly than an awake animal. And finally,\n" +
            "we can recognise sleep because it keeps animals from getting tired.";
    private String optionSet = "Questions 1-7\n" +
            "\n" +
            "Classify the following statements as referring to\n" +
            "    A Matthew Walker\n" +
            "    B Ravi Allada\n" +
            "    C Paul-Antoine Libourel\n" +
            "\n" +
            "Write the appropriate letters A, B or C in boxes 1-7:\n" +
            "\n"
            ;

    private String[] questioSnet = {
            "1) There are three main behavioural features incident to sleep. \n",
            "2) The idea that we sleep because we have nothing else to do is absurd. \n",
            "3) At some point in the evolution, a new stage of sleep appeared: rapid eye movement sleep. \n",
            "4) Natural selection did not suppress sleep, but developed it. \n",
            "5) Sleep makes animals' reaction slower. \n",
            "6) Every major system in human's body suffers because of lack of sleep. \n",
            "7) Muscles are not very active during sleep. "
    };

    private String[] answerSet = {"B", "A", "A", "C", "B", "C", "B" };

    private int questionNumber = 0;

    private TextView stringPassage;
    private TextView questionsOfClassificationSelection;
    private TextView optionsOfClassification;
    private TextView dynamicQuestions;
    private TextView resultView;

    private RadioGroup radioGroup;
    private RadioButton radioOption1;
    private RadioButton radioOption2;
    private RadioButton radioOption3;

    private Button nextQuestion;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_classification_selection);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Practics Classification");
        getSupportActionBar().setSubtitle("Reading Practics");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        stringPassage = (TextView)findViewById(R.id.stringPassageClassification);
        questionsOfClassificationSelection = (TextView)findViewById(R.id.optionsOfClassification);
        dynamicQuestions = (TextView)findViewById(R.id.dynamicQuestions);
        resultView = (TextView)findViewById(R.id.resultView);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioOption1 = (RadioButton) findViewById(R.id.radioOption1);
        radioOption2 = (RadioButton) findViewById(R.id.radioOption2);
        radioOption3 = (RadioButton) findViewById(R.id.radioOption3);

        nextQuestion = (Button) findViewById(R.id.nextQuestion);

        stringPassage.setText(passage);
        questionsOfClassificationSelection.setText(optionSet);

        updateQuestion();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,  int checkedId) {

                String correctAnswer = answerSet[questionNumber];

                switch (checkedId) {
                    case R.id.radioOption1:
                        if(correctAnswer.equals("A")) {
                            resultView.setText("Your Answer is Correct");
                        } else {
                            resultView.setText("Your Answer is Incorrect. Correct Answer is: " + correctAnswer);
                        }
                        break;

                    case R.id.radioOption2:
                        if(correctAnswer.equals("B")) {
                            resultView.setText("Your Answer is Correct");
                        } else {
                            resultView.setText("Your Answer is Incorrect. Correct Answer is: " + correctAnswer);
                        }
                        break;

                    case R.id.radioOption3:
                        if(correctAnswer.equals("C")) {
                            resultView.setText("Your Answer is Correct");
                        } else {
                            resultView.setText("Your Answer is Incorrect. Correct Answer is: " + correctAnswer);
                        }
                        break;
                }

                resultView.setVisibility(View.VISIBLE);
            }
        });

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(radioGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Please Select an answer", Toast.LENGTH_SHORT).show();
                } else {
                    if(questionNumber < questioSnet.length - 1) {
                        questionNumber++;
                        updateQuestion();
                    } else {
                        Toast.makeText(PracticeClassificationSelection.this, "No more Question", Toast.LENGTH_SHORT).show();
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
        resultView.setVisibility(View.GONE);
        dynamicQuestions.setText(questioSnet[questionNumber]);
    }
}