package com.teamjsnbd.ieltsassistor;

/**
 * Created by Hussain Juned on 30/07/2017.
 */

public class Tips {

    String tipsId;
    String tipsTitle;
    String tipsBody;

    public Tips() {

    }

    public Tips(String tipsId, String tipsTitle, String tipsBody) {
        this.tipsId = tipsId;
        this.tipsTitle = tipsTitle;
        this.tipsBody = tipsBody;
    }

    public String getTipsId() {
        return tipsId;
    }

    public String getTipsTitle() {
        return tipsTitle;
    }

    public String getTipsBody() {
        return tipsBody;
    }
}
