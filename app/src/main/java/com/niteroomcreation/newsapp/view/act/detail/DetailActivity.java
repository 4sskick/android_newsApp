package com.niteroomcreation.newsapp.view.act.detail;

import android.widget.Toast;

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
    }

    @Override
    public void initUI() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            binding.setNewsItemData(getIntent().getExtras().getParcelable("model"));
        } else {
            Toast.makeText(this, "Model class doesn't found", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
