package com.changelanguage.a6paxin30days;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.changelanguage.a6paxin30days.data.DBManager;

public class MainActivity extends AppCompatActivity {
    private EditText editUsername;
    private EditText editPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("user_preference",MainActivity.this.MODE_PRIVATE);
        String username = sharedPreferences.getString("username_preference",null);
        if (username != null){
            if (sharedPreferences.getInt("user_type",0) == 1){
                Toast.makeText(MainActivity.this,"Day la user!!!!" + sharedPreferences.getInt("user_type",0),Toast.LENGTH_LONG).show();
            }else if (sharedPreferences.getInt("user_type",0) == 2){
                Intent home_admin = new Intent(MainActivity.this,HomeAdminActivity.class);
                startActivity(home_admin);
            }else {
                login();
            }
        }else {
            login();
        }
    }

    public void login(){
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                String admin = "admin";
                DBManager db = new DBManager(MainActivity.this);
                if (db.checkLogin(username,password)){
                    SharedPreferences sharedPreferences = getSharedPreferences("user_preference",MainActivity.this.MODE_PRIVATE);
                    SharedPreferences.Editor edit_preference = sharedPreferences.edit();
                    edit_preference.clear();
                    edit_preference.putString("username_preference",username);
                    if (username.contentEquals("admin")){
                        edit_preference.putInt("user_type",2);
                        Intent home_admin = new Intent(MainActivity.this,HomeAdminActivity.class);
                        startActivity(home_admin);
                    }else {
                        edit_preference.putInt("user_type",1);
                    }
                    edit_preference.apply();
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
