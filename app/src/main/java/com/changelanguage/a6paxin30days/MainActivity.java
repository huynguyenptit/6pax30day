package com.changelanguage.a6paxin30days;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.changelanguage.a6paxin30days.data.DBManager;
import com.changelanguage.a6paxin30days.model.Users;

public class MainActivity extends AppCompatActivity {
    private EditText editUsername;
    private EditText editPassword;
    private EditText editPasswordConfirm;
    private EditText editTall;
    private EditText editWeight;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DBManager db = new DBManager(MainActivity.this);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editPasswordConfirm = findViewById(R.id.editPasswordConfirm);
        editTall = findViewById(R.id.editTall);
        editWeight = findViewById(R.id.editWeight);
        btnRegister = findViewById(R.id.btnRegister);
        Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_SHORT).show();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users add_user = register();
                if (add_user != null && check_password(editPassword.getText().toString(),editPasswordConfirm.getText().toString())){
                    db.addUser(add_user);
                }else{
                    Toast.makeText(MainActivity.this, "Sai me m roi babe!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Users register(){
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();
        String tall = editTall.getText().toString();
        String weight = editWeight.getText().toString();
        int int_tall = Integer.parseInt(tall);
        int int_weight = Integer.parseInt(weight);
        Users users = new Users(username,password,int_tall, int_weight);
        return users;
    }

    private boolean check_password(String password, String confirm_password){
        boolean check = false;
        if (password == confirm_password){
            check = true;
        }
        return check;
    }
}
