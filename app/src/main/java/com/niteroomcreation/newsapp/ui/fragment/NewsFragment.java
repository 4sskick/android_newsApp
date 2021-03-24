package com.niteroomcreation.newsapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.niteroomcreation.newsapp.R;

/**
 * Created by Septian Adi Wijaya on 24/03/2021.
 * please be sure to add credential if you use people's code
 */
public class NewsFragment extends Fragment {

    public static final String TAG = NewsFragment.class.getSimpleName();


    public NewsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
