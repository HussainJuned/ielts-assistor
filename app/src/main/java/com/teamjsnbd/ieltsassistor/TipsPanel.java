package com.teamjsnbd.ieltsassistor;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TipsPanel extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    DatabaseReference tipsReference;

    EditText editTextTipsTitle;
    EditText editTextTipsBody;
    Button buttonUploadTips;
    ListView listViewAllTips;

    EditText editTextTitle;
    EditText editTextBody;

    List<Tips> tipsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_panel);

        firebaseAuth = FirebaseAuth.getInstance();
        tipsReference = FirebaseDatabase.getInstance().getReference("Tips");

        tipsList = new ArrayList<>();

        editTextTipsTitle = (EditText) findViewById(R.id.editTextTipsTitle);
        editTextTipsBody = (EditText) findViewById(R.id.editTextTipsBody);
        listViewAllTips = (ListView) findViewById(R.id.listViewAllTips);
        buttonUploadTips = (Button) findViewById(R.id.buttonUploadTips);

        buttonUploadTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadTips();
            }
        });


        listViewAllTips.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Tips tip = tipsList.get(position);
                shoUpdateDeleteDialog(tip.getTipsId(), tip.getTipsTitle(), tip.getTipsBody());
                return true;
            }
        });
    }

    private void uploadTips() {
        String title = editTextTipsTitle.getText().toString().trim();
        String body = editTextTipsBody.getText().toString().trim();

        if (!TextUtils.isEmpty(title)) {
            if(!TextUtils.isEmpty(body)) {

                String id = tipsReference.push().getKey();
                Tips tip = new Tips(id, title, body);

                tipsReference.child(id).setValue(tip).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Tip Added Successfully", Toast.LENGTH_SHORT).show();
                            editTextTipsTitle.setText(null);
                            editTextTipsBody.setText(null);
                        } else {
                            Toast.makeText(getApplicationContext(), "Error Adding Tip", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            } else {
                Toast.makeText(this, "Please Write Some Tip in Details", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please Insert a Title of the Tip", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        tipsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                tipsList.clear();

                for(DataSnapshot allTipsSnapshot : dataSnapshot.getChildren()) {
                    Tips tip = allTipsSnapshot.getValue(Tips.class);
                    tipsList.add(tip);
                }

                TipsArrayAdapter adapter = new TipsArrayAdapter(TipsPanel.this, tipsList);
                listViewAllTips.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Toast.makeText(Admin.this, "Retrieving From Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void shoUpdateDeleteDialog(final String tipId, final String tipTitle, final String tipBody) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        editTextTitle = (EditText) dialogView.findViewById(R.id.dialogEditTextTitle);
        editTextBody = (EditText) dialogView.findViewById(R.id.dialogEditTextBody);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdateTip);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteTip);

        editTextTitle.setText(tipTitle);
        editTextBody.setText(tipBody);

        dialogBuilder.setTitle("Chose Action");
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString().trim();
                String body = editTextBody.getText().toString().trim();
                if (!TextUtils.isEmpty(title)) {
                    if(!TextUtils.isEmpty(body)) {
                        updateTip(tipId, title, body);
                        b.dismiss();
                    } else {
                        Toast.makeText(TipsPanel.this, "please insert some text", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(TipsPanel.this, "please insert some text", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteTip(tipId);
                b.dismiss();

            }
        });
    }

    private boolean updateTip(String tipId, String title, String body) {

        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("Tips").child(tipId);

        Tips tip = new Tips(tipId, title, body);
        dr.setValue(tip);
        Toast.makeText(this, "Tip Updated Successfully", Toast.LENGTH_SHORT).show();

        return true;
    }

    private boolean deleteTip(String tipId) {
        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("Tips").child(tipId);
        dr.removeValue();
        Toast.makeText(this, "Tip Deleted Successfully", Toast.LENGTH_SHORT).show();

        return true;
    }
}
