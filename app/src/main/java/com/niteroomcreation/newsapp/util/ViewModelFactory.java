package com.niteroomcreation.newsapp.util;

import android.content.Context;

import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Septian Adi Wijaya on 16/10/2021.
 * please be sure to add credential if you use people's code
 */
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    public static final String TAG = ViewModelFactory.class.getSimpleName();

    private static volatile ViewModelFactory INSTANCE;


    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                INSTANCE = new ViewModelFactory();
            }
        }
        return INSTANCE;
    }
}
