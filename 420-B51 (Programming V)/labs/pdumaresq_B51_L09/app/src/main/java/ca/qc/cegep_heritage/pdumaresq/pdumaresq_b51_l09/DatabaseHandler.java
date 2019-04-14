package ca.qc.cegep_heritage.pdumaresq.pdumaresq_b51_l09;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_PERSON = "People";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_EMAIL_ADDRESS = "email_address";
    private static final String KEY_PH_NO = "phone_number";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PERSON_TABLE = "CREATE TABLE " + TABLE_PERSON + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FIRST_NAME + " TEXT,"
                + KEY_LAST_NAME + " TEXT," + KEY_EMAIL_ADDRESS + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_PERSON_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        onCreate(db);
    }

    public void addPerson(Person contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME, contact.getFirstName());
        values.put(KEY_LAST_NAME, contact.getLastName());
        values.put(KEY_EMAIL_ADDRESS, contact.getEmailAddress());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        db.insert(TABLE_PERSON, null, values);
        db.close();
    }

    Person getPerson(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PERSON,
            new String[] { KEY_ID, KEY_FIRST_NAME, KEY_LAST_NAME, KEY_EMAIL_ADDRESS, KEY_PH_NO },
            KEY_ID + "=?",
            new String[] { String.valueOf(id) },
            null, null, null, null
        );

        if (cursor != null)
            cursor.moveToFirst();

        Person contact = new Person(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),    cursor.getString(2),
                cursor.getString(3),    cursor.getString(4)
        );

        return contact;
    }

    public List<Person> getAllPeople() {
        List<Person> contactList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_PERSON;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Person contact = new Person();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setFirstName(cursor.getString(1));
                contact.setLastName(cursor.getString(2));
                contact.setEmailAddress(cursor.getString(3));
                contact.setPhoneNumber(cursor.getString(4));

                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        return contactList;
    }

    public int updatePerson(Person contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME, contact.getFirstName());
        values.put(KEY_LAST_NAME, contact.getLastName());
        values.put(KEY_EMAIL_ADDRESS, contact.getEmailAddress());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        return db.update(TABLE_PERSON, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
    }

    public void deletePerson(Person contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PERSON, KEY_ID + " = ?", new String[] { String.valueOf(contact.getId()) });
        db.close();
    }

    public int getPersonCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PERSON;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
}