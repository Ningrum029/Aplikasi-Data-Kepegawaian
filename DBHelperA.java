package com.example.maribelanja;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperA extends SQLiteOpenHelper {

    public DBHelperA(Context context) {
        super(context, "Barangdata.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Barangdetails(nama TEXT primary key, jenis TEXT, harga TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop table if exists Barangdetails");
    }

    public Boolean insertbarangdata(String nama, String jenis, String harga){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama", nama);
        contentValues.put("jenis", jenis);
        contentValues.put("harga", harga);
        long result = DB.insert("Barangdetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updatebarangdata(String nama, String jenis, String harga){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("jenis", jenis);
        contentValues.put("harga", harga);
        Cursor cursor = DB.rawQuery("Select * from Barangdetails where nama =?", new String[]{nama});
        if (cursor.getCount()>0) {

            long result = DB.update("Barangdetails", contentValues, "nama=?", new String[]{nama});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }


    public Boolean deletedata(String nama, String jenisTXT, String hargaTXT){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Barangdetails where nama =?", new String[]{nama});
        if (cursor.getCount()>0) {
            long result = DB.delete("Barangdetails","nama=?", new String[]{nama});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Barangdetails", null);
        return cursor;
    }
}
