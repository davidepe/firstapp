package com.example.david.gpsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import static android.provider.BaseColumns._ID;
/**
 * Created by David on 19/09/2016.
 */
public class Handler_sqlite extends SQLiteOpenHelper {
    public Handler_sqlite(Context ctx){
        super(ctx, "MiBase", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE coord ("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " + "lat TEXT, lng TEXT)";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int version_ant, int version_nue){
        db.execSQL("DROP TABLE IF EXISTS coord");
        onCreate(db);
    }

    public void insertarReg(String lat, String lng){
        ContentValues values = new ContentValues();
        values.put("lat", lat);
        values.put("lng", lng);
       this.getWritableDatabase().insert("coord",null, values);
    }
    public String read(){
        String result = "";
        String column[]={_ID,"lat","lng"};
        Cursor c = this.getReadableDatabase().query("coord",column,null,null,null,null,null);
        if(c.moveToFirst()){
            int ilat,ilng;
            ilat=c.getColumnIndex("lat");
            ilng=c.getColumnIndex("lng");
            c.moveToLast();
            result=c.getString(ilat)+","+c.getString(ilng)+"\n";
        }
        return result;

    }
    public void openDB(){
        this.getWritableDatabase();
    }
    public void closeDB(){
        this.close();
    }
}
