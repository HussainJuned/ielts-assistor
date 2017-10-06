package com.teamjsnbd.ieltsassistor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calculateScore;
    Button trainner;
    Button tipOfTheDay;

    Toolbar toolbar;

    AlertDialog alertDialog;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateScore = (Button) findViewById(R.id.ielts_calculator);
        trainner = (Button) findViewById(R.id.ielts_trainning);
        tipOfTheDay = (Button) findViewById(R.id.ielts_tipOfTheDay);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        alertDialogBox();

    }
    public void about(View v)
    {
        Intent intent = new Intent(this, AboutIelts.class);
        startActivity(intent);
    }

    public void calculate(View v)
    {
        //Toast.makeText(getApplicationContext(), "Going to IeltsCalculator activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, IeltsCalculator.class);
        startActivity(intent);
        overridePendingTransition(R.anim.my_transition, R.anim.j_fade_out);
    }

    public void doTrainning (View v)
    {
        //Toast.makeText(getApplicationContext(), "Going to Train Yourself activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, TrainYourself.class);
        startActivity(intent);
        overridePendingTransition(R.anim.j_fade_in, R.anim.j_fade_out);
    }

    public void findTips(View v)
    {
        /*ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = cm
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo datac = cm
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null & datac != null)
                && (wifi.isConnected() | datac.isConnected())) {
            //connection is avlilable
            Intent intent = new Intent(this, PopupTips.class);
            startActivity(intent);

        }else{
            //no connection
            Toast toast = Toast.makeText(this, "No Internet Connection",
                    Toast.LENGTH_LONG);
            toast.show();
        }*/
        if(isConnectionOk()) {
            Intent intent = new Intent(this, PopupTips.class);
            startActivity(intent);
        } else {
            alertDialog.show();
        }

    }



    boolean isConnectionOk() {
        final ConnectivityManager connMgr = (ConnectivityManager) MainActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
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
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.tipsPanelOption) {
            startActivity(new Intent(this, TipsPanel.class));
        }  if (item.getItemId() == R.id.aboutUsOption) {
            Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
