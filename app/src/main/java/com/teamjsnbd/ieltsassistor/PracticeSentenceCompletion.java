package com.teamjsnbd.ieltsassistor;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class PracticeSentenceCompletion extends AppCompatActivity implements View.OnClickListener {
    private String[] passage;

    private String[] questionSet;

    private String[][] answers = {
            {"anatomic model", "magnetic resonance imaging", "datasets", "printed models"},
            {"worthwhile", "worm wars", "oesophagus", "fatal"},
            {"ultrasound scan", "on loan", "reproduction rate", "inhabited by humans"}
    };

    private String[] passageHeading = {"3D heart printed using multiple imaging techniques", "Worms",
            "A giant panda at a zoo in the United States has given birth to twin cubs."};

    private int questionNumber = 0;
    private int fetched_passageNumber = 1;

    private TextView stringPassage;
    private TextView questions;
    private TextView scResult1;
    private TextView scResult2;
    private TextView scResult3;
    private TextView scResult4;
    private TextView scPassageTitle;

    private EditText questionOneSentenceCompletion;
    private EditText questionTwoSentenceCompletion;
    private EditText questionThreeSentenceCompletion;
    private EditText questionFourSentenceCompletion;

    private Button userAns1;
    private Button userAns2;
    private Button userAns3;
    private Button userAns4;
    private Button finishSentenceActivity;

    private ScrollView scrollView;
    private LinearLayout linearLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_sentence_completion);

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Practice Sentence Completaion");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        fetched_passageNumber = getIntent().getIntExtra("passage_no", 0);
        getSupportActionBar().setSubtitle("Passage " + fetched_passageNumber);
        fetched_passageNumber--;

        stringPassage = (TextView)findViewById(R.id.stringPassage);
        questions = (TextView)findViewById(R.id.questions);
        scResult1 = (TextView) findViewById(R.id.scResult1);
        scResult2 = (TextView) findViewById(R.id.scResult2);
        scResult3 = (TextView) findViewById(R.id.scResult3);
        scResult4 = (TextView) findViewById(R.id.scResult4);
        scPassageTitle = (TextView) findViewById(R.id.scPassageTitle);

        questionOneSentenceCompletion = (EditText)findViewById(R.id.questionOneSentenceCompletion);
        questionTwoSentenceCompletion = (EditText)findViewById(R.id.questionTwoSentenceCompletion);
        questionThreeSentenceCompletion = (EditText)findViewById(R.id.questionThreeSentenceCompletion);
        questionFourSentenceCompletion = (EditText)findViewById(R.id.questionFourSentenceCompletion);

        userAns1 = (Button) findViewById(R.id.userAns1);
        userAns2 = (Button) findViewById(R.id.userAns2);
        userAns3 = (Button) findViewById(R.id.userAns3);
        userAns4 = (Button) findViewById(R.id.userAns4);
        finishSentenceActivity = (Button) findViewById(R.id.finishSentenceActivity);

        passage = getResources().getStringArray(R.array.sc_passage_list);
        questionSet = getResources().getStringArray(R.array.sc_question_list);
        stringPassage.setText(passage[fetched_passageNumber]);
        questions.setText(questionSet[fetched_passageNumber]);
        scPassageTitle.setText(passageHeading[fetched_passageNumber]);

        userAns1.setOnClickListener(this);
        userAns2.setOnClickListener(this);
        userAns3.setOnClickListener(this);
        userAns4.setOnClickListener(this);
        finishSentenceActivity.setOnClickListener(this);

    }

    /*Back button */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.userAns1:
                String userAnswer = questionOneSentenceCompletion.getText().toString().trim();
                if (userAnswer.equals(answers[fetched_passageNumber][0])) {
                    scResult1.setText("Answer is Correct");
                } else {
                    scResult1.setText("Answer is Incorrect. Correct answer is: " + answers[fetched_passageNumber][0] + ".");
                }

                questionOneSentenceCompletion.clearFocus();
                questionTwoSentenceCompletion.requestFocus();
                break;

            case R.id.userAns2:
                String userAnswer2 = questionTwoSentenceCompletion.getText().toString().trim();
                if (userAnswer2.equals(answers[fetched_passageNumber][1])) {
                    scResult2.setText("Answer is Correct");
                } else {
                    scResult2.setText("Answer is Incorrect. Correct answer is: " + answers[fetched_passageNumber][1] + ".");
                }

                questionTwoSentenceCompletion.clearFocus();
                questionThreeSentenceCompletion.requestFocus();
                break;

            case R.id.userAns3:
                String userAnswer3 = questionThreeSentenceCompletion.getText().toString().trim();
                if (userAnswer3.equals(answers[fetched_passageNumber][2])) {
                    scResult3.setText("Answer is Correct");
                } else {
                    scResult3.setText("Answer is Incorrect. Correct answer is: " + answers[fetched_passageNumber][2] + ".");
                }

                questionThreeSentenceCompletion.clearFocus();
                questionFourSentenceCompletion.requestFocus();
                break;

            case R.id.userAns4:
                String userAnswer4 = questionFourSentenceCompletion.getText().toString().trim();
                if (userAnswer4.equals(answers[fetched_passageNumber][3])) {
                    scResult4.setText("Answer is Correct");
                } else {
                    scResult4.setText("Answer is Incorrect. Correct answer is: " + answers[fetched_passageNumber][3] + ".");
                }

                questionFourSentenceCompletion.clearFocus();
                linearLayout.requestFocus();

                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                //for hiding keyboard
                mgr.hideSoftInputFromWindow(questionFourSentenceCompletion.getWindowToken(), 0);
                //for showing keyboard
                //mgr.showSoftInput(questionFourSentenceCompletion, InputMethodManager.SHOW_IMPLICIT);
                break;

            case R.id.finishSentenceActivity:
                finish();
                break;
        }
    }
}
