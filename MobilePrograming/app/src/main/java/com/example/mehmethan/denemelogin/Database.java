package com.example.mehmethan.denemelogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 12/10/2017.
 */

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="MobileApp";

    private static final String TABLE_NAME ="Kullanicilar";
    private final String COL_ID = "Id";
    private final String COL_EMAIL = "Email";
    private final String COL_PASSWORD="Password";

    private static final String TABLE_BILGI ="Bilgiler";
    private final String COL_uID = "Id";
    private final String COL_NAME = "Name";
    private final String COL_SURNAME="Surname";
    private final String COL_YAS="Yas";
    private final String COL_CINSIYET="Cinsiyet";

    public Database(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String tablo = "CREATE TABLE "+TABLE_NAME +
                "("+COL_ID+" INTEGER PRIMARY KEY, " +
                COL_EMAIL+" TEXT NOT NULL,"+
                COL_PASSWORD+" TEXT NOT NULL)";

        String tablo2 = "CREATE TABLE "+TABLE_BILGI +
                "("+COL_uID+" INTEGER PRIMARY KEY, " +
                COL_NAME+" TEXT NOT NULL,"+
                COL_SURNAME+" TEXT NOT NULL,"+
                COL_YAS+" TEXT NOT NULL)";

        db.execSQL(tablo);
        db.execSQL(tablo2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String tablo ="DROP TABLE IF EXIST"+ TABLE_NAME;
        db.execSQL(tablo);

        String tablo2 ="DROP TABLE IF EXIST"+ TABLE_BILGI;
        db.execSQL(tablo2);

        onCreate(db);
    }

    public long InsertUser(String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(COL_EMAIL, email);
        value.put(COL_PASSWORD, password);

        long control = db.insert(TABLE_NAME,null, value);
        db.close();

        return control;
    }

    public void UpdateUser(String name, String surname, String yas)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(COL_NAME, name);
        value.put(COL_SURNAME, surname);
        value.put(COL_YAS, yas);

        db.insert(TABLE_BILGI,null, value);
        db.close();


    }

}
