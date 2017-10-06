package com.teamjsnbd.ieltsassistor;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ListOfHeadings extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    HeadingLibrary myHeadings = new HeadingLibrary();

    private TextView paragraphView;
    private TextView headingsView;

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;

    private TextView showResultA;
    private TextView showResultB;
    private TextView showResultC;
    private TextView showResultD;
    private TextView showResultE;
    private TextView showResultF;

    private TextView corrAnswerA;
    private TextView corrAnswerB;
    private TextView corrAnswerC;
    private TextView corrAnswerD;
    private TextView corrAnswerE;
    private TextView corrAnswerF;

    private Button finishHeadingActivity;

    private String[] spinnerOptions = {"Select", "i", "ii", "iii", "iv", "v", "vi"};

    private ArrayAdapter<String> adapterOptions;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_headings);

        /*getSupportActionBar().setTitle(Html.fromHtml("<font color='#f5f138'>List Of Headings </font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));*/


        paragraphView = (TextView) findViewById(R.id.paragraphView);
        headingsView = (TextView) findViewById(R.id.headingsView);

        paragraphView.setText(myHeadings.getParragraph());
        headingsView.setText(myHeadings.getHeadings());

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("List Of Heading");
        getSupportActionBar().setSubtitle("Reading Practice");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);

        showResultA = (TextView) findViewById(R.id.showResultA);
        showResultB = (TextView) findViewById(R.id.showResultB);
        showResultC = (TextView) findViewById(R.id.showResultC);
        showResultD = (TextView) findViewById(R.id.showResultD);
        showResultE = (TextView) findViewById(R.id.showResultE);
        showResultF = (TextView) findViewById(R.id.showResultF);

        corrAnswerA = (TextView) findViewById(R.id.corrAnswerA);
        corrAnswerB = (TextView) findViewById(R.id.corrAnswerB);
        corrAnswerC = (TextView) findViewById(R.id.corrAnswerC);
        corrAnswerD = (TextView) findViewById(R.id.corrAnswerD);
        corrAnswerE = (TextView) findViewById(R.id.corrAnswerE);
        corrAnswerF = (TextView) findViewById(R.id.corrAnswerF);

        finishHeadingActivity = (Button) findViewById(R.id.finishHeadingActivity);

        adapterOptions = new ArrayAdapter<String>(this,  android.R.layout.simple_spinner_item , spinnerOptions);
        adapterOptions.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner1.setAdapter(adapterOptions);
        spinner2.setAdapter(adapterOptions);
        spinner3.setAdapter(adapterOptions);
        spinner4.setAdapter(adapterOptions);
        spinner5.setAdapter(adapterOptions);
        spinner6.setAdapter(adapterOptions);

        /*spinner1.setSelection(adapterOptions.NO_SELECTION, false);
        spinner2.setSelection(adapterOptions.NO_SELECTION, false);
        spinner3.setSelection(adapterOptions.NO_SELECTION, false);
        spinner4.setSelection(adapterOptions.NO_SELECTION, false);
        spinner5.setSelection(adapterOptions.NO_SELECTION, false);
        spinner6.setSelection(adapterOptions.NO_SELECTION, false);*/

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);
        spinner5.setOnItemSelectedListener(this);
        spinner6.setOnItemSelectedListener(this);

        finishHeadingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        int selectedSpinnerId = parent.getId();
        if(position == 0) {
            return;
        }

        switch (selectedSpinnerId) {

            case R.id.spinner1:
                String userAnswer = parent.getItemAtPosition(position).toString();
                String corrAnswer = myHeadings.getAnswer(0);
                showResultA.setVisibility(View.VISIBLE);

                if (userAnswer.equals(corrAnswer)) {
                    showResultA.setText("Correct");
                    showResultA.setTextColor(Color.GREEN);
                    corrAnswerA.setVisibility(View.GONE);

                } else {
                    showResultA.setText("Incorrect");
                    showResultA.setTextColor(Color.RED);
                    corrAnswerA.setVisibility(View.VISIBLE);
                    corrAnswerA.setText("Correct Answer is: " + corrAnswer);
                }
                break;

            case R.id.spinner2:
                showResultB.setVisibility(View.VISIBLE);

                if ((parent.getItemAtPosition(position).toString()).equals(myHeadings.getAnswer(1))) {
                    showResultB.setText("Correct");
                    showResultB.setTextColor(Color.GREEN);
                    corrAnswerB.setVisibility(View.GONE);

                } else {
                    showResultB.setText("Incorrect");
                    showResultB.setTextColor(Color.RED);
                    corrAnswerB.setVisibility(View.VISIBLE);
                    corrAnswerB.setText("Correct Answer is: " + myHeadings.getAnswer(1));
                }
                break;

            case R.id.spinner3:
                showResultC.setVisibility(View.VISIBLE);

                if ((parent.getItemAtPosition(position).toString()).equals(myHeadings.getAnswer(2))) {
                    showResultC.setText("Correct");
                    showResultC.setTextColor(Color.GREEN);
                    corrAnswerC.setVisibility(View.GONE);

                } else {
                    showResultC.setText("Incorrect");
                    showResultC.setTextColor(Color.RED);
                    corrAnswerC.setVisibility(View.VISIBLE);
                    corrAnswerC.setText("Correct Answer is: " + myHeadings.getAnswer(2));
                }
                break;

            case R.id.spinner4:
                showResultD.setVisibility(View.VISIBLE);

                if ((parent.getItemAtPosition(position).toString()).equals(myHeadings.getAnswer(3))) {
                    showResultD.setText("Correct");
                    showResultD.setTextColor(Color.GREEN);
                    corrAnswerD.setVisibility(View.GONE);

                } else {
                    showResultD.setText("Incorrect");
                    showResultD.setTextColor(Color.RED);
                    corrAnswerD.setVisibility(View.VISIBLE);
                    corrAnswerD.setText("Correct Answer is: " + myHeadings.getAnswer(3));
                }
                break;

            case R.id.spinner5:
                showResultE.setVisibility(View.VISIBLE);

                if ((parent.getItemAtPosition(position).toString()).equals(myHeadings.getAnswer(4))) {
                    showResultE.setText("Correct");
                    showResultE.setTextColor(Color.GREEN);
                    corrAnswerE.setVisibility(View.GONE);

                } else {
                    showResultE.setText("Incorrect");
                    showResultE.setTextColor(Color.RED);
                    corrAnswerE.setVisibility(View.VISIBLE);
                    corrAnswerE.setText("Correct Answer is: " + myHeadings.getAnswer(4));
                }
                break;

            case R.id.spinner6:
                showResultF.setVisibility(View.VISIBLE);

                if ((parent.getItemAtPosition(position).toString()).equals(myHeadings.getAnswer(5))) {
                    showResultF.setText("Correct");
                    showResultF.setTextColor(Color.GREEN);
                    corrAnswerF.setVisibility(View.GONE);

                } else {
                    showResultF.setText("Incorrect");
                    showResultF.setTextColor(Color.RED);
                    corrAnswerF.setVisibility(View.VISIBLE);
                    corrAnswerF.setText("Correct Answer is: " + myHeadings.getAnswer(5));
                }
                break;


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
