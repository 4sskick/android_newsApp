package com.niteroomcreation.newsapp.view.act.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.niteroomcreation.newsapp.R;
import com.niteroomcreation.newsapp.databinding.AMainBinding;
import com.niteroomcreation.newsapp.view.BaseActivity;

public class MainActivity extends BaseActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private AMainBinding binding;
    private NavHostFragment navHostFragment;
    private int selectedFragmentID;

    @Override
    public void onCreateInside() {

        binding = AMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void initUI() {
        setupNavigation();
    }

    private void setupNavigation() {
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment);
        NavigationUI.setupWithNavController(binding.navBottom, navHostFragment.getNavController());

        binding.navBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Bundle b = new Bundle();

                switch (menuItem.getItemId()) {
                    case R.id.action_m_search:
                        selectedFragmentID = menuItem.getItemId();

                        b.putString("m_key", "SEARCH");
                        navHostFragment.getNavController().navigate(R.id.action_m_search, b);

                        return true;

                    case R.id.action_m_bookmark:
                        selectedFragmentID = menuItem.getItemId();

                        b.putString("m_key", "BOOKMARK");
                        navHostFragment.getNavController().navigate(R.id.action_m_bookmark, b);
                        return true;

                    case R.id.action_m_dashboard:
                        selectedFragmentID = menuItem.getItemId();

                        b.putString("m_key", "DASHBOARD");
                        navHostFragment.getNavController().navigate(R.id.action_m_dashboard, b);
                        return true;

                    case R.id.action_m_setting:
                        selectedFragmentID = menuItem.getItemId();

                        navHostFragment.getNavController().navigate(R.id.action_m_setting);
                        return true;
                }
                return false;
            }
        });

        binding.navBottom.setSelectedItemId(navHostFragment.getNavController().getCurrentDestination().getId());
    }
}