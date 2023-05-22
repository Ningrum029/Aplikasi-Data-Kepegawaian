package com.example.maribelanja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPelangganActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin, btnregis;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pelanggan);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsignin1);
        btnregis = (Button) findViewById(R.id.btnsignup1);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")||pass.equals(""))
                    Toast.makeText(LoginPelangganActivity.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.Checkuseernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginPelangganActivity.this, "sign ni successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), BaranglistActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginPelangganActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });
        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DaftarPelangganActivity.class);
                startActivity(intent);

            }
        });
    }
}