package com.teamjsnbd.ieltsassistor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ClassificationSelection extends AppCompatActivity {
    private String information = "In this lesson we’re going to learn about classification questions " +
            "in IELTS Reading and how to answer them.\n" +
            " As you can guess, classification questions ask you to classify information from the reading text. \n" +
            "You have some statements from your text, and a list of options (listed as A, B, C etc.). \n" +
            "Your task is to match each statement with the correct option.\n" +
            "\n" +
            "Answers here do not necessarily appear in order of the passage.\n" +
            "You may use each option more than once.";

    private String trickToAnswer = "1.Look at the given options (A, B, C).\n" +
            "2.Skim over the text to get its general idea and see where each option is described.\n" +
            "  It may be useful to underline the options in the text,so it will be easier for you\n" +
            "  to find them later.\n" +
            "3.Attentively read all the information that relates to the option A.\n" +
            "4.Read the statements. If the statement corresponds to what you have just read,\n" +
            "  then classify it as A.\n" +
            "5. You may use scanning to find the key words from the statement in the text.\n" +
            "6.Repeat steps 3 and 4 with other options (B, C etc.)";
    private TextView info;
    private TextView tricks;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification_selection);
        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Admin Panel");
        getSupportActionBar().setSubtitle("IELTS Assistor");

        info = (TextView)findViewById(R.id.infoOnClassification);
        tricks = (TextView)findViewById(R.id.tipsOfClassification);
        info.setText(information);
        tricks.setText(trickToAnswer);

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    /*Back button */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    public void info(View view)
    {
        Intent i = new Intent(ClassificationSelection.this, UsefulInfoOfClassificationSelection.class);
        startActivity(i);
    }
    public void practice(View view)
    {
        Intent i = new Intent(ClassificationSelection.this, PracticeClassificationSelection.class);
        startActivity(i);
    }
}
