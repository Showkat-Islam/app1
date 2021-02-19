package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginActivity
{
    static final String DATABASE_CREATE = "create table LOGIN ( ID integer primary key autoincrement,USERNAME  text,PASSWORD text); ";
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    private final Context context;
    public SQLiteDatabase db;
    private com.example.myapplication.DataBaseHelper dbHelper;

    public LoginActivity(Context paramContext)
    {
        this.context = paramContext;
        this.dbHelper = new com.example.myapplication.DataBaseHelper(this.context, "login.db", null, 1);
    }

    public void close()
    {
        this.db.close();
    }

    public int deleteEntry(String paramString)
    {
        return this.db.delete("LOGIN", "USERNAME=?", new String[] { paramString });
    }

    public SQLiteDatabase getDatabaseInstance()
    {
        return this.db;
    }

    public String getSinlgeEntry(Cursor paramString)
    {
        paramString = this.db.query("LOGIN", null, " USERNAME=?", new String[] {String.valueOf(paramString)}, null, null, null);
        if (paramString.getCount() < 1)
        {
            paramString.close();
            return "NOT EXIST";
        }
        paramString.moveToFirst();
        String str = paramString.getString(paramString.getColumnIndex("PASSWORD"));
        paramString.close();
        return str;
    }

    public void insertEntry(String paramString1, String paramString2)
    {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("USERNAME", paramString1);
        localContentValues.put("PASSWORD", paramString2);
        this.db.insert("LOGIN", null, localContentValues);
    }

    public LoginActivity open()
            throws SQLException
    {
        this.db = this.dbHelper.getWritableDatabase();
        return this;
    }

    public void updateEntry(String paramString1, String paramString2)
    {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("USERNAME", paramString1);
        localContentValues.put("PASSWORD", paramString2);
        this.db.update("LOGIN", localContentValues, "USERNAME = ?", new String[] { paramString1 });
    }


}
