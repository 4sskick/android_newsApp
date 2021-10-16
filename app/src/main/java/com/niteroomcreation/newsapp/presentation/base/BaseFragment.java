package com.niteroomcreation.newsapp.presentation.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Septian Adi Wijaya on 25/03/2021.
 * please be sure to add credential if you use people's code
 */
public abstract class BaseFragment extends Fragment {

    public static final String TAG = BaseFragment.class.getSimpleName();

    private ProgressDialog progressLoading;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressLoading = new ProgressDialog(view.getContext());

        initUI();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return onInflateView(inflater, container, savedInstanceState);
    }

    public abstract View onInflateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    public abstract void initUI();

    public abstract void destroyUI();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        destroyUI();
    }

    public void showProgressLoading(String title, String desc) {
        progressLoading.setTitle(title);
        progressLoading.setMessage(desc);
        progressLoading.setCancelable(false);
        progressLoading.setCanceledOnTouchOutside(false);
        progressLoading.show();
    }

    public void dismissProgressLoading() {
        if (progressLoading.isShowing())
            progressLoading.dismiss();
    }
}
