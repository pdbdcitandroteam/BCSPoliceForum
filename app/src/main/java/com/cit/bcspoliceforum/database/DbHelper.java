package com.cit.bcspoliceforum.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by CIT on 1/17/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "bcs_police_forum";
    private final static int DATABASE_VERSION = 1;

    private final static String TABLE_CONTACT = "table_contact_list";

    private final static String CONT_ID = "cont_id";
    private final static String CONT_DISPLAY_ID = "cont_display_id";
    private final static String CONT_NAME = "cont_name";
    private final static String CONT_FATHER = "cont_father";
    private final static String CONT_MOTHER = "cont_mother";
    private final static String CONT_ADDRESS = "cont_address";
    private final static String CONT_PHONE = "cont_phone";
    private final static String CONT_EMAIL = "cont_email";
    private final static String CONT_POSITION = "cont_position";
    private final static String CONT_POSTING = "cont_posting";
    private final static String CONT_BLOOD_GROUP = "cont_blood_group";
    private final static String CONT_PHOTO = "cont_photo";
    private final static String CONT_CLAIMED = "cont_claimed";
    private final static String CONT_PASSWORD = "cont_password";
    private final static String CONT_VERIFICATION_CODE = "cont_verification";
    private final static String CONT_VERIFIED = "cont_verified";




    private final static String QUERY_CREATE_CONTACT = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACT + " ("
            + CONT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + CONT_DISPLAY_ID +" VARCHAR,"
            + CONT_NAME + " TEXT,"
            + CONT_FATHER + " TEXT,"
            + CONT_MOTHER + " TEXT,"
            + CONT_ADDRESS + " TEXT,"
            + CONT_PHONE + " TEXT,"
            + CONT_EMAIL + " TEXT,"
            + CONT_POSITION + " TEXT,"
            + CONT_POSTING + " TEXT,"
            + CONT_BLOOD_GROUP + " TEXT,"
            + CONT_PHOTO + " TEXT,"
            + CONT_CLAIMED + " INTEGER,"
            + CONT_PASSWORD + " VARCHAR,"
            + CONT_VERIFICATION_CODE + " INT,"
            + CONT_VERIFIED + " INTEGER)";

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


    public long insertContact(HolderContact holderContact){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CONT_DISPLAY_ID, holderContact.getDisplayId());
        cv.put(CONT_NAME, holderContact.getName());
        cv.put(CONT_FATHER, holderContact.getFather());
        cv.put(CONT_MOTHER, holderContact.getMother());
        cv.put(CONT_ADDRESS, holderContact.getAddress());
        cv.put(CONT_PHONE, holderContact.getPhone());
        cv.put(CONT_EMAIL, holderContact.getEmail());
        cv.put(CONT_POSITION, holderContact.getPosition());
        cv.put(CONT_POSTING, holderContact.getPosting());
        cv.put(CONT_BLOOD_GROUP, holderContact.getBloodGroup());
        cv.put(CONT_PHOTO, holderContact.getPhoto());
        cv.put(CONT_CLAIMED, holderContact.isClaimed()?1:0);
        cv.put(CONT_PASSWORD, holderContact.getPassword());
        cv.put(CONT_VERIFICATION_CODE, holderContact.getVerificationCode());
        cv.put(CONT_VERIFIED, holderContact.isVerified()?1:0);

        return db.insert(TABLE_CONTACT, null, cv);
    }

    public ArrayList<HolderContact> getContact(){
        return getContact(-1, null);
    }
    public ArrayList<HolderContact> getContact(String limit){
        return getContact(-1, limit);
    }
    public HolderContact getContact(int id){
        return getContact(id, null).get(0);
    }

    private ArrayList<HolderContact> getContact(int id, String limit) {
        ArrayList<HolderContact> contactData = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor;

        if (id != -1) {
            cursor = db.query(TABLE_CONTACT, null, CONT_ID + "=" + id, null, null, null, null);
        } else if (id == -1 && limit != null) {
            cursor = db.query(TABLE_CONTACT, null, null, null, null, null, CONT_ID, limit);
        } else {
            cursor = db.query(TABLE_CONTACT, null, null, null, null, null, CONT_NAME);
        }

        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            contactData.add(new HolderContact(
                    cursor.getInt(cursor.getColumnIndex(CONT_ID)),
                    cursor.getString(cursor.getColumnIndex(CONT_DISPLAY_ID)),
                    cursor.getString(cursor.getColumnIndex(CONT_NAME)),
                    cursor.getString(cursor.getColumnIndex(CONT_FATHER)),
                    cursor.getString(cursor.getColumnIndex(CONT_MOTHER)),
                    cursor.getString(cursor.getColumnIndex(CONT_ADDRESS)),
                    cursor.getString(cursor.getColumnIndex(CONT_PHONE)),
                    cursor.getString(cursor.getColumnIndex(CONT_EMAIL)),
                    cursor.getString(cursor.getColumnIndex(CONT_POSITION)),
                    cursor.getString(cursor.getColumnIndex(CONT_POSTING)),
                    cursor.getString(cursor.getColumnIndex(CONT_BLOOD_GROUP)),
                    cursor.getString(cursor.getColumnIndex(CONT_PHOTO)),
                    (cursor.getInt(cursor.getColumnIndex(CONT_CLAIMED))>0),
                    cursor.getString(cursor.getColumnIndex(CONT_PASSWORD)),
                    cursor.getString(cursor.getColumnIndex(CONT_VERIFICATION_CODE)),
                    (cursor.getInt(cursor.getColumnIndex(CONT_VERIFIED))>0)
            ));
            cursor.moveToNext();
        }
        return contactData;
    }
}

