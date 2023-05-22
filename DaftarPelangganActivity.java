package com.example.maribelanja;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DaftarPelangganActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pelanggan);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        repassword = (EditText) findViewById(R.id.repassword1);
        signup = (Button) findViewById(R.id.btnsignup1);
        signin = (Button) findViewById(R.id.btnsignin1);
        DBHelper DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(DaftarPelangganActivity.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(repass)){
                        Boolean checkuser = DB.Checkuseername(user);
                        if (checkuser ==false){
                            Boolean insert = DB.insertData(user, pass);
                            if (insert==true){
                                Toast.makeText(DaftarPelangganActivity.this, "Register berhasil", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginPelangganActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(DaftarPelangganActivity.this, "Register gagal", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(DaftarPelangganActivity.this, "user already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(DaftarPelangganActivity.this, "password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginPelangganActivity.class);
                startActivity(intent);

            }
        });
    }
}