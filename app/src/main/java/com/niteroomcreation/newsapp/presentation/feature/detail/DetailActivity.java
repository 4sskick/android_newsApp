package com.niteroomcreation.newsapp.presentation.feature.detail;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.niteroomcreation.newsapp.databinding.ADetailBinding;
import com.niteroomcreation.newsapp.data.datasource.NewsModel;
import com.niteroomcreation.newsapp.util.listener.ItemViewClickListener;
import com.niteroomcreation.newsapp.presentation.base.BaseActivity;

/**
 * Created by Septian Adi Wijaya on 23/09/2021.
 * please be sure to add credential if you use people's code
 */
public class DetailActivity
        extends BaseActivity
        implements ItemViewClickListener<NewsModel> {

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
        binding.setCallback(this);
    }

    @Override
    public void initUI() {
        loadData();
        binding.detailsSwipe.setRefreshing(false);
    }

    private void loadData() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            binding.setNewsItemData(getIntent().getExtras().getParcelable("model"));
        } else {
            showMessage("Model class doesn't found");
            finish();
        }
    }

    @Override
    public void onItemClicked(NewsModel model) {
        model.setFav(!model.isFav());
        binding.setNewsItemData(model);
    }
}
