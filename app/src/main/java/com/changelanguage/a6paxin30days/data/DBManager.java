package com.changelanguage.a6paxin30days.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.changelanguage.a6paxin30days.model.Users;

public class DBManager extends SQLiteOpenHelper {
    private static final String DB_NAME = "db_6pax";
    private static final int DB_VERSION = 1;
    private final String Tag = "DBManager";

    /**
     * Users table
     * */
    private static final String TABLE_USERS = "tbl_user";
    private static final String COLUMN_USER_ID = "id";
    private static final String COLUMN_USER_USERNAME = "username";
    private static final String COLUMN_USER_PASSWORD = "password";
    private static final String COLUMN_USER_TALL = "tall";
    private static final String COLUMN_USER_WEIGHT = "weight";

    /**
     * Schedules table
     * */
    private static final String TABLE_SCHEDULES = "tbl_schedules";
    private static final String COLUMN_SCHEDULES_ID = "id";
    private static final String COLUMN_SCHEDULES_CONTENT = "content";
    private static final String COLUMN_SCHEDULES_TITLE = "title";
    private static final String COLUMN_SCHEDULES_DAY = "day";
    private static final String COLUMN_SCHEDULES_STATUS = "status";
    private static final String COLUMN_SCHEDULES_IMAGE_SRC = "image_src";

    /**
     * Q&A table
     * */
    private static final String TABLE_QA = "tbl_qa";
    private static final String COLUMN_QA_ID = "id";
    private static final String COLUMN_QA_TITLE = "title";
    private static final String COLUMN_QA_CONTENT = "content";
    private static final String COLUMN_QA_COVER_IMG = "cover_img";

    /**
     * CREATE USERS TABLE
     * */
    private static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_USERS + " ("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_USER_PASSWORD + " TEXT NOT NULL, "
            + COLUMN_USER_TALL + " INT, "
            + COLUMN_USER_USERNAME + " TEXT, "
            + COLUMN_USER_WEIGHT + " INT)";
    /**
     * CREATE SCHEDULES TABLE
     * */
    private String CREATE_SCHEDULES_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_SCHEDULES + " ("
            + COLUMN_SCHEDULES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SCHEDULES_CONTENT + " TEXT, "
            + COLUMN_SCHEDULES_TITLE + " TEXT, "
            + COLUMN_SCHEDULES_IMAGE_SRC + " TEXT, "
            + COLUMN_SCHEDULES_STATUS + " INT, "
            + COLUMN_SCHEDULES_DAY + " INT)";
    /**
     * CREATE QA TABLE
     * */
    private static final String CREATE_QA_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_QA + " ("
            + COLUMN_QA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_QA_TITLE + " TEXT, "
            + COLUMN_QA_CONTENT + " TEXT, "
            + COLUMN_QA_COVER_IMG + " TEXT)";

    public DBManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(Tag,"DBManager");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_QA_TABLE);
//        db.execSQL(CREATE_SCHEDULES_TABLE);
        db.execSQL(CREATE_USERS_TABLE);
        Log.d(Tag,"OnCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(Tag,"Update");
    }

    public void addUser(Users users){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_USERNAME,users.getmUSERNAME());
        values.put(COLUMN_USER_PASSWORD,users.getmPassword());
        values.put(COLUMN_USER_TALL,users.getmTall());
        values.put(COLUMN_USER_WEIGHT, users.getmWeight());
        db.insert(TABLE_USERS,null,values);
        Log.d(Tag,"Add User Successfully");
    }

    public void checkLogin (String username, String password, SQLiteDatabase db){
        String get_user_by_username = "SELECT * FROM " + TABLE_USERS + " where " + COLUMN_USER_USERNAME + "=" + username;
        Cursor user;
//        user = (Cursor) db.query(get_user_by_username);
//        if (get_user_by_username.)
//        return null;
    }

}
