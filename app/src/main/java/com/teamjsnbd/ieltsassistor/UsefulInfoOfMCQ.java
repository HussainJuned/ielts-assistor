package com.teamjsnbd.ieltsassistor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UsefulInfoOfMCQ extends AppCompatActivity {

    Button btnTipsMCQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_info_of_mcq);

        btnTipsMCQ = (Button) findViewById(R.id.btnTipsMCQ);

        btnTipsMCQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsefulInfoOfMCQ.this, MCQ.class);
                intent.putExtra("passage_no", 1);
                startActivity(intent);
                finish();
            }
        });

    }
}
