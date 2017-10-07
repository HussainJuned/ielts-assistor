package com.teamjsnbd.ieltsassistor;

import android.content.Context;

/**
 * Created by nuur on 8/29/2017.
 */

public class HeadingLibrary {

    Context context;
    String[] paragraphs;
    String[]  headings;
    String[][] answers = {
            {"iv", "iii", "i", "vi", "v", "ii"},
            {"i", "iv", "v", "iii", "ii", "vi"},
            {"iv", "vi", "ii", "iii", "i", "v"}
    };
    String[] passageHeadings = {"Australia's wild life", "Yoruba Town", "Simplicity reigns at London's biggest design" +
            " festival."};

    public HeadingLibrary(Context context) {
        this.context = context;
        paragraphs = context.getResources().getStringArray(R.array.loh_passage_list);
        headings = context.getResources().getStringArray(R.array.loh_heading_list);
    }

    String getParragraph(int position) {
        String s = paragraphs[position];
        return  s;
    }

    String getHeadings(int position) {
        String s = headings[position];
        return  s;
    }

    String getAnswer(int passageNumber, int index) {
        String s = answers[passageNumber][index];
        return s;
    }

    String getPassageHeading(int passageNumber) {
        String s = passageHeadings[passageNumber];
        return s;
    }
}
