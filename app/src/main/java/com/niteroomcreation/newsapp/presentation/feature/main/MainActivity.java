package com.niteroomcreation.newsapp.presentation.feature.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.niteroomcreation.newsapp.R;
import com.niteroomcreation.newsapp.databinding.AMainBinding;
import com.niteroomcreation.newsapp.data.datasource.NewsModel;
import com.niteroomcreation.newsapp.util.listener.ItemEventsListener;
import com.niteroomcreation.newsapp.util.LogHelper;
import com.niteroomcreation.newsapp.presentation.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity
        extends BaseActivity
        implements ItemEventsListener<List<NewsModel>> {

    public static final String TAG = MainActivity.class.getSimpleName();

    private AMainBinding binding;
    private NavHostFragment navHostFragment;
    private int selectedFragmentID;

    private ArrayList<NewsModel> dataBookmarked;

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

                        // TODO: 23/09/2021  putParcelableArrayList still on problem to passed
                        b.putString("m_key", "BOOKMARK");
                        b.putParcelableArray("model", dataBookmarked.toArray(new NewsModel[]{}));

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

    //gonna provide bookmarked data list model
    @Override
    public void onDataLoaded(List<NewsModel> models) {
        LogHelper.e(TAG, "calling me?");

        dataBookmarked = new ArrayList<>();
        //begin to filter only bookmarked
        for (int i = 0; i < models.size(); i++) {
            if (models.get(i).isFav())
                dataBookmarked.add(models.get(i));
        }
    }
}