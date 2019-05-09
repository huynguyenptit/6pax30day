package com.changelanguage.a6paxin30days.model;

public class Users {
    private int mID;
    private String mUSERNAME;
    private String mPassword;
    private int mTall;
    private int mWeight;

    public Users(int mID, String mUSERNAME, String mPassword, int mTall, int mWeight) {
        this.mID = mID;
        this.mUSERNAME = mUSERNAME;
        this.mPassword = mPassword;
        this.mTall = mTall;
        this.mWeight = mWeight;
    }

    public Users(String mUSERNAME, String mPassword, int mTall, int mWeight) {
        this.mUSERNAME = mUSERNAME;
        this.mPassword = mPassword;
        this.mTall = mTall;
        this.mWeight = mWeight;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmUSERNAME() {
        return mUSERNAME;
    }

    public void setmUSERNAME(String mUSERNAME) {
        this.mUSERNAME = mUSERNAME;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public int getmTall() {
        return mTall;
    }

    public void setmTall(int mTall) {
        this.mTall = mTall;
    }

    public int getmWeight() {
        return mWeight;
    }

    public void setmWeight(int mWeight) {
        this.mWeight = mWeight;
    }
}
