package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper
        extends SQLiteOpenHelper
{
    public DataBaseHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
    {
        super(paramContext, paramString, paramCursorFactory, paramInt);
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
        paramSQLiteDatabase.execSQL("create table LOGIN ( ID integer primary key autoincrement,USERNAME  text,PASSWORD text); ");
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
        Log.w("TaskDBAdapter", "Upgrading from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS TEMPLATE");
        onCreate(paramSQLiteDatabase);
    }
}
