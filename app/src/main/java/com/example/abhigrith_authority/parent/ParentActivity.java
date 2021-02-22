package com.example.abhigrith_authority.parent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.abhigrith_authority.R;
import com.example.abhigrith_authority.warden.WardenResultActivity;

public class ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        Button btn_authority_parent_skip= (Button) findViewById(R.id.btn_authority_parent_skip);
        btn_authority_parent_skip.setOnClickListener(v -> {
            Intent intent = new Intent(this, ParentResultActivity.class);
            startActivity(intent);
        });
    }
}