package com.cit.bcspoliceforum.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CIT on 1/17/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "bcs_police_forum";
    private final static int DATABASE_VERSION = 1;

    private final static String TABLE_CONTACT = "table_contact_list";


    private final static String cont_ID = "cont_id";
    private final static String cont_display_id = "cont_id";
    private final static String cont_name = "cont_id";
    private final static String cont_father = "cont_id";
    private final static String cont_mother = "cont_id";
    private final static String cont_address = "cont_id";
    private final static String cont_phone = "cont_id";
    private final static String cont_email = "cont_id";
    private final static String cont_position = "cont_id";
    private final static String cont_posting = "cont_id";
    private final static String cont_blood_group = "cont_id";
    private final static String cont_claimed = "cont_id";
    private final static String cont_password = "cont_id";
    private final static String cont_verification = "cont_id";
    private final static String cont_verified = "cont_id";




    private final static String QUERY_CREATE_CONTACT = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACT + "("
            + cont_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + cont_display_id +" VARCHAR,"
            + cont_name + " VARCHAR,"
            + cont_father + " TEXT,"
            + cont_mother + " TEXT,"
            + cont_address + " TEXT,"
            + cont_phone + " TEXT,"
            + cont_email + " TEXT,"
            + cont_position + " TEXT,"
            + cont_posting + " TEXT,"
            + cont_blood_group + " TEXT,"
            + cont_claimed + " TEXT,"
            + cont_password + " TEXT,"
            + cont_verification + " TEXT,"
            + cont_verified + " TEXT,)";

    private final static String QUERY_DROP_CONTACT = "DROP TABLE IF EXISTS " + TABLE_CONTACT;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(QUERY_CREATE_CONTACT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(QUERY_DROP_CONTACT);
        onCreate(db);
    }
}
