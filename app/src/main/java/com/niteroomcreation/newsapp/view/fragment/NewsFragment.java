package com.niteroomcreation.newsapp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.niteroomcreation.newsapp.databinding.FNewsBinding;
import com.niteroomcreation.newsapp.view.BaseFragment;

/**
 * Created by Septian Adi Wijaya on 24/03/2021.
 * please be sure to add credential if you use people's code
 */
public class NewsFragment extends BaseFragment {

    public static final String TAG = NewsFragment.class.getSimpleName();

    private FNewsBinding binding;

    @Override
    public View onInflateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void initUI() {

    }

    @Override
    public void destroyUI() {
        binding = null;
    }
}
