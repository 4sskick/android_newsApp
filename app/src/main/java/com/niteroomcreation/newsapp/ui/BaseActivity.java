package com.niteroomcreation.newsapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Septian Adi Wijaya on 24/03/2021.
 * please be sure to add credential if you use people's code
 * <p>
 * this class gonna be  a base class which control all view state in one place
 */
public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();

    public Context context;
    private ProgressDialog progressLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onCreateInside();

        context = getContext();
        progressLoading = new ProgressDialog(this);

        initUI();
    }


    public abstract void onCreateInside();

    public abstract void initUI();

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

    private Context getContext() {
        return this.context;
    }
}
