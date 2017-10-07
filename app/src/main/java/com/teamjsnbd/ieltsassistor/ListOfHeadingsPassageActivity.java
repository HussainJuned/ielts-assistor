package com.teamjsnbd.ieltsassistor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ListOfHeadingsPassageActivity extends AppCompatActivity {

    private RecyclerView tfRecyclerView;
    private RecyclerView.Adapter tfAdapter;
    private RecyclerView.LayoutManager layoutManager;

    String[] tfActionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false_passages_list);

        tfActionName = getResources().getStringArray(R.array.tfActionName);

        tfRecyclerView = (RecyclerView) findViewById(R.id.tfRecyclerView);
        tfAdapter = new TFRecyclerAdapter(tfActionName, this);
        layoutManager = new LinearLayoutManager(this);
        tfRecyclerView.setLayoutManager(layoutManager);
        tfRecyclerView.setHasFixedSize(true);
        tfRecyclerView.setAdapter(tfAdapter);
    }
}
