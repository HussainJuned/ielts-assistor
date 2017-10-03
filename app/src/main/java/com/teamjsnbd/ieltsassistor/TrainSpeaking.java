package com.teamjsnbd.ieltsassistor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import java.util.ArrayList;
import java.util.List;

public class TrainSpeaking extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {
    public static final String API_KEY = "AIzaSyB_Zd0mqe6hjOAZzg5a9fSbpwTvEgyDlcg";
    //public static final String VIDEO_ID = "5UF2eiPaSiQ&list=PLdawRnR9ilZDT-3hoMRe6RysQh1ef63zJ";

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_speaking);
        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Practics MCQ Question");
        getSupportActionBar().setSubtitle("Reading Practics");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        YouTubePlayerFragment youTubePlayerView = (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.youtube_playerSpeaking);

        youTubePlayerView.initialize(API_KEY, this);
    }
    /*Back button */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestricted) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRestricted)
        {
            List<String>videoList = new ArrayList<>();
            videoList.add("n5ohxW5lTIs");
            videoList.add("dzTSh7zwRIM");
            videoList.add("8xzAB3Fe1zQ");
            videoList.add("8xzAB3Fe1zQ");
            videoList.add("KaK-VDFqgHc");
            videoList.add("f5t8EQrg5dI");
            youTubePlayer.cueVideos(videoList);

        }
    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getApplicationContext(), "Failed to initialize the video", Toast.LENGTH_SHORT).show();
    }
}