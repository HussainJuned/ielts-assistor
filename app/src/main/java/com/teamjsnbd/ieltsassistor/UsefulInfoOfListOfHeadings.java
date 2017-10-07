package com.teamjsnbd.ieltsassistor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UsefulInfoOfListOfHeadings extends AppCompatActivity {

    Button btnTipsLOH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_info_of_list_of_headings);

        btnTipsLOH = (Button) findViewById(R.id.btnTipsLOH);

        btnTipsLOH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsefulInfoOfListOfHeadings.this, PracticeListOfHeadings.class);
                intent.putExtra("passage_no", 1);
                startActivity(intent);
                finish();
            }
        });

    }
}
