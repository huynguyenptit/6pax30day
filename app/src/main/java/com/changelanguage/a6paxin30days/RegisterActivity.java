package com.changelanguage.a6paxin30days;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.changelanguage.a6paxin30days.data.DBManager;
import com.changelanguage.a6paxin30days.model.Users;

public class RegisterActivity extends AppCompatActivity {
    private EditText editUsername;
    private EditText editPassword;
    private EditText editTall;
    private EditText editWeight;
    private Button btnRegister;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_users);
        register();
    }

    public void register (){
        final DBManager db = new DBManager(RegisterActivity.this);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editTall = findViewById(R.id.editTall);
        editWeight = findViewById(R.id.editWeight);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                String tall = editTall.getText().toString();
                String weight = editWeight.getText().toString();
                int int_tall = Integer.parseInt(tall);
                int int_weight = Integer.parseInt(weight);
                Users init_user = init_register(username,password,int_tall,int_weight);
                if (init_user != null && validate_register(username,password,int_tall,int_weight)){
                    db.addUser(init_user);
                    Toast.makeText(RegisterActivity.this,"Đăng kí thành công!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(RegisterActivity.this, "Tài khoản đã tồn tại hoặc chưa nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(login);
            }
        });
    }

    private Users init_register(String username, String password, Integer int_tall, Integer int_weight){
        Users users = new Users(username,password,int_tall, int_weight);
        return users;
    }

    private boolean validate_register(String Username,String password, Integer tall, Integer weight){
        boolean check = false;
        boolean check_password = false;
        if (password != null){
            check_password = true;
        }
        boolean check_username = false;
        DBManager db = new DBManager(RegisterActivity.this);
        if (Username != null && db.checkUsernameRegister(Username)){
            check_username = true;
        }
        boolean check_infor = false;
        if (tall != null && weight != null){
            check_infor = true;
        }
        if (check_password && check_username && check_infor){
            check = true;
        }
        return check;
    }
}
