package com.changelanguage.a6paxin30days.model;

import org.w3c.dom.Text;

public class Schedules {
    private int mID;
    private String mTITLE;
    private String mIMAGE;
    private String mCONTENT;

    public Schedules(int mID, String mTITLE, String mIMAGE, String mCONTENT) {
        this.mID = mID;
        this.mTITLE = mTITLE;
        this.mIMAGE = mIMAGE;
        this.mCONTENT = mCONTENT;
    }

    public Schedules(String mTITLE, String mIMAGE, String mCONTENT) {
        this.mTITLE = mTITLE;
        this.mIMAGE = mIMAGE;
        this.mCONTENT = mCONTENT;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmTITLE() {
        return mTITLE;
    }

    public void setmTITLE(String mTITLE) {
        this.mTITLE = mTITLE;
    }

    public String getmIMAGE() {
        return mIMAGE;
    }

    public void setmIMAGE(String mIMAGE) {
        this.mIMAGE = mIMAGE;
    }

    public String getmCONTENT() {
        return mCONTENT;
    }

    public void setmCONTENT(String mCONTENT) {
        this.mCONTENT = mCONTENT;
    }
}
