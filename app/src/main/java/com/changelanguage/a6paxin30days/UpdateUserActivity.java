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
import com.changelanguage.a6paxin30days.model.Users;

public class UpdateUserActivity extends AppCompatActivity {
    EditText editPassword;
    EditText editTall;
    EditText editWeight;
    EditText editUsername;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        DBManager db = new DBManager(UpdateUserActivity.this);
        SharedPreferences user_sharepreference = getSharedPreferences("user_preference",UpdateUserActivity.this.MODE_PRIVATE);
        String username = user_sharepreference.getString("username_preference",null);
        Toast.makeText(UpdateUserActivity.this,"Username: "+ username,Toast.LENGTH_LONG).show();
       final Users user = db.getUser(username);
       // editUsername = editUsername.findViewById(R.id.editUsername);
        EditText  editUsername =(EditText) findViewById(R.id.editUsername);
        editUsername.setText(user.getmUSERNAME());
        editPassword = (EditText)findViewById(R.id.editPassword);
        editPassword.setText(user.getmPassword());
        editTall = (EditText)findViewById(R.id.editTall);
        editTall.setText(String.valueOf(user.getmTall()));
        editWeight = (EditText)findViewById(R.id.editWeight);
        editWeight.setText(String.valueOf(user.getmWeight()));
        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = editPassword.getText().toString();
                Integer tall = Integer.parseInt(editTall.getText().toString());
                Integer weight = Integer.parseInt(editWeight.getText().toString());
                DBManager db = new DBManager(UpdateUserActivity.this);
                boolean update_successful = db.updateUser(user.getmID(),password,tall,weight);
                if (update_successful){
                    Toast.makeText(UpdateUserActivity.this,"Cập nhật thành công",Toast.LENGTH_LONG).show();
                    Intent home_admin = new Intent(UpdateUserActivity.this,HomeAdminActivity.class);
                    startActivity(home_admin);
                }
            }
        });
    }
}
