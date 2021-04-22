package com.example.abhigrith_authority.tabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.abhigrith_authority.R;
import com.example.abhigrith_authority.orphanage.fragments.OrphanageFullDetailFragment;

import java.util.List;

public class FragmentAdapter extends FragmentStateAdapter {
    private final FragmentManager fragmentManager;

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                // navController.setGraph(R.navigation.orphanage_navigation);
                fragment = new OrphanagesPendingAuthRequestFragment();
                break;
            case 1:
                fragment = new ParentsPendingAuthRequestFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
