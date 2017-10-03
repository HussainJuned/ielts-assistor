package com.teamjsnbd.ieltsassistor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SentenceCompletion extends AppCompatActivity {
    Toolbar toolbar;
    private String information = "You should complete statements that paraphrase sentences from the text.\n" +
            "You're given a word limit.\n" +
            "Questions follow the order of the text.\n" +
            "So you are given sentences, which you have to complete." +
            " Those sentences are not exactly taken from the text: they are paraphrased." +
            " But they keep the initial meaning.\n" +
            "\n" +
            "Key words from questions may be your pointers: they'll help you to " +
            "find the passage that contains the answer. But to find the answer, " +
            "you should understand the meaning of the question and find the sentence" +
            " with the same meaning in the text. So you should look for meaning, not separate words.\n" +
            "\n" +
            "Note that if you are asked to complete sentence with no more than two words, " +
            "you can write one or two words.\n\n";

    private String tricksToAnswer = "Answering strategy:\n" +
            "\n" +
            "1. Read the text.\n" +
            "2. Use key words to find the needed paragraph.\n" +
            "3. Make sure you understand the question statement and search for sentence with similar meaning.\n" +
            "4. Once you've found the answer, check if it fits into the statement grammatically and doesn't" +
            " exceed the word limit.\n" +
            "5. Repeat this strategy with other questions.\n" +
            "6. If you prefer, you can read the text by passages.";

    private String tipsToanswer = "Tips:\n" +
            "\n" +
            "Make sure that your answer doesn't exceed the word limit.\n" +
            "Make sure that your answer fits into the sentence grammatically.\n" +
            "The order of questions can help you. Answer for question 4 will be between answers for questions " +
            "3 and 5 in the text.\n" +
            "If text introduces new terms, some answers are likely to be among them.\n\n";

    private TextView info;
    private TextView tricks;
    private TextView tips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_completion);
        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Admin Panel");
        getSupportActionBar().setSubtitle("IELTS Assistor");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        info = (TextView)findViewById(R.id.infoOnSentenceCompletion);
        tricks = (TextView)findViewById(R.id.tricksOfSentenceCompletion);
        tips = (TextView)findViewById(R.id.tipsOfSentenceCompletion);
        info.setText(information);
        tricks.setText(tricksToAnswer);
        tips.setText(tipsToanswer);

    }
    public void info(View view)
    {
        Intent i = new Intent(SentenceCompletion.this, UsefulInfoOfSentenceCompletion.class);
        startActivity(i);
    }
    public void practice(View view)
    {
        Intent i = new Intent(SentenceCompletion.this, PracticeSentenceCompletion.class);
        startActivity(i);
    }
    /*Back button */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
