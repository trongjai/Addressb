package com.example.student.addressb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AddDBHelper  extends SQLiteOpenHelper {

    private static final String name = "name.sqlite3";
    private static final int version = 2;
    public SQLiteDatabase getReadableDatabase;


    public AddDBHelper(Context ctx) {
        super(ctx, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE info (" +
                "_id integer primary key autoincrement," +
                "name text not null," +           // name
                "last text not null," +           // lastname
                "dob int not null," +            // date of birth
                "mobile int not null," +         // mobile
                "home int not null,"+           //home
                "email text not null);";       //email

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS course;";
        db.execSQL(sql);
        this.onCreate(db);
    }

}
