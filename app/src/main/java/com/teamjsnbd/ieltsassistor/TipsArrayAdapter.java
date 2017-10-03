package com.teamjsnbd.ieltsassistor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hussain Juned on 30/07/2017.
 */

public class TipsArrayAdapter extends ArrayAdapter<Tips> {

    private Activity context;
    private List<Tips> listOfTips;

    public TipsArrayAdapter(Activity context, List<Tips> listOfTips) {
        super(context, R.layout.list_demo_layout, listOfTips);
        this.context = context;
        this.listOfTips = listOfTips;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View listViewItem = layoutInflater.inflate(R.layout.list_demo_layout, null, true);

        TextView textViewTipsTitle = (TextView) listViewItem.findViewById(R.id.textViewTipsTitle);
        TextView textViewTipsBody = (TextView) listViewItem.findViewById(R.id.textViewTipsBody);

        Tips tips = listOfTips.get(position);
        String title = tips.getTipsTitle();
        String body = tips.getTipsBody();
        body = body.replace("\\n", System.getProperty("line.separator"));

        textViewTipsTitle.setText(title);
        textViewTipsBody.setText(body);

        return listViewItem;

    }
}
