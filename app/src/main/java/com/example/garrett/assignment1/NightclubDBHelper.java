package com.example.garrett.assignment1;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class NightclubDBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "nightclubs.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_NIGHTCLUB = "create table nightclub (_id integer primary key autoincrement, "
            + "nightclubname text not null, streetaddress, "
            + "city text, state text, zipcode text, "
            + "beer int, wine int, music int, average int);";

    public NightclubDBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_NIGHTCLUB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.w(NightclubDBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to " + newVersion );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS nightclub");
        onCreate(sqLiteDatabase);
    }
}
