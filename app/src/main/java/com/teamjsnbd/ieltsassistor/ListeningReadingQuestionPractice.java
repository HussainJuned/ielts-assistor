package com.teamjsnbd.ieltsassistor;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListeningReadingQuestionPractice extends AppCompatActivity implements View.OnClickListener {
    List <String> correctSelectionList = new ArrayList<String>();
    List <String> wrongSelectionList = new ArrayList<String>();
    private EditText answerOfQstn1ReadingQstn;
    private EditText answerOfQstn2ReadingQstn;
    private EditText answerOfQstn4ReadingQstn;

    private TextView resultOfQstn1OfReadingQstn;
    private TextView resultOfQstn2OfReadingQstn;
    private TextView resultOfQstn3OfReadingQstn;
    private TextView resultOfQstn4OfReadingQstn;

    private Button buttonPlayPause1;
    private Button buttonPlayPause2;
    private Button buttonPlayPause3;
    private Button buttonPlayPause4;

    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;
    private SeekBar seekBar4;

    private MediaPlayer mediaPlayer;

    private Handler handler;
    private Runnable runnable;
    private InputMethodManager mgr;

    private int totalTrack = 4;
    private int[] tracks = new int[totalTrack-1];
    private int currentTrack = -1;

    private boolean track1IsPlaying;
    private boolean track2IsPlaying;
    private boolean track3IsPlaying;
    private boolean track4IsPlaying;


    private boolean handlerHasCallBacks;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening_reading_question_practice);
        answerOfQstn1ReadingQstn = (EditText)findViewById(R.id.answerOfQstn1ReadingQstn);
        answerOfQstn2ReadingQstn = (EditText)findViewById(R.id.answerOfQstn2ReadingQstn);
        answerOfQstn4ReadingQstn = (EditText)findViewById(R.id.answerOfQstn4ReadingQstn);

        resultOfQstn1OfReadingQstn = (TextView)findViewById(R.id.resultOfQstn1OfReadingQstn);
        resultOfQstn2OfReadingQstn = (TextView)findViewById(R.id.resultOfQstn2OfReadingQstn);
        resultOfQstn3OfReadingQstn = (TextView)findViewById(R.id.resultOfQstn3OfReadingQstn);
        resultOfQstn4OfReadingQstn = (TextView)findViewById(R.id.resultOfQstn4OfReadingQstn);
//        answerOfQstn1ReadingQstn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                answerOfQstn1ReadingQstn.setFocusable(true);
//                answerOfQstn1ReadingQstn.setFocusableInTouchMode(true);
//            }
//        });

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Listening Practics");
        getSupportActionBar().setSubtitle("Free Training");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        buttonPlayPause1 = (Button) findViewById(R.id.buttonPlayPause1);
        buttonPlayPause2 = (Button) findViewById(R.id.buttonPlayPause2);
        buttonPlayPause3 = (Button) findViewById(R.id.buttonPlayPause3);
        buttonPlayPause4 = (Button) findViewById(R.id.buttonPlayPause4);

        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);

        handler = new Handler();
        mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        track1IsPlaying = false;
        track2IsPlaying = false;
        track3IsPlaying = false;
        track4IsPlaying = false;
        handlerHasCallBacks = false;

        tracks = new int[]{ R.raw.reading_ques_1, R.raw.reading_ques_2, R.raw.reading_ques_3, R.raw.reading_ques_4 };

        mediaPlayer = MediaPlayer.create(getApplicationContext(), tracks[0]);

        buttonPlayPause1.setOnClickListener(this);
        buttonPlayPause2.setOnClickListener(this);
        buttonPlayPause3.setOnClickListener(this);
        buttonPlayPause4.setOnClickListener(this);

        MySeekbarListener seekbarListener = new MySeekbarListener();

        seekBar1.setOnSeekBarChangeListener(seekbarListener);
        seekBar2.setOnSeekBarChangeListener(seekbarListener);
        seekBar3.setOnSeekBarChangeListener(seekbarListener);
        seekBar4.setOnSeekBarChangeListener(seekbarListener);

        /*mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.pause();
                mp.seekTo(0);
                seekBar1.setProgress(0);
                buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_play);
                track1IsPlaying = false;
                stopPlaying();
                currentTrack = -1;
                updatePlayState();
            }
        });*/

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    //end of OnCreate

    public void clickReadingQstn1(View view)
    {
        mgr.hideSoftInputFromWindow(answerOfQstn1ReadingQstn.getWindowToken(), 0);
        String resultOfQstn1  = answerOfQstn1ReadingQstn.getText().toString().toLowerCase();
        if(resultOfQstn1.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Please type your answer", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(resultOfQstn1.equals("eighteen dollars"))
            {
                resultOfQstn1OfReadingQstn.setText("Your answer is correct");
                resultOfQstn1OfReadingQstn.setTextColor(Color.GREEN);
            }
            else
            {
                resultOfQstn1OfReadingQstn.setText("Wrong answer! Correct answer is: eighteen dollars");
                resultOfQstn1OfReadingQstn.setTextColor(Color.RED);
            }
            resultOfQstn1OfReadingQstn.setVisibility(View.VISIBLE);
        }
    }
    public void clickReadingQstn2(View view)
    {
        mgr.hideSoftInputFromWindow(answerOfQstn2ReadingQstn.getWindowToken(), 0);
        String resultOfQstn1  = answerOfQstn2ReadingQstn.getText().toString().toLowerCase();
        if(resultOfQstn1.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Please type your answer", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(resultOfQstn1.equals("manager"))
            {
                resultOfQstn2OfReadingQstn.setText("Your answer is correct");
                resultOfQstn2OfReadingQstn.setTextColor(Color.GREEN);
            }
            else
            {
                resultOfQstn2OfReadingQstn.setText("Wrong answer! Correct answer is: manager");
                resultOfQstn2OfReadingQstn.setTextColor(Color.RED);
            }
            resultOfQstn2OfReadingQstn.setVisibility(View.VISIBLE);
        }
    }
    public void selectItem(View view)
    {
        boolean checked = ((CheckBox)view).isChecked();
        switch (view.getId())
        {
            case R.id.checkboxOption1ReadingQstn:
                if(checked)
                {
                    correctSelectionList.add("dog");
                }
                else {
                    correctSelectionList.remove("dog");
                }
                break;
            case R.id.checkboxOption2ReadingQstn:
                if(checked)
                {
                    correctSelectionList.add("cat");
                }
                else
                {
                    correctSelectionList.remove("cat");
                }
                break;
            case R.id.checkboxOption3ReadingQstn:
                if(checked)
                {
                    wrongSelectionList.add("parrot");
                }
                else
                {
                    wrongSelectionList.remove("parrot");
                }
                break;
            case R.id.checkboxOption4ReadingQstn:
                if(checked)
                {
                    wrongSelectionList.add("goldfish");
                }
                else
                {
                    wrongSelectionList.remove("goldfish");
                }
                break;
        }
    }
    public void checkboxResult(View view)
    {
        //Toast.makeText(getApplicationContext(), "Size "+ correctSelectionList.size()+" "+wrongSelectionList.size(), Toast.LENGTH_SHORT).show();
        if(correctSelectionList.size() == 0 && wrongSelectionList.size() == 0)
        {
            Toast.makeText(getApplicationContext(),"Please select option(s) to check your answer",Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(correctSelectionList.size() == 2 && wrongSelectionList.size() == 0)
            {
                resultOfQstn3OfReadingQstn.setText("Correct answer");
                resultOfQstn3OfReadingQstn.setTextColor(Color.GREEN);
            }
            else
            {
                resultOfQstn3OfReadingQstn.setText("Wrong!! Listen again and tick correct answers");
                resultOfQstn3OfReadingQstn.setTextColor(Color.RED);
            }
            resultOfQstn3OfReadingQstn.setVisibility(View.VISIBLE);
        }
    }
    public void clickReadingQstn4(View view)
    {
        mgr.hideSoftInputFromWindow(answerOfQstn4ReadingQstn.getWindowToken(), 0);
        String resultOfQstn4  = answerOfQstn4ReadingQstn.getText().toString().toLowerCase();
        if(resultOfQstn4.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Please type your answer", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(resultOfQstn4.equals("ten years"))
            {
                resultOfQstn4OfReadingQstn.setText("Your answer is correct");
                resultOfQstn4OfReadingQstn.setTextColor(Color.GREEN);
            }
            else
            {
                resultOfQstn4OfReadingQstn.setText("Wrong answer! Correct answer is: ten years");
                resultOfQstn4OfReadingQstn.setTextColor(Color.RED);
            }
            resultOfQstn4OfReadingQstn.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonPlayPause1:
                if(currentTrack != 0) {
                    stopPlaying();
                    currentTrack = 0;
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), tracks[currentTrack]);
                    seekBar1.setMax(mediaPlayer.getDuration());
                    seekBar1.setProgress(0);
                }

                if(!track1IsPlaying) {
                    updatePlayState();
                    buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_pause_light);
                    mediaPlayer.start();
                    playCycle(seekBar1);
                    track1IsPlaying = true;
                } else {
                    buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_play_light);
                    mediaPlayer.pause();
                    track1IsPlaying = false;
                }
                break;

            case R.id.buttonPlayPause2:
                if(currentTrack != 1) {
                    stopPlaying();
                    currentTrack = 1;
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), tracks[currentTrack]);
                    seekBar2.setMax(mediaPlayer.getDuration());
                }

                if(!track2IsPlaying) {
                    updatePlayState();

                    buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_pause_light);
                    mediaPlayer.start();
                    playCycle(seekBar2);
                    track2IsPlaying = true;
                } else {
                    buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_play_light);
                    mediaPlayer.pause();
                    track2IsPlaying = false;
                }
                break;

            case R.id.buttonPlayPause3:
                if(currentTrack != 2) {
                    stopPlaying();
                    currentTrack = 2;
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), tracks[currentTrack]);
                    seekBar3.setMax(mediaPlayer.getDuration());
                }

                if(!track3IsPlaying) {
                    updatePlayState();

                    buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_pause_light);
                    mediaPlayer.start();
                    playCycle(seekBar3);
                    track3IsPlaying = true;
                } else {
                    buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_play_light);
                    mediaPlayer.pause();
                    track3IsPlaying = false;
                }
                break;

            case R.id.buttonPlayPause4:
                if(currentTrack != 3) {
                    stopPlaying();
                    currentTrack = 3;
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), tracks[currentTrack]);
                    seekBar4.setMax(mediaPlayer.getDuration());
                }

                if(!track4IsPlaying) {
                    updatePlayState();

                    buttonPlayPause4.setBackgroundResource(R.drawable.ic_media_pause_light);
                    mediaPlayer.start();
                    playCycle(seekBar4);
                    track4IsPlaying = true;
                } else {
                    buttonPlayPause4.setBackgroundResource(R.drawable.ic_media_play_light);
                    mediaPlayer.pause();
                    track4IsPlaying = false;
                }
                break;

        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.pause();
                mp.seekTo(0);
                currentTrack = -1;
                updatePlayState();
            }
        });
    }

    private void updatePlayState() {
        track1IsPlaying = false;
        track2IsPlaying = false;
        track3IsPlaying = false;
        track4IsPlaying = false;

        buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_play_light);
        buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_play_light);
        buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_play_light);
        buttonPlayPause4.setBackgroundResource(R.drawable.ic_media_play_light);

        seekBar1.setProgress(0);
        seekBar2.setProgress(0);
        seekBar3.setProgress(0);
        seekBar4.setProgress(0);

        if(handlerHasCallBacks) {
            handler.removeCallbacks(runnable);
            handlerHasCallBacks = false;
        }
    }

    public void playCycle(final SeekBar seekBar) {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        if(mediaPlayer.isPlaying()) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    playCycle(seekBar);
                }
            };
            handler.postDelayed(runnable, 100);
            handlerHasCallBacks = true;
        }
    }

    public void stopPlaying() {
        if (mediaPlayer != null) {
            //mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    class MySeekbarListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if(fromUser) {
                mediaPlayer.seekTo(progress);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer.isPlaying()) {
            stopPlaying();
            updatePlayState();
            currentTrack = -1;
        }
    }

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        if(handlerHasCallBacks) {
            handler.removeCallbacks(runnable);
        }

    }*/

    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }*/
}