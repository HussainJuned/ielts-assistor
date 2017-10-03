package com.teamjsnbd.ieltsassistor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fr.ganfra.materialspinner.MaterialSpinner;

public class IeltsCalculator extends AppCompatActivity {
    //ekano ekta data src+ view obj+ adapter lagbo as we're using spinner class!!!
    //view object

    private MaterialSpinner numberOfCorrectAnswerInWriting;
    private MaterialSpinner numberOfCorrectAnswerInSpeaking;
    Toolbar toolbar;
    TextInputLayout listeningInputLayout,readingInputLayout;

    //data src
    private static String[] numbers = {"2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0",
            "5.5", "6.0", "6.5", "7.0", "7.5", "8.0", "8.5", "9.0"};
    //to bind ACT and data src, need adapter
    ArrayAdapter<String> score_adapter;
    EditText listeningNum;
    EditText ReadingNum;
    private TextView resultCalculator;
    //Button calculateListeningScore;
    //Button calculateReadingScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ielts_calculator);
        listeningNum = (EditText) findViewById(R.id.listeningScore);
        ReadingNum = (EditText) findViewById(R.id.readingScore);
        resultCalculator = (TextView)findViewById(R.id.resultCalculator);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Brand Score Calculator");
        getSupportActionBar().setSubtitle("IELTS Assistor");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //calculateListeningScore = (Button) findViewById(R.id.getListeningScore);
        //calculateReadingScore = (Button) findViewById(R.id.getReadingScore);
        //initialize view object
        numberOfCorrectAnswerInWriting = (MaterialSpinner) findViewById(R.id.select_score);
        numberOfCorrectAnswerInSpeaking = (MaterialSpinner) findViewById(R.id.select_score_1);
        //initialize arrayAdapter
        score_adapter = new ArrayAdapter<String>(IeltsCalculator.this,
                android.R.layout.simple_spinner_item, numbers);

        //combine with adapter and ds
        numberOfCorrectAnswerInWriting.setAdapter(score_adapter);
        numberOfCorrectAnswerInWriting.setSelection(score_adapter.NO_SELECTION, false);
        numberOfCorrectAnswerInSpeaking.setAdapter(score_adapter);
        numberOfCorrectAnswerInSpeaking.setSelection(score_adapter.NO_SELECTION, false);

        listeningInputLayout = (TextInputLayout) findViewById(R.id.listeningInputLayout);
        readingInputLayout = (TextInputLayout) findViewById(R.id.readingInputLayout);

        //(sk)cal_Button =(Button) findViewById(R.id.cal_button);

        //(sk)intializeButtonListeners();

        listeningNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    listeningNum.setHint("3-40");
                } else {
                    listeningNum.setHint("");
                }
            }
        });

        ReadingNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    ReadingNum.setHint("3-40");
                } else {
                    ReadingNum.setHint("");
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

    public double calculateReadingScore(int readingScore) {
        double result = 0;
        switch (readingScore) {
            case 3:
            case 4:
            case 5:
                result = 2.5;
                break;

            case 6:
            case 7:
                result = 3;
                break;
            case 8:
            case 9:
                result = 3.5;
                break;
            case 10:
            case 11:
            case 12:
                result = 4;
                break;
            case 13:
            case 14:
                result = 4.5;
                break;
            case 15:
            case 16:
            case 17:
            case 18:
                result = 5;
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                result = 5.5;
                break;
            case 23:
            case 24:
            case 25:
            case 26:
                result = 6;
                break;

            case 27:
            case 28:
            case 29:
                result = 6.5;
                break;
            case 30:
            case 31:
            case 32:
                result = 7;
                break;
            case 33:
            case 34:
                result = 7.5;
            case 35:
            case 36:
                result = 8;
                break;
            case 37:
            case 38:
                result = 8.5;
                break;
            case 39:
            case 40:
                result = 9;
                break;
            default:
                result = 0;

        }
        return result;
    }

    public double calculateListeningScore(int listeningScore) {
        double result = 0;
        switch (listeningScore) {
            case 3:
            case 4:
            case 5:
                result = 2.5;
                break;

            case 6:
            case 7:
                result = 3.0;
                break;
            case 8:
            case 9:
            case 10:
                result = 3.5;
                break;
            case 11:
            case 12:
                result = 4.0;
                break;
            case 13:
            case 14:
            case 15:
                result = 4.5;
                break;
            case 16:
            case 17:
                result = 5.0;
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                result = 5.5;
                break;
            case 23:
            case 24:
            case 25:
                result = 6;
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                result = 6.5;
                break;
            case 30:
            case 31:
                result = 7.0;
                break;
            case 32:
            case 33:
            case 34:
                result = 7.5;
                break;
            case 35:
            case 36:
                result = 8.0;
                break;
            case 37:
            case 38:
                result = 8.5;
                break;
            case 39:
            case 40:
                result = 9;
                break;
            default:
                Toast.makeText(getApplicationContext(), "You entered wrong score," +
                                "Please enter a score between 3-40",
                        Toast.LENGTH_SHORT).show();
                result = 0;

        }
        return result;
    }

    //main calculation
    public void calc(View v) {
        Double listeningScore;
        int correctListeningScore;
        int correctReadingScore;
        Double readingScore;
        Double writingScore;
        Double speakingScore;
        double bandScore;

        String string_listening = listeningNum.getText().toString();

        if (string_listening.equals("")) {
            Toast.makeText(this, "Please write Listening score  between 3-40", Toast.LENGTH_SHORT).show();
        } else {
            correctListeningScore = Integer.parseInt(string_listening);
            listeningScore = calculateListeningScore(correctListeningScore);
            if(listeningScore <  2.5 || listeningScore > 9.0)
            {
                Toast.makeText(this, "Please write Reading score between 3-40", Toast.LENGTH_SHORT).show();
            }
            else
            {
                //reading
                String string_reading = ReadingNum.getText().toString();
                if (string_reading.equals("")) {
                    Toast.makeText(this, "Please write Reading score  between 3-40", Toast.LENGTH_SHORT).show();
                } else {
                    correctReadingScore = Integer.parseInt(string_reading);
                    readingScore = calculateReadingScore(correctReadingScore);
                    if(readingScore < 2.5 || readingScore > 9.0)
                    {
                        Toast.makeText(this, "Please write Reading score between 3-40", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {

                        //writingz
                        String string_writing = numberOfCorrectAnswerInWriting.getSelectedItem().toString();
                        if (string_writing.equals("Select Your Writing Score")) {
                            Toast.makeText(this, "Please Select a Writing score", Toast.LENGTH_SHORT).show();
                        } else {
                            writingScore = Double.parseDouble(string_writing);

                            //speaking
                            String string_speaking = numberOfCorrectAnswerInSpeaking.getSelectedItem().toString();
                            if (string_speaking.equals("Select Your Speaking Score")) {
                                Toast.makeText(this, "Please Select a Speaking score", Toast.LENGTH_SHORT).show();
                            } else {
                                speakingScore = Double.parseDouble(string_speaking);

                                bandScore = (listeningScore + readingScore + writingScore + speakingScore) / 4;
                                setAllResultStrings(listeningScore, readingScore, writingScore, speakingScore);
                                if(bandScore == 2.5)
                                {
                                    resultCalculator.append("Your Bandscore is: "+ bandScore + "\n");
                                    resultCalculator.append("You're an Intermittent User");
                                    resultCalculator.setTextColor(Color.RED);
                                }
                                else if(bandScore == 3.5)
                                {
                                    //resultCalculator.setText("Your Bandscore is: "+ bandScore + "\n");
                                    resultCalculator.append("Your Bandscore is: "+ bandScore + "\n");
                                    resultCalculator.append("You're an Extremely Limited User");
                                    resultCalculator.setTextColor(Color.RED);
                                }

                                else if(bandScore == 4.5)
                                {
                                    //resultCalculator.setText("Your Bandscore is: "+ bandScore + "\n");
                                    resultCalculator.append("Your Bandscore is: "+ bandScore + "\n");
                                    resultCalculator.append("You're a Limited User");
                                    resultCalculator.setTextColor(Color.RED);
                                }
                                else if(bandScore == 5.5)
                                {
                                    resultCalculator.append("Your Bandscore is: "+ bandScore + "\n");
                                    resultCalculator.append("You're a Modest User");
                                    resultCalculator.setTextColor(Color.RED);
                                }
                                else if(bandScore == 6.5)
                                {
                                    resultCalculator.append("Your Bandscore is: "+ bandScore + "\n");
                                    resultCalculator.append("You're a Competent User");
                                    resultCalculator.setTextColor(Color.GREEN);
                                }
                                else if(bandScore == 7.5)
                                {
                                    resultCalculator.append("Your Bandscore is: "+ bandScore + "\n");;
                                    resultCalculator.append("You're a Good User");
                                    resultCalculator.setTextColor(Color.GREEN);
                                }

                                else if(bandScore == 8.5)
                                {
                                    resultCalculator.append("Your Bandscore is: "+ bandScore + "\n");
                                    resultCalculator.append("You're a Very Good User");
                                    resultCalculator.setTextColor(Color.BLUE);
                                }
                                else
                                {
                                    long longBandScore = Math.round(bandScore);
                                    if(longBandScore == 2)
                                    {
                                        resultCalculator.append("Your Bandscore is: "+ longBandScore + "\n");                                        resultCalculator.append("You're an Intermittent User");
                                        resultCalculator.setTextColor(Color.RED);
                                    }
                                    else if(longBandScore == 3)
                                    {
                                        resultCalculator.append("Your Bandscore is: "+ longBandScore + "\n");
                                        resultCalculator.append("You're an Extremely Limited User");
                                        resultCalculator.setTextColor(Color.RED);
                                    }
                                    else if(longBandScore == 4)
                                    {
                                        resultCalculator.append("Your Bandscore is: "+ longBandScore + "\n");
                                        resultCalculator.append("You're a Limited User");
                                        resultCalculator.setTextColor(Color.RED);
                                    }
                                    else if(longBandScore == 5)
                                    {
                                        resultCalculator.append("Your Bandscore is: "+ longBandScore + "\n");
                                        resultCalculator.append("You're a Modest User");
                                        resultCalculator.setTextColor(Color.RED);
                                    }
                                    else if(longBandScore == 6)
                                    {
                                        resultCalculator.append("Your Bandscore is: "+ longBandScore + "\n");                                        resultCalculator.append("You're a Competent User");
                                        resultCalculator.setTextColor(Color.GREEN);
                                    }
                                    else if(longBandScore == 7)
                                    {
                                        resultCalculator.append("Your Bandscore is: "+ longBandScore + "\n");
                                        resultCalculator.append("You're a Good User");
                                        resultCalculator.setTextColor(Color.GREEN);
                                    }
                                    else if(longBandScore == 8)
                                    {
                                        resultCalculator.append("Your Bandscore is: "+ longBandScore + "\n");
                                        resultCalculator.append("You're a Very Good User");
                                        resultCalculator.setTextColor(Color.BLUE);
                                    }
                                    else if(longBandScore == 9)
                                    {
                                        resultCalculator.append("Your Bandscore is: "+ longBandScore + "\n");
                                        resultCalculator.setText("You're an Expert User");
                                        resultCalculator.setTextColor(Color.BLUE);
                                    }
                                }

                            }

                        }
                    }
                }
            }

        }



    }
    public void reset(View view)
    {
        //Toast.makeText(getApplicationContext(),"Shobta reset kora ucit", Toast.LENGTH_SHORT).show();
        listeningNum.setText(null);
        ReadingNum.setText(null);
        resultCalculator.setText(null);
        numberOfCorrectAnswerInSpeaking.setSelection(0);
        numberOfCorrectAnswerInWriting.setSelection(0);

    }
    public void setAllResultStrings(double listeningScore, double readingScore, double writingScore, double speakingScore)
    {
        resultCalculator.setText("Your Listening score is: "+ listeningScore + "\n");
        resultCalculator.append("Your Reading score is: "+ readingScore + "\n");
        resultCalculator.append("Your Writing score is: "+ writingScore+ "\n");
        resultCalculator.append("Your Speaking score is: "+ speakingScore + "\n");
    }

}




