package com.teamjsnbd.ieltsassistor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TrainYourself extends AppCompatActivity implements View.OnClickListener {

    private Button buttonReading;
    private Button buttonWriting;
    private Button buttonListening;
    private Button buttonSpeaking;
    Toolbar toolbar;

    AlertDialog alertDialog;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_yourself);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Free Training");
        getSupportActionBar().setSubtitle("IELTS Assistor");

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        buttonReading = (Button) findViewById(R.id.buttonReading);
        buttonWriting = (Button) findViewById(R.id.buttonWriting);
        buttonListening = (Button) findViewById(R.id.buttonListening);
        buttonSpeaking = (Button) findViewById(R.id.buttonSpeaking);

        buttonReading.setOnClickListener(this);
        buttonWriting.setOnClickListener(this);
        buttonListening.setOnClickListener(this);
        buttonSpeaking.setOnClickListener(this);

        alertDialogBox();
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

        if( v.getId() == R.id.buttonReading) {
            Intent intent = new Intent(getApplicationContext(), TrainReading.class);
            startActivity(intent);
            //finish();
        } else if(v.getId() == R.id.buttonWriting) {
            if(isConnectionOk(TrainYourself.this)) {
                Intent intent = new Intent(getApplicationContext(), TrainWriting.class);
                startActivity(intent);
            } else {
                alertDialog.show();
            }


        } else if (v.getId() == R.id.buttonListening) {
            Intent intent = new Intent(getApplicationContext(), TrainListening.class);
            startActivity(intent);

        } else if(v.getId() == R.id.buttonSpeaking){
            if(isConnectionOk(TrainYourself.this)) {
                Intent intent = new Intent(getApplicationContext(), TrainSpeaking.class);
                startActivity(intent);
            } else {
                alertDialog.show();
            }


        }
    }

    boolean isConnectionOk(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connMgr.getActiveNetworkInfo();

        if(netInfo != null && netInfo.isConnected()) {
            if(netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            } else if(netInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true;
            }
        }
        return false;
    }

    public void alertDialogBox(){
        alertDialogBuilder = new AlertDialog.Builder(TrainYourself.this);
        alertDialogBuilder.setTitle("Unable To Connect with internet");
        alertDialogBuilder.setMessage("Enable Internet?");
        alertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        });
        alertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();

    }
}
