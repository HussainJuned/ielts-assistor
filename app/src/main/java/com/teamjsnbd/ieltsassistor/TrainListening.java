package com.teamjsnbd.ieltsassistor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class TrainListening extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_listening);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Listening Practics");
        getSupportActionBar().setSubtitle("Free Training");

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



    public void attentionPractice(View v)
    {
        Intent intent = new Intent(this, ListeningDrawAttentionPractice.class);
        startActivity(intent);
    }
    public void readQuestion(View v)
    {
        Intent intent = new Intent(this, ListeningReadingQuestionPractice.class);
        startActivity(intent);
    }
    public void mcqPractice(View v)
    {
        Intent intent = new Intent(this, ListeningMCQPractice.class);
        startActivity(intent);
    }
}
