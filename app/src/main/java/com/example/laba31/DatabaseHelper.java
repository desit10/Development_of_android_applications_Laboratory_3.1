package com.example.laba31;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "studentsDB.db"; // название бд
    public static int SCHEMA = 1; // версия базы данных
    public static final String TABLE = "students"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FIO = "fio";
    public static final String COLUMN_F = "f";
    public static final String COLUMN_I = "i";
    public static final String COLUMN_O = "o";
    public static final String COLUMN_TIMEADD = "timeAdd";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if(SCHEMA == 1){
            //Создание таблицы
            db.execSQL("CREATE TABLE IF NOT EXISTS students (" + COLUMN_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FIO
                    + " TEXT, " + COLUMN_TIMEADD + " TEXT);");
        }
        else {
            //Создание таблицы
            db.execSQL("CREATE TABLE IF NOT EXISTS students ("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_F + " TEXT, "
                    + COLUMN_I + " TEXT, "
                    + COLUMN_O + " TEXT, "
                    + COLUMN_TIMEADD + " TEXT);");
        }

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
