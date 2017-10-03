package com.teamjsnbd.ieltsassistor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TrueFalseNGSelection extends AppCompatActivity {

    private String information = "Useful information:\n" +
            "\n" +
            "Questions follow the order of the text.\n" +
            "Questions repeat key words from sentences.\n" +
            "If question contains information NOT stated in the text, it has \"Not Given\" answer.\n" +
            "\n" +
            "Answering strategy:\n" +
            "\n" +
            "Read the first passage.\n" +
            "Look up for answers for the first few questions.\n" +
            "If you found an answer - read the whole sentence carefully, and only then answer the question.\n" +
            "When there are no answers left - move on to next paragraph, and repeat this strategy.\n" +
            "If you prefer, you can read the whole text and only after that answer the questions.";
    private String tipsToAnswer = "1. This type of questions needs attention to details.\n" +
            "   Don't just look for key words - read the whole question and the whole sentence with answer.\n" +
            "2. Words like often, always, never, some can completely change the meaning of the question.\n" +
            "   Be careful!\n" +
            "3. The order of questions can help you.\n" +
            "   Answer for question 4 will be between answers for questions 3 and 5 in the text.\n" +
            "4. If you can't find answer for some question, don't spend too much time on it and return to it in the end.\n" +
            "   Probably, this information is just not given in the text.";

    private TextView info;
    private TextView tips;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false_ngselection);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("True and False");
        getSupportActionBar().setSubtitle("Reading Practics");
        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        info = (TextView)findViewById(R.id.infoOnTF);
        tips = (TextView)findViewById(R.id.tipsOfTF);
        info.setText(information);
        tips.setText(tipsToAnswer);
    }

    /*View menu item */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    public void info(View view)
    {
        Intent i = new Intent(TrueFalseNGSelection.this, UsefulInfoOfTrueFalseType.class);
        startActivity(i);
    }
    public void practice(View view)
    {
        Intent i = new Intent(TrueFalseNGSelection.this, PracticeTrueFalseType.class);
        startActivity(i);
    }

}
