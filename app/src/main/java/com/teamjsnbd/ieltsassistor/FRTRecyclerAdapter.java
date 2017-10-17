package com.teamjsnbd.ieltsassistor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nuur on 10/17/2017.
 */

class FRTRecyclerAdapter extends RecyclerView.Adapter<FRTRecyclerAdapter.FRTRecyclerViewHolder> {
    String[] actionName;
    Context context;
    public static String className;

    public FRTRecyclerAdapter(String[] actionName, Context context) {
        this.actionName = actionName;
        this.context = context;
        className = context.getClass().getSimpleName();
    }

    @Override
    public FRTRecyclerAdapter.FRTRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_row, parent, false);
        FRTRecyclerAdapter.FRTRecyclerViewHolder FRTRecyclerViewHolder = new FRTRecyclerAdapter.FRTRecyclerViewHolder(view, context);
        return FRTRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(FRTRecyclerAdapter.FRTRecyclerViewHolder holder, int position) {
        holder.textViewRecyclerViewRow.setText(actionName[position]);
    }

    @Override
    public int getItemCount() {
        return actionName.length;
    }

    public static class FRTRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewRecyclerViewRow;
        Context context;

        public FRTRecyclerViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            textViewRecyclerViewRow = (TextView) itemView.findViewById(R.id.textViewRecyclerViewRow);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int actionPosition = getAdapterPosition();
            //Toast.makeText(context, "you are going " + className, Toast.LENGTH_SHORT).show();

            switch (actionPosition) {
                case 0:
                    Intent intent1 = new Intent(context, RTFActivty1.class);
                   intent1.putExtra("fullReadingTestNo", 0);
                    context.startActivity(intent1);
                    break;
                case 1:
                    Intent intent2 = new Intent(context, RTFActivty1.class);
                    intent2.putExtra("fullReadingTestNo", 1);
                    context.startActivity(intent2);
                    break;
                case 2:
                    //
            }

        }
    }
}
