package com.example.administrator.myloginui;

import android.media.Image;

/**
 * Created by Administrator on 2018/12/2.
 */

public class sings {
    private String singsNum;
    private int imageid;
    private String singsItem;

    public sings(String singsNum, int imageid, String singsName) {
        this.singsNum = singsNum;
        this.imageid = imageid;
        this.singsItem = singsName;
    }

    public String getSingsNum() {
        return singsNum;
    }

    public int getImageid() {
        return imageid;
    }

    public String getSingsName() {
        return singsItem;
    }
}
