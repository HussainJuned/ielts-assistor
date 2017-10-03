package com.teamjsnbd.ieltsassistor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TrainReading extends AppCompatActivity implements View.OnClickListener {

    private Button buttonMCQ;
    private Button buttonListOfHeadings;
    private Button buttonSentenceCompletion;
    private Button buttonClassification;
    private Button buttonTrueFalseNG;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_reading);


        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Practics MCQ Question");
        getSupportActionBar().setSubtitle("Reading Practics");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        buttonMCQ = (Button) findViewById(R.id.buttonMCQ);
        buttonListOfHeadings = (Button)findViewById(R.id.buttonListOfHeadings);
        buttonSentenceCompletion = (Button)findViewById(R.id.buttonSentenceCompletion);
        buttonClassification = (Button)findViewById(R.id.buttonClassification);
        buttonTrueFalseNG = (Button)findViewById(R.id.buttonTrueFalseNG);

        buttonMCQ.setOnClickListener(this);
        buttonListOfHeadings.setOnClickListener(this);
        buttonSentenceCompletion.setOnClickListener(this);
        buttonClassification.setOnClickListener(this);
        buttonTrueFalseNG.setOnClickListener(this);
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

        if (v.getId() == R.id.buttonMCQ) {
            Intent intent = new Intent(getApplicationContext(), MCQ.class);
            startActivity(intent);

            //finish();
        }
        else if(v.getId() == R.id.buttonListOfHeadings){
            Intent intent = new Intent(getApplicationContext(), ListOfHeadings.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.buttonSentenceCompletion){
            Intent intent = new Intent(getApplicationContext(), SentenceCompletion.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Going to Sentence Completion activity", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == R.id.buttonClassification){
            Intent intent = new Intent(getApplicationContext(), ClassificationSelection.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Going to Classification selection activity", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == R.id.buttonTrueFalseNG){
            Intent intent = new Intent(getApplicationContext(), TrueFalseNGSelection.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Going to True False NG activity", Toast.LENGTH_SHORT).show();
        }



    }
}
