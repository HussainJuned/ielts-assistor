package com.teamjsnbd.ieltsassistor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewFullReadingTest extends AppCompatActivity {

    private RecyclerView frtRecyclerView;
    private RecyclerView.Adapter frtAdapter;
    private RecyclerView.LayoutManager layoutManager;

    String[] frtActionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_full_reading_test);

        frtActionName = getResources().getStringArray(R.array.fullReadingTestActionName);

        frtRecyclerView = (RecyclerView) findViewById(R.id.fullReadingTestRecyclerView);
        frtAdapter = new FRTRecyclerAdapter(frtActionName, this);
        layoutManager = new LinearLayoutManager(this);
        frtRecyclerView.setLayoutManager(layoutManager);
        frtRecyclerView.setHasFixedSize(true);
        frtRecyclerView.setAdapter(frtAdapter);
    }
}
