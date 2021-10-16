package com.niteroomcreation.newsapp.presentation.feature;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.niteroomcreation.newsapp.databinding.FEmptyBinding;
import com.niteroomcreation.newsapp.util.LogHelper;
import com.niteroomcreation.newsapp.presentation.base.BaseFragment;

/**
 * Created by monta on 27/04/21
 * please make sure to use credit when using people code
 **/
public class EmptyFragment extends BaseFragment {

    public static final String TAG = EmptyFragment.class.getSimpleName();

    private FEmptyBinding binding;
    private String title;

    @Override
    public View onInflateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FEmptyBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void initUI() {
        if (getArguments() != null) {
            LogHelper.e(TAG, getArguments().get("m_key"));

            binding.emptyTv.setText(getArguments().get("m_key").toString());
        } else {
            LogHelper.e(TAG, "argument is empty");

            binding.emptyTv.setText("KOSONG");
        }
    }

    @Override
    public void destroyUI() {
        binding = null;
    }
}
