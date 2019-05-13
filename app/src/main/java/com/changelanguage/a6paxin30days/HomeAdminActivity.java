package com.changelanguage.a6paxin30days;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeAdminActivity extends AppCompatActivity {
    Button btnListQA;
    Button btnUserInfo;
    Button btnListSchedules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
        btnListSchedules = findViewById(R.id.btnListSchedules);
        btnListQA = findViewById(R.id.btnListQA);
        btnUserInfo = findViewById(R.id.btnUserInfo);
        btnUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user_update = new Intent(HomeAdminActivity.this, UpdateUserActivity.class);
                startActivity(user_update);
            }
        });
    }
}
