package com.niteroomcreation.newsapp.view.act.main;

import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.niteroomcreation.newsapp.R;
import com.niteroomcreation.newsapp.databinding.AMainBinding;
import com.niteroomcreation.newsapp.view.BaseActivity;

public class MainActivity extends BaseActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private AMainBinding binding;
    private NavHostFragment navHostFragment;

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
    }
}