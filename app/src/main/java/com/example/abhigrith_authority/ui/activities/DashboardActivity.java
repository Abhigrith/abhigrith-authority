package com.example.abhigrith_authority.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.abhigrith_authority.R;
import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.app_start);

                if (navHostFragment != null) {
                    NavController navController = navHostFragment.getNavController();

                    switch (tab.getPosition()) {
                        case 0:
                            navController.setGraph(R.navigation.orphanage_navigation);
                            break;
                        case 1:
                            navController.setGraph(R.navigation.parent_navigation);
                            break;
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}