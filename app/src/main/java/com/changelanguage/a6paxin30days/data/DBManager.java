package com.changelanguage.a6paxin30days.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

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

    public Users getUser (String username){
        if (username != null){
            String countQuery = "SELECT  * FROM " + TABLE_USERS + " WHERE " + COLUMN_USER_USERNAME + " = '"+ username + "' LIMIT 1";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(countQuery, null);
//            Users user = new Users("admin","admin",148,50);
//            return user;
            if (cursor.getCount() > 0){
                cursor.moveToFirst();
                Integer user_id = cursor.getInt(cursor.getColumnIndex("id"));
                String user_password = cursor.getString(cursor.getColumnIndex("password"));
                Integer user_tall = cursor.getInt(cursor.getColumnIndex("tall"));
                Integer user_weight = cursor.getInt(cursor.getColumnIndex("weight"));
                Users user = new Users(user_id,username,user_password,user_tall,user_weight);
                return user;
            }
        }
        return null;
    }

    public boolean updateUser(Integer id, String password, Integer tall, Integer weight){
        if (password != null || tall != null || weight != null){
            ContentValues update_data = new ContentValues();
            update_data.put("password",password);
            update_data.put("tall", tall);
            update_data.put("weight", weight);
            SQLiteDatabase db = this.getReadableDatabase();
            db.update(TABLE_USERS,update_data,"id = " + id,null);
            return true;
        }
        return false;
    }

    public boolean checkLogin (String username, String password){
        String countQuery = "SELECT  * FROM " + TABLE_USERS + " WHERE " + COLUMN_USER_USERNAME + " = '"+ username + "'"
                + " AND " + COLUMN_USER_PASSWORD + " = '"+ password + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        if (count > 0){
            return true;
        }
        return false;
    }
    public  boolean checkUsernameRegister(String username) {
        String countQuery = "SELECT  * FROM " + TABLE_USERS + " WHERE " + COLUMN_USER_USERNAME + " = '"+ username + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        if (count > 0){
            return false;
        }
        return true;
    }

}
