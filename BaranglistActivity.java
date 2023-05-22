package com.example.maribelanja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class BaranglistActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> nama, jenis, harga;
    DBHelperA DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baranglist);
        DB = new DBHelperA(this);
        nama = new ArrayList<>();
        jenis = new ArrayList<>();
        harga = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, nama, jenis, harga);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata() {
        Cursor cursor = DB.getdata();
        if (cursor.getCount()==0){
            Toast.makeText(BaranglistActivity.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            return;
        }else {
            while (cursor.moveToNext()){
                nama.add(cursor.getString(0));
                jenis.add(cursor.getString(1));
                harga.add(cursor.getString(2));
            }
        }
    }
}