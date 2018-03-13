package com.example.garrett.assignment1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;

public class NightclubDataSource {
    private SQLiteDatabase database;
    private NightclubDBHelper dbHelper;

    public NightclubDataSource(Context context) {
        dbHelper = new NightclubDBHelper((context));
    }

    public void open()throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertNightclub(Nightclub n) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();
            initialValues.put("nightclubname", n.getNightclubName());
            initialValues.put("streetaddress", n.getStreetaddress());
            initialValues.put("city", n.getCity());
            initialValues.put("state", n.getState());
            initialValues.put("zipcode", n.getZipcode());
            initialValues.put("beer", n.getBeer());
            initialValues.put("wine", n.getWine());
            initialValues.put("music", n.getMusic());
            initialValues.put("average", n.getAverage());


            didSucceed = database.insert("nightclub",null,initialValues) > 0;
        }
        catch(Exception e) {
            //Do nothing - will return false if there is an exception
        }

        return didSucceed;
    }

    public boolean updateNightClub(Nightclub n) {
        boolean didSucceed = false;

        try {
            long rowId = (long) n.getNightclubID();
            ContentValues updateValues = new ContentValues();

            updateValues.put("nightclubname", n.getNightclubName());
            updateValues.put("streetaddress", n.getStreetaddress());
            updateValues.put("city", n.getCity());
            updateValues.put("state", n.getState());
            updateValues.put("zipcode",n.getZipcode());
            updateValues.put("beer", n.getBeer());
            updateValues.put("wine", n.getWine());
            updateValues.put("music", n.getMusic());
            updateValues.put("average", n.getAverage());
            didSucceed = database.update("nightclub", updateValues, "_id=" + rowId,null) > 0;
        }
        catch(Exception e) {
            //Do nothing - will return false if there is an exception
        }

        return didSucceed;
    }

    public int getLastNightclubId() {
        int lastId = -1;
        try {
            String query = "Select MAX(_id) from nightclub";
            Cursor cursor = database.rawQuery(query,null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        }
        catch(Exception e) {
            lastId = -1;
        }

        return lastId;
    }

    public ArrayList<Nightclub> getNightclubs(String sortField, String sortOrder) {
        ArrayList<Nightclub> nightclubs = new ArrayList<Nightclub>();
        try {
            String query = "SELECT * FROM nightclub ORDER BY " + sortField + " " + sortOrder;
            Cursor cursor = database.rawQuery(query,null);

            Nightclub newNightclub;
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                newNightclub = new Nightclub();
                newNightclub.setNightclubID(cursor.getInt(0));
                newNightclub.setNightclubName(cursor.getString(1));
                newNightclub.setStreetaddress(cursor.getString(2));
                newNightclub.setCity(cursor.getString(3));
                newNightclub.setState(cursor.getString(4));
                newNightclub.setZipcode(cursor.getString(5));
                newNightclub.setBeer(cursor.getInt(6));
                newNightclub.setWine(cursor.getInt(7));
                newNightclub.setMusic(cursor.getInt(8));
                newNightclub.setAverage(cursor.getInt(9));

                nightclubs.add(newNightclub);
                cursor.moveToNext();
            }
            cursor.close();

        }
        catch(Exception e) {
            nightclubs = new ArrayList<Nightclub>();
        }
        return nightclubs;
    }

    public Nightclub getSpecificNightclub(int nightclubID) {
        Nightclub nightclub = new Nightclub();
        String query = "SELECT * FROM nightclub WHERE _id =" + nightclubID;
        Cursor cursor = database.rawQuery(query,null);

        if(cursor.moveToFirst()) {
            nightclub.setNightclubID(cursor.getInt(0));
            nightclub.setNightclubName(cursor.getString(1));
            nightclub.setStreetaddress(cursor.getString(2));
            nightclub.setCity(cursor.getString(3));
            nightclub.setState(cursor.getString(4));
            nightclub.setZipcode(cursor.getString(5));
            nightclub.setBeer(cursor.getInt(6));
            nightclub.setWine(cursor.getInt(7));
            nightclub.setMusic(cursor.getInt(8));
            nightclub.setAverage(cursor.getInt(9));
            cursor.close();
        }

        return nightclub;

    }

    public boolean deleteNightclub(int nightclubID) {
        boolean didDelete = false;
        try{
            didDelete = database.delete("nightclub","_id=" + nightclubID, null) > 0;
        }
        catch(Exception e) {
            // Do nothing, returns pre set false
        }

        return didDelete;
    }




}
