package com.teamjsnbd.ieltsassistor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutIelts extends AppCompatActivity {
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_ielts);
        descriptions = getResources().getStringArray(R.array.details);
    }

    public void whatisielts(View view)
    {
        String about = descriptions[0];
        Intent intent = new Intent(AboutIelts.this, IeltsDescription.class);
        intent.putExtra("doro", about);
        startActivity(intent);
    }
    public void detailslistening(View view)
    {
        String about = descriptions[1];
        Intent intent = new Intent(AboutIelts.this, IeltsDescription.class);
        intent.putExtra("doro", about);
        startActivity(intent);
    }
    public void detailsreading(View view)
    {
        String about = descriptions[2];
        Intent intent = new Intent(AboutIelts.this, IeltsDescription.class);
        intent.putExtra("doro", about);
        startActivity(intent);
    }
    public void detailswriting(View view)
    {
        String about = descriptions[3];
        Intent intent = new Intent(AboutIelts.this, IeltsDescription.class);
        intent.putExtra("doro", about);
        startActivity(intent);
    }
    public void detailsspeaking(View view)
    {
        String about = descriptions[4];
        Intent intent = new Intent(AboutIelts.this, IeltsDescription.class);
        intent.putExtra("doro", about);
        startActivity(intent);
    }
    public void scoreingsystem(View view)
    {
        String about = descriptions[5];
        Intent intent = new Intent(AboutIelts.this, IeltsDescription.class);
        intent.putExtra("doro", about);
        startActivity(intent);
    }
}
