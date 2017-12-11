package com.example.lenovo.weixin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by lenovo on 2017/12/7.
 */

public class myDBOpenHelper extends SQLiteOpenHelper {
    private Context mContext;

    public myDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table registor(id integer primary key autoincrement,name char(20),country char(20),phone char(20),password char(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
