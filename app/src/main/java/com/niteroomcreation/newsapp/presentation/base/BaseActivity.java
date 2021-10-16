package com.niteroomcreation.newsapp.presentation.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.niteroomcreation.newsapp.R;
import com.niteroomcreation.newsapp.util.LogHelper;
import com.niteroomcreation.newsapp.util.SettingUtil;

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
    private SettingUtil settingUtil;
    private Toast mToast;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        settingUtil = new SettingUtil(this);
        setupTheme(settingUtil.getTheme());

        super.onCreate(savedInstanceState);

        context = this;
        progressLoading = new ProgressDialog(this);
        mToast = Toast.makeText(context, "null", Toast.LENGTH_LONG);

        onCreateInside();
        initUI();
    }

    public abstract void onCreateInside();

    public abstract void initUI();

    private void setupTheme(int theme) {

        LogHelper.e(TAG, theme);

        switch (theme) {
            case SettingUtil.THEME_LIGHT:
                setTheme(R.style.Theme_NewsApp);
                break;

            case SettingUtil.THEME_DARK:
                setTheme(R.style.Theme_NewsApp_Dark);
                break;
            default:
                setTheme(R.style.Theme_NewsApp);
        }
    }

    public void showMessage(String msg) {
        mToast.setText(msg);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
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

    private Context getContext() {
        return this.context;
    }
}
