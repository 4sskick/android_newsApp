package com.niteroomcreation.newsapp.view.ui.detail;

import android.widget.Toast;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.niteroomcreation.newsapp.databinding.ADetailBinding;
import com.niteroomcreation.newsapp.view.BaseActivity;

/**
 * Created by Septian Adi Wijaya on 23/09/2021.
 * please be sure to add credential if you use people's code
 */
public class DetailActivity extends BaseActivity {

    public static final String TAG = DetailActivity.class.getSimpleName();

    private ADetailBinding binding;

    @Override
    public void onCreateInside() {
        binding = ADetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.detailsSwipe.setRefreshing(true);
        binding.detailsSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
                binding.detailsSwipe.setRefreshing(false);
            }
        });
    }

    @Override
    public void initUI() {
        loadData();
        binding.detailsSwipe.setRefreshing(false);
    }

    private void loadData(){
        if (getIntent() != null && getIntent().getExtras() != null) {
            binding.setNewsItemData(getIntent().getExtras().getParcelable("model"));
        } else {
            Toast.makeText(this, "Model class doesn't found", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
