package database;

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


    private final static String cont_ID = "cont_id";
    private final static String cont_display_id = "cont_display_id";
    private final static String cont_name = "cont_name";
    private final static String cont_father = "cont_father";
    private final static String cont_mother = "cont_mother";
    private final static String cont_address = "cont_address";
    private final static String cont_phone = "cont_phone";
    private final static String cont_email = "cont_email";
    private final static String cont_position = "cont_position";
    private final static String cont_posting = "cont_posting";
    private final static String cont_blood_group = "cont_blood_group";
    private final static String cont_claimed = "cont_claimed";
    private final static String cont_password = "cont_password";
    private final static String cont_verification = "cont_verification";
    private final static String cont_verified = "cont_verified";




    private final static String QUERY_CREATE_CONTACT = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACT + "("
            + cont_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + cont_display_id +" VARCHAR,"
            + cont_name + " TEXT,"
            + cont_father + " TEXT,"
            + cont_mother + " TEXT,"
            + cont_address + " TEXT,"
            + cont_phone + " TEXT,"
            + cont_email + " TEXT,"
            + cont_position + " TEXT,"
            + cont_posting + " TEXT,"
            + cont_blood_group + " TEXT,"
            + cont_claimed + " INTEGER,"
            + cont_password + " VARCHAR,"
            + cont_verification + " INT,"
            + cont_verified + " INTEGER,)";

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

        cv.put(cont_display_id,holderContact.cont_display_id);
        cv.put(cont_name,holderContact.cont_name);
        cv.put(cont_father,holderContact.cont_father);
        cv.put(cont_mother,holderContact.cont_mother);
        cv.put(cont_address,holderContact.cont_address);
        cv.put(cont_phone,holderContact.cont_phone);
        cv.put(cont_email,holderContact.cont_email);
        cv.put(cont_position,holderContact.cont_position);
        cv.put(cont_posting,holderContact.cont_posting);
        cv.put(cont_blood_group,holderContact.cont_blood_group);
        cv.put(cont_claimed,holderContact.cont_claimed);
        cv.put(cont_password,holderContact.cont_password);
        cv.put(cont_verification,holderContact.cont_verification);
        cv.put(cont_verified,holderContact.cont_verified);

        return db.insert(TABLE_CONTACT,null,cv);
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

    private ArrayList<HolderContact> getContact(int id,String limit) {
        ArrayList<HolderContact> contactData = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor;

        if (id != -1) {
            cursor = db.query(TABLE_CONTACT, null, null, null, cont_ID + "=" + id, null, null, limit);
        }
        else if (id == -1 && limit != null) {
            cursor = db.query(TABLE_CONTACT, null, null, null, null, null, cont_ID + " desc",limit);
        }
        else {
            cursor = db.query(TABLE_CONTACT, null, null, null, null, null, cont_ID + " desc");
        }

        cursor.moveToFirst();
        for(int i = 0; i< cursor.getCount(); i++) {
            contactData.add(new HolderContact(
                    cursor.getInt(cursor.getColumnIndex(cont_ID)),
                    cursor.getInt(cursor.getColumnIndex(cont_verification)),
                    cursor.getString(cursor.getColumnIndex(cont_display_id)),
                    cursor.getString(cursor.getColumnIndex(cont_name)),
                    cursor.getString(cursor.getColumnIndex(cont_father)),
                    cursor.getString(cursor.getColumnIndex(cont_mother)),
                    cursor.getString(cursor.getColumnIndex(cont_address)),
                    cursor.getString(cursor.getColumnIndex(cont_phone)),
                    cursor.getString(cursor.getColumnIndex(cont_email)),
                    cursor.getString(cursor.getColumnIndex(cont_password)),
                    cursor.getString(cursor.getColumnIndex(cont_position)),
                    cursor.getString(cursor.getColumnIndex(cont_posting)),
                    cursor.getString(cursor.getColumnIndex(cont_blood_group)),
                    cursor.getInt(cursor.getColumnIndex(cont_claimed)),
                    cursor.getInt(cursor.getColumnIndex(cont_verified))

            ));
            cursor.moveToNext();
        }
        return contactData;
    }
}

