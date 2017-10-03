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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class ListeningDrawAttentionPractice extends AppCompatActivity implements View.OnClickListener{
    private EditText answerOfQstn1OfAttention;
    private EditText answerOfQstn2OfAttention;
    private EditText answerOfQstn4OfAttention;

    private TextView resultOfQstn1OfAttention;
    private TextView resultOfQstn2OfAttention;
    private TextView resultOfQstn3OfAttention;
    private TextView resultOfQstn4OfAttention;

    private RadioGroup radioGroup;
    private RadioButton radioOption1;
    private RadioButton radioOption2;
    private RadioButton radioOption3;

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
        setContentView(R.layout.activity_listening_draw_attention_practice);



        answerOfQstn1OfAttention = (EditText)findViewById(R.id.answerOfQstn1OfAttention);
        answerOfQstn2OfAttention = (EditText)findViewById(R.id.answerOfQstn2OfAttention);
        answerOfQstn4OfAttention = (EditText)findViewById(R.id.answerOfQstn4OfAttention);

        resultOfQstn1OfAttention = (TextView)findViewById(R.id.resultOfQstn1OfAttention);
        resultOfQstn2OfAttention = (TextView)findViewById(R.id.resultOfQstn2OfAttention);
        resultOfQstn3OfAttention = (TextView)findViewById(R.id.resultOfQstn3OfAttention);
        resultOfQstn4OfAttention = (TextView)findViewById(R.id.resultOfQstn4OfAttention);

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

        tracks = new int[]{ R.raw.attention_ques1, R.raw.attention_ques2, R.raw.attention_ques3, R.raw.attention_ques4 };

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


        radioGroup = (RadioGroup) findViewById(R.id.radioGroupDistraction);
        radioOption1 = (RadioButton) findViewById(R.id.radioOption1Distraction);
        radioOption2 = (RadioButton) findViewById(R.id.radioOption2Distraction);
        radioOption3 = (RadioButton) findViewById(R.id.radioOption3Distraction);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch (checkId)
                {
                    case R.id.radioOption1Distraction:
                        resultOfQstn3OfAttention.setText("Answer is correct");
                        resultOfQstn3OfAttention.setTextColor(Color.GREEN);
                        break;
                    case R.id.radioOption2Distraction:
                        resultOfQstn3OfAttention.setText("Wrong answer, listen again carefully");
                        resultOfQstn3OfAttention.setTextColor(Color.RED);
                        break;
                    case R.id.radioOption3Distraction:
                        resultOfQstn3OfAttention.setText("Wrong answer, listen again carefully");
                        resultOfQstn3OfAttention.setTextColor(Color.RED);
                        break;
                }
                resultOfQstn3OfAttention.setVisibility(View.VISIBLE);
            }
        });

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

    public void clickAttentionQstn1(View view)
    {
        mgr.hideSoftInputFromWindow(answerOfQstn4OfAttention.getWindowToken(), 0);
        String attentionListenqstn1 = answerOfQstn1OfAttention.getText().toString().toLowerCase();
        if(attentionListenqstn1.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Please type your answer here", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(attentionListenqstn1.equals("no meat"))
            {
                resultOfQstn1OfAttention.setText("Answer is correct");
                resultOfQstn1OfAttention.setVisibility(View.VISIBLE);
            }
            else if(attentionListenqstn1.equals("vegetarian"))
            {
                resultOfQstn1OfAttention.setText("Answer is correct");
                resultOfQstn1OfAttention.setVisibility(View.VISIBLE);
            }
            else
            {
                resultOfQstn1OfAttention.setText("Answer is incorrect, Correct answer: no meat/vegetarian");
                resultOfQstn1OfAttention.setVisibility(View.VISIBLE);
            }
        }

    }
    public void clickAttentionQstn2(View view)
    {
        mgr.hideSoftInputFromWindow(answerOfQstn4OfAttention.getWindowToken(), 0);
        String attentionListenqstn1 = answerOfQstn2OfAttention.getText().toString();
        if(attentionListenqstn1.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Please type your answer here", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(attentionListenqstn1.equals("1157432"))
            {
                resultOfQstn2OfAttention.setText("Answer is correct");
            }
            else
            {
                resultOfQstn2OfAttention.setText("Answer is incorrect, Correct answer: 1157432");
            }
            resultOfQstn2OfAttention.setVisibility(View.VISIBLE);
        }

    }

    public void clickAttentionQstn4(View view)
    {
        mgr.hideSoftInputFromWindow(answerOfQstn4OfAttention.getWindowToken(), 0);

        String attentionListenqstn1 = answerOfQstn4OfAttention.getText().toString();
        if(attentionListenqstn1.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Please type your answer here", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(attentionListenqstn1.equals("14"))
            {
                resultOfQstn4OfAttention.setText("Answer is correct");
            }
            else
            {
                resultOfQstn4OfAttention.setText("Answer is incorrect, Correct answer: 14");
            }
            resultOfQstn4OfAttention.setVisibility(View.VISIBLE);
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
                    buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_pause_dark);
                    mediaPlayer.start();
                    playCycle(seekBar1);
                    track1IsPlaying = true;
                } else {
                    buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_play_dark);
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

                    buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_pause_dark);
                    mediaPlayer.start();
                    playCycle(seekBar2);
                    track2IsPlaying = true;
                } else {
                    buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_play_dark);
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

                    buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_pause_dark);
                    mediaPlayer.start();
                    playCycle(seekBar3);
                    track3IsPlaying = true;
                } else {
                    buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_play_dark);
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

                    buttonPlayPause4.setBackgroundResource(R.drawable.ic_media_pause_dark);
                    mediaPlayer.start();
                    playCycle(seekBar4);
                    track4IsPlaying = true;
                } else {
                    buttonPlayPause4.setBackgroundResource(R.drawable.ic_media_play_dark);
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

        buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_play_dark);
        buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_play_dark);
        buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_play_dark);
        buttonPlayPause4.setBackgroundResource(R.drawable.ic_media_play_dark);

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
}
