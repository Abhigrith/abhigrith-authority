package com.example.abhigrith_authority;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.abhigrith_authority.orphanage.activities.OrphanagePendingAuthRequestsActivity;
import com.example.abhigrith_authority.parent.activities.ParentPendingAuthRequestsActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn_authority_home_warden= (Button) findViewById(R.id.btn_authority_home_warden);
        btn_authority_home_warden.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, OrphanagePendingAuthRequestsActivity.class);
            startActivity(intent);
        });

        Button btn_home_parent= (Button) findViewById(R.id.btn_home_parent);
        btn_home_parent.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ParentPendingAuthRequestsActivity.class);
            startActivity(intent);
        });
    }
}