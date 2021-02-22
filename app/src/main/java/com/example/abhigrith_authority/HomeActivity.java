package com.example.abhigrith_authority;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn_authority_home_warden= (Button) findViewById(R.id.btn_authority_home_warden);
        btn_authority_home_warden.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(HomeActivity.this, WardenActivity.class);
                startActivity(intent);
            }
        });

        Button btn_authority_home_parent= (Button) findViewById(R.id.btn_authority_home_parent);
        btn_authority_home_parent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}