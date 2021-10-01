package com.gcet.androidbasics;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DeMoliT1on.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_STUDENT="student";
    public static final String COLUMN_ENROLL="enroll";
    public static final String COLUMN_NAME="name";

    private static final String CREATE_STUDENT_TABLE="CREATE TABLE "+TABLE_STUDENT+" ("
            +COLUMN_ENROLL+" integer primary key, "
            +COLUMN_NAME+" text not null);";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(sqLiteDatabase);
    }
}
