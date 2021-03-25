package com.niteroomcreation.newsapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.niteroomcreation.newsapp.R;
import com.niteroomcreation.newsapp.databinding.FSettingBinding;
import com.niteroomcreation.newsapp.ui.BaseFragment;

/**
 * Created by Septian Adi Wijaya on 25/03/2021.
 * please be sure to add credential if you use people's code
 */
public class SettingFragment extends BaseFragment {

    public static final String TAG = SettingFragment.class.getSimpleName();

    private FSettingBinding binding;

    @Override
    public View onInflateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FSettingBinding.inflate(inflater, container, false);
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
