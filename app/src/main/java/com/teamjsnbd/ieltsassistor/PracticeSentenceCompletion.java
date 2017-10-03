package com.teamjsnbd.ieltsassistor;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class PracticeSentenceCompletion extends AppCompatActivity implements View.OnClickListener {
    private String passage = "Congenital heart experts from Spectrum Health Helen DeVos Children's Hospital have \n" +
            "successfully integrated two common imaging techniques to produce\n" +
            "a three-dimensional anatomic model of a patient's heart.\n" +
            "\n" +
            " The 3D model printing of patients' hearts has become more common in recent years as part of an emerging, \n" +
            "experimental field devoted to enhanced visualization of individual cardiac structures and characteristics.\n" +
            "But this is the first time the integration of computed tomography (CT) and three-dimensional transesophageal\n" +
            " echocardiography (3DTEE) has successfully been used for printing a hybrid 3D model of a patient's heart. \n" +
            "A proof-of-concept study authored by the Spectrum Health experts also opens the way for these techniques\n" +
            "to be used in combination with a third tool\n" +
            "\n" +
            " - magnetic resonance imaging (MRI).\n" +
            "\n" +
            " \"Hybrid 3D printing integrates the best aspects of two or more imaging modalities,\n" +
            " which can potentially enhance diagnosis, as well as interventional and surgical planning,\n" +
            "\" said Jordan Gosnell, Helen DeVos Children's Hospital cardiac sonographer,\n" +
            " and lead author of the study. \"Previous methods of 3D printing utilize only one imaging modality, \n" +
            "which may not be as accurate as merging two or more datasets.\"";

    private String questionSet = "1. A three-dimensional __________ of a patient's heart was created by integrating two imaging techniques.\n" +
            "2.Spectrum Health scientists have found a way to combine and use three techniques: computed tomography,\n" +
            " three-dimensional transesophageal echocardiography and _______.\n" +
            "3.The new method of 3D printing is more efficient than previous methods because it merges two and more _______.\n" +
            "4.With more accurate 3D renderings and ______, \n" +
            "physicians will be able to better diagnose and treat heart disease.\n\n";

    private String[] answers = {"anatomic model", "magnetic resonance imaging", "datasets", "printed models"};

    private TextView stringPassage;
    private TextView questions;
    private TextView scResult1;
    private TextView scResult2;
    private TextView scResult3;
    private TextView scResult4;

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
        getSupportActionBar().setTitle("Practics Sentence Completaion");
        getSupportActionBar().setSubtitle("Reading Practics");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        stringPassage = (TextView)findViewById(R.id.stringPassage);
        questions = (TextView)findViewById(R.id.questions);
        scResult1 = (TextView) findViewById(R.id.scResult1);
        scResult2 = (TextView) findViewById(R.id.scResult2);
        scResult3 = (TextView) findViewById(R.id.scResult3);
        scResult4 = (TextView) findViewById(R.id.scResult4);

        questionOneSentenceCompletion = (EditText)findViewById(R.id.questionOneSentenceCompletion);
        questionTwoSentenceCompletion = (EditText)findViewById(R.id.questionTwoSentenceCompletion);
        questionThreeSentenceCompletion = (EditText)findViewById(R.id.questionThreeSentenceCompletion);
        questionFourSentenceCompletion = (EditText)findViewById(R.id.questionFourSentenceCompletion);

        userAns1 = (Button) findViewById(R.id.userAns1);
        userAns2 = (Button) findViewById(R.id.userAns2);
        userAns3 = (Button) findViewById(R.id.userAns3);
        userAns4 = (Button) findViewById(R.id.userAns4);
        finishSentenceActivity = (Button) findViewById(R.id.finishSentenceActivity);

        stringPassage.setText(passage);
        questions.setText(questionSet);

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
                if (userAnswer.equals(answers[0])) {
                    scResult1.setText("Answer is Correct");
                } else {
                    scResult1.setText("Answer is Incorrect. Correct answer is: " + answers[0] + ".");
                }

                questionOneSentenceCompletion.clearFocus();
                questionTwoSentenceCompletion.requestFocus();
                break;

            case R.id.userAns2:
                String userAnswer2 = questionTwoSentenceCompletion.getText().toString().trim();
                if (userAnswer2.equals(answers[1])) {
                    scResult2.setText("Answer is Correct");
                } else {
                    scResult2.setText("Answer is Incorrect. Correct answer is: " + answers[1] + ".");
                }

                questionTwoSentenceCompletion.clearFocus();
                questionThreeSentenceCompletion.requestFocus();
                break;

            case R.id.userAns3:
                String userAnswer3 = questionThreeSentenceCompletion.getText().toString().trim();
                if (userAnswer3.equals(answers[2])) {
                    scResult3.setText("Answer is Correct");
                } else {
                    scResult3.setText("Answer is Incorrect. Correct answer is: " + answers[2] + ".");
                }

                questionThreeSentenceCompletion.clearFocus();
                questionFourSentenceCompletion.requestFocus();
                break;

            case R.id.userAns4:
                String userAnswer4 = questionFourSentenceCompletion.getText().toString().trim();
                if (userAnswer4.equals(answers[3])) {
                    scResult4.setText("Answer is Correct");
                } else {
                    scResult4.setText("Answer is Incorrect. Correct answer is: " + answers[3] + ".");
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
