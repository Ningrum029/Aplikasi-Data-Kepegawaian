package com.example.maribelanja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {
    EditText nama, jenis, harga;
    Button tam, ubah, hapus, lihat;
    DBHelperA DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        nama = findViewById(R.id.nama);
        jenis = findViewById(R.id.jenis);
        harga = findViewById(R.id.harga);
        tam = findViewById(R.id.btntambah);
        ubah = findViewById(R.id.btnubah);
        hapus = findViewById(R.id.btnhapus);
        lihat = findViewById(R.id.btnlihat);

        DB = new DBHelperA(this);

        lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TambahActivity.this, BaranglistActivity.class));
            }
        });

        tam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaTXT = nama.getText().toString();
                String jenisTXT = jenis.getText().toString();
                String hargaTXT = harga.getText().toString();

                Boolean checktambahdata = DB.insertbarangdata(namaTXT, jenisTXT, hargaTXT);
                if (checktambahdata==true){
                    startActivity(new Intent(TambahActivity.this, BaranglistActivity.class));
                    Toast.makeText(TambahActivity.this, "Data baru ditambahkan", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(TambahActivity.this, "Data tidak ditambahkan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaTXT = nama.getText().toString();
                String jenisTXT = jenis.getText().toString();
                String hargaTXT = harga.getText().toString();

                Boolean checkupdatedata = DB.updatebarangdata(namaTXT, jenisTXT, hargaTXT);
                if (checkupdatedata==true){
                    startActivity(new Intent(TambahActivity.this, BaranglistActivity.class));
                    Toast.makeText(TambahActivity.this, "Data sudah diperbarui", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(TambahActivity.this, "Data tidak diperbarui", Toast.LENGTH_SHORT).show();
                }
            }
        });

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaTXT = nama.getText().toString();
                String jenisTXT = jenis.getText().toString();
                String hargaTXT = harga.getText().toString();

                Boolean checkdeletedata = DB.deletedata(namaTXT, jenisTXT, hargaTXT);
                if (checkdeletedata==true){
                    startActivity(new Intent(TambahActivity.this, BaranglistActivity.class));
                    Toast.makeText(TambahActivity.this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(TambahActivity.this, "Data tidak berhasil dihapus", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}