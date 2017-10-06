package com.teamjsnbd.ieltsassistor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hussain Juned on 05/10/2017.
 */

public class TFRecyclerAdapter extends RecyclerView.Adapter<TFRecyclerAdapter.TFRecyclerViewHolder> {

    String[] actionName;
    Context context;
    public static String className;

    public TFRecyclerAdapter(String[] actionName, Context context) {
        this.actionName = actionName;
        this.context = context;
        className = context.getClass().getSimpleName();
    }

    @Override
    public TFRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_row, parent, false);
        TFRecyclerViewHolder tfRecyclerViewHolder = new TFRecyclerViewHolder(view, context);
        return tfRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(TFRecyclerViewHolder holder, int position) {
        holder.textViewRecyclerViewRow.setText(actionName[position]);
    }

    @Override
    public int getItemCount() {
        return actionName.length;
    }

    public static class TFRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewRecyclerViewRow;
        Context context;

        public TFRecyclerViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            textViewRecyclerViewRow = (TextView) itemView.findViewById(R.id.textViewRecyclerViewRow);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int actionPosition = getAdapterPosition();
            //Toast.makeText(context, "you are going " + className, Toast.LENGTH_SHORT).show();
            if (actionPosition == 0) {
                if(className.equals("TrueFalsePassagesListActivity")){
                    Intent intent = new Intent(context, UsefulInfoOfTrueFalseType.class);
                    this.context.startActivity(intent);
                } else if(className.equals("ClassificationSelection")){
                    Intent intent = new Intent(context, UsefulInfoOfClassificationSelection.class);
                    this.context.startActivity(intent);
                }

            } else {
                {
                    if(className.equals("TrueFalsePassagesListActivity")){
                        Intent intent = new Intent(context, PracticeTrueFalseType.class);
                        intent.putExtra("passage_no", actionPosition);
                        this.context.startActivity(intent);
                    } else if (className.equals("ClassificationSelection")) {
                        Intent intent = new Intent(context, PracticeClassificationSelection.class);
                        intent.putExtra("passage_no", actionPosition);
                        this.context.startActivity(intent);
                    }
                }

            }
        }
    }
}
