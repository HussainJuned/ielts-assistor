package com.teamjsnbd.ieltsassistor;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class ListeningMCQPractice extends AppCompatActivity implements View.OnClickListener{

    private boolean buttonPlayPause1StateIsInStart;
    private boolean buttonPlayPause2StateIsInStart;
    private boolean buttonPlayPause3StateIsInStart;



    //<editor-fold desc="Declarations">
    private TextView resultOfQstn1OfMCQPractice;
    private TextView resultOfQstn2OfMCQPractice;
    private TextView resultOfQstn3OfMCQPractice;

    private RadioGroup radioGroup;
    private RadioButton radioOption1;
    private RadioButton radioOption2;
    private RadioButton radioOption3;

    private RadioGroup radioGroup2;
    private RadioButton radioOption2_1;
    private RadioButton radioOption2_2;
    private RadioButton radioOption2_3;

    private RadioGroup radioGroup3;
    private RadioButton radioOption3_1;
    private RadioButton radioOption3_2;
    private RadioButton radioOption3_3;

    private Button buttonPlayPause1;
    private Button buttonPlayPause2;
    private Button buttonPlayPause3;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;

    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;
    private Handler handler;
    private Runnable runnable;
    Toolbar toolbar;
    //</editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening_mcqpractice);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MCQ Practics");
        getSupportActionBar().setSubtitle("Listening Practics");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        handler = new Handler();

        buttonPlayPause1StateIsInStart = false;
        buttonPlayPause2StateIsInStart = false;
        buttonPlayPause3StateIsInStart = false;

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupMcqPractice);
        radioOption1 = (RadioButton) findViewById(R.id.radioOption1McqPractice);
        radioOption2 = (RadioButton) findViewById(R.id.radioOption2McqPractice);
        radioOption3 = (RadioButton) findViewById(R.id.radioOption3McqPractice);
        resultOfQstn1OfMCQPractice = (TextView)findViewById(R.id.resultOfQstn1OfMCQPractice);

        buttonPlayPause1 = (Button) findViewById(R.id.buttonPlayPause1);
        buttonPlayPause2 = (Button) findViewById(R.id.buttonPlayPause2);
        buttonPlayPause3 = (Button) findViewById(R.id.buttonPlayPause3);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);

        if(mediaPlayer1 != null) {
            mediaPlayer1.release();
        }

        mediaPlayer1 = MediaPlayer.create(getApplicationContext(), R.raw.mcq1);
        mediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.mcq2);
        mediaPlayer3 = MediaPlayer.create(getApplicationContext(), R.raw.mcq3);
        //mediaPlayer1.setAudioStreamType(AudioManager.STREAM_MUSIC);

        seekBar1.setMax(mediaPlayer1.getDuration());
        seekBar2.setMax(mediaPlayer2.getDuration());
        seekBar3.setMax(mediaPlayer3.getDuration());
        seekBar1.setProgress(0);
        seekBar2.setProgress(0);
        seekBar3.setProgress(0);

        //<editor-fold desc="seekbar1 listener{...}">
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    mediaPlayer1.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //</editor-fold>

        //<editor-fold desc="seekbar2 listener{...}">
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    mediaPlayer2.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //</editor-fold>

        //<editor-fold desc="seekbar3 listener{...}">
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    mediaPlayer3.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //</editor-fold>


        //<editor-fold desc="mediaPlayer1 listener">
        mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.pause();
                mp.seekTo(0);
                seekBar1.setProgress(0);
                buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_play_light);
                buttonPlayPause1StateIsInStart = false;
            }
        });
        //</editor-fold>


//<editor-fold desc="mediaPlayer2 listener">
        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.pause();
                mp.seekTo(0);
                seekBar2.setProgress(0);
                buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_play_light);
                buttonPlayPause2StateIsInStart = false;
            }
        });
        //</editor-fold>


//<editor-fold desc="mediaPlayer3 listener">
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.pause();
                mp.seekTo(0);
                seekBar3.setProgress(0);
                buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_play_light);
                buttonPlayPause3StateIsInStart = false;
            }
        });
        //</editor-fold>



        //<editor-fold desc="radiogroup listener {...}">
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkID) {
                switch (checkID)
                {
                    case R.id.radioOption1McqPractice:
                        resultOfQstn1OfMCQPractice.setTextColor(Color.RED);
                        resultOfQstn1OfMCQPractice.setText(getResources().getText(R.string.explanationMCQ1));
                        break;
                    case R.id.radioOption2McqPractice:
                        resultOfQstn1OfMCQPractice.setTextColor(Color.RED);
                        resultOfQstn1OfMCQPractice.setText(getResources().getText(R.string.explanationMCQ1));
                        break;
                    case R.id.radioOption3McqPractice:
                        resultOfQstn1OfMCQPractice.setText("Answer is correct");
                        resultOfQstn1OfMCQPractice.setTextColor(Color.GREEN);
                        break;
                }
                resultOfQstn1OfMCQPractice.setVisibility(View.VISIBLE);
            }
        });
        //</editor-fold>

        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroupMcqPractice2);
        radioOption2_1 = (RadioButton) findViewById(R.id.radioOption1McqPractice2);
        radioOption2_2 = (RadioButton) findViewById(R.id.radioOption2McqPractice2);
        radioOption2_3 = (RadioButton) findViewById(R.id.radioOption3McqPractice2);
        resultOfQstn2OfMCQPractice = (TextView)findViewById(R.id.resultOfQstn2OfMCQPractice);

        //<editor-fold desc="radiogroup2 listener{...}">
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkID) {
                switch (checkID)
                {
                    case R.id.radioOption1McqPractice2:
                        resultOfQstn2OfMCQPractice.setText("Answer is correct");
                        resultOfQstn2OfMCQPractice.setTextColor(Color.GREEN);

                        break;
                    case R.id.radioOption2McqPractice2:
                        resultOfQstn2OfMCQPractice.setTextColor(Color.RED);
                        break;
                    case R.id.radioOption3McqPractice2:
                        resultOfQstn2OfMCQPractice.setTextColor(Color.RED);
                        break;
                }
                resultOfQstn2OfMCQPractice.setVisibility(View.VISIBLE);
            }
        });
        //</editor-fold> {{

        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroupMcqPractice3);
        radioOption3_1 = (RadioButton) findViewById(R.id.radioOption1McqPractice3);
        radioOption3_2 = (RadioButton) findViewById(R.id.radioOption2McqPractice3);
        radioOption3_3 = (RadioButton) findViewById(R.id.radioOption3McqPractice3);
        resultOfQstn3OfMCQPractice = (TextView)findViewById(R.id.resultOfQstn3OfMCQPractice);

        //<editor-fold desc="radioGroup3 listener{...}">
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkID) {
                switch (checkID)
                {
                    case R.id.radioOption1McqPractice3:
                        resultOfQstn3OfMCQPractice.setTextColor(Color.RED);
                        break;
                    case R.id.radioOption2McqPractice3:
                        resultOfQstn3OfMCQPractice.setTextColor(Color.RED);
                        break;
                    case R.id.radioOption3McqPractice3:
                        resultOfQstn3OfMCQPractice.setText("Answer is correct");
                        resultOfQstn3OfMCQPractice.setTextColor(Color.GREEN);
                        break;
                }
                resultOfQstn3OfMCQPractice.setVisibility(View.VISIBLE);
            }
        });
        //</editor-fold>

        buttonPlayPause1.setOnClickListener(this);
        buttonPlayPause2.setOnClickListener(this);
        buttonPlayPause3.setOnClickListener(this);

        /*buttonPlayPause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonPlayPause1StateIsInStart == false) {
                    buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_pause_light);
                    mediaPlayer1.start();
                    playCycle();
                    buttonPlayPause1StateIsInStart = true;
                } else {
                    buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_play_light);
                    mediaPlayer1.pause();
                    buttonPlayPause1StateIsInStart = false;
                }
            }
        });*/

    }

    /*Back button */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer1.isPlaying()) {
            buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_play_light);
            mediaPlayer1.pause();
            buttonPlayPause1StateIsInStart = false;
        }

        if(mediaPlayer2.isPlaying()) {
            buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_play_light);
            mediaPlayer2.pause();
            buttonPlayPause2StateIsInStart = false;
        }

        if(mediaPlayer3.isPlaying()) {
            buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_play_light);
            mediaPlayer3.pause();
            buttonPlayPause3StateIsInStart = false;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        /*if(!mediaPlayer1.isPlaying()) {
            mediaPlayer1.start();
            playCycle();
        }*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer1.release();
        mediaPlayer2.release();
        mediaPlayer3.release();
        handler.removeCallbacks(runnable);
    }

    public void playCycle(final MediaPlayer mediaPlayer, final SeekBar seekBar) {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        if(mediaPlayer.isPlaying()) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    playCycle(mediaPlayer, seekBar);
                }
            };
            handler.postDelayed(runnable, 100);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonPlayPause1:
                if(!buttonPlayPause1StateIsInStart) {
                    if(buttonPlayPause2StateIsInStart) {
                        buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_play_light);
                        mediaPlayer2.pause();
                        buttonPlayPause2StateIsInStart = false;
                    }
                    if(buttonPlayPause3StateIsInStart) {
                        buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_play_light);
                        mediaPlayer3.pause();
                        buttonPlayPause3StateIsInStart = false;
                    }
                    buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_pause_light);
                    mediaPlayer1.start();
                    playCycle(mediaPlayer1, seekBar1);
                    buttonPlayPause1StateIsInStart = true;
                } else {
                    buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_play_light);
                    mediaPlayer1.pause();
                    buttonPlayPause1StateIsInStart = false;
                }
                break;

            case R.id.buttonPlayPause2:
                if(!buttonPlayPause2StateIsInStart) {
                    if(buttonPlayPause1StateIsInStart) {
                        buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_play_light);
                        mediaPlayer1.pause();
                        buttonPlayPause1StateIsInStart = false;
                    }
                    if(buttonPlayPause3StateIsInStart) {
                        buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_play_light);
                        mediaPlayer3.pause();
                        buttonPlayPause3StateIsInStart = false;
                    }
                    buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_pause_light);
                    mediaPlayer2.start();
                    playCycle(mediaPlayer2, seekBar2);
                    buttonPlayPause2StateIsInStart = true;
                } else {
                    buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_play_light);
                    mediaPlayer2.pause();
                    buttonPlayPause2StateIsInStart = false;
                }
                break;

            case R.id.buttonPlayPause3:
                if(!buttonPlayPause3StateIsInStart) {
                    if(buttonPlayPause2StateIsInStart) {
                        buttonPlayPause2.setBackgroundResource(R.drawable.ic_media_play_light);
                        mediaPlayer2.pause();
                        buttonPlayPause2StateIsInStart = false;
                    }
                    if(buttonPlayPause1StateIsInStart) {
                        buttonPlayPause1.setBackgroundResource(R.drawable.ic_media_play_light);
                        mediaPlayer1.pause();
                        buttonPlayPause1StateIsInStart = false;
                    }
                    buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_pause_light);
                    mediaPlayer3.start();
                    playCycle(mediaPlayer3, seekBar3);
                    buttonPlayPause3StateIsInStart = true;
                } else {
                    buttonPlayPause3.setBackgroundResource(R.drawable.ic_media_play_light);
                    mediaPlayer3.pause();
                    buttonPlayPause3StateIsInStart = false;
                }
                break;
        }
    }
}
