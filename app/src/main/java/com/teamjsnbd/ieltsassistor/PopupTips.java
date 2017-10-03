package com.teamjsnbd.ieltsassistor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Random;

public class PopupTips extends AppCompatActivity {

    TextView popupTipsTitle;
    TextView popupTipsBody;
    Button buttonClose;
    FirebaseAuth firebaseAuth;

    HashMap<String, String> mapOfKeys;
    int index;

    DatabaseReference popUpReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_tips);

        firebaseAuth = FirebaseAuth.getInstance();



        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .9),  (int) (height * .7));

        buttonClose = (Button) findViewById(R.id.buttonClose);
        popupTipsTitle = (TextView) findViewById(R.id.popUpTipsTitle);
        popupTipsBody = (TextView) findViewById(R.id.popUpTipsBody);

        popUpReference = FirebaseDatabase.getInstance().getReference("Tips");

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                //startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        mapOfKeys = new HashMap<>();
        index = 0;

        popUpReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot mySnapshot : dataSnapshot.getChildren()) {
                    Tips tips = mySnapshot.getValue(Tips.class);
                    String key = tips.getTipsId();
                    String stringIndex = Integer.toString(index);

                    mapOfKeys.put(stringIndex, key);
                    index++;
                }

                String randomIndex;
                Random random = new Random();
                int randomInt = random.nextInt(index);
                randomIndex = Integer.toString(randomInt);

                String randomKey = mapOfKeys.get(randomIndex);

                Query randomTip = popUpReference.orderByChild("tipsId").equalTo(randomKey);
                randomTip.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.exists()) {
                            for (DataSnapshot mySnapshoot : dataSnapshot.getChildren()) {

                                Tips tips = mySnapshoot.getValue(Tips.class);
                                popupTipsTitle.setText(tips.getTipsTitle());
                                String body = tips.getTipsBody();
                                body = body.replace("\\n", System.getProperty("line.separator"));
                                popupTipsBody.setText(body);

                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
