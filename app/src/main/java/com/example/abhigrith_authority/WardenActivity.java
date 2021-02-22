package com.example.abhigrith_authority;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WardenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden);

        Button btn_authority_warden_skip= (Button) findViewById(R.id.btn_authority_warden_skip);
        btn_authority_warden_skip.setOnClickListener(v -> {
            Intent intent = new Intent(this, WardenResultActivity.class);
            startActivity(intent);
        });
    }
}