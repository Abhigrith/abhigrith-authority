package com.example.abhigrith_authority;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.abhigrith_authority.tabs.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    TabLayout tabLayout;
//    ViewPager2 pager2;
//    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tabLayout = findViewById(R.id.tab_layout);
//        pager2 = findViewById(R.id.view_pager2);

//        FragmentManager fm = getSupportFragmentManager();
//        adapter = new FragmentAdapter(fm, getLifecycle());
//        pager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.app_start);
                 NavController navController = navHostFragment.getNavController();

                switch (tab.getPosition()){
                    case 0 :
                        // pager2.setCurrentItem(0);
                        navController.setGraph(R.navigation.orphanage_navigation);
                        break;
                    case 1 :
                        // pager2.setCurrentItem(1);
                        navController.setGraph(R.navigation.parent_navigation);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                tabLayout.selectTab(tabLayout.getTabAt(position));
//            }
//        });
    }
}