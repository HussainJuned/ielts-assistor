package com.teamjsnbd.ieltsassistor;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class IeltsDescription extends AppCompatActivity {
    private TextView descriptionTitle;
    private TextView detailsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ielts_description);
        descriptionTitle = (TextView)findViewById(R.id.descriptionTitle);
        detailsView = (TextView)findViewById(R.id.detailsView);
        //Intent intent = getIntent();
        //Bundle bundle = intent.getExtras();
        int strIndex = getIntent().getIntExtra("doro", 0);
        String fetched_text = getResources().getStringArray(R.array.details)[strIndex];

        //detailsView.setText(fetched_text);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            detailsView.setText(Html.fromHtml(fetched_text, Html.FROM_HTML_MODE_COMPACT));
        }
        else
        {
            detailsView.setText(Html.fromHtml(fetched_text));
        }
    }
}
