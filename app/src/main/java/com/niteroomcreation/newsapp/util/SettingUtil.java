package com.niteroomcreation.newsapp.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Septian Adi Wijaya on 25/03/2021.
 * please be sure to add credential if you use people's code
 * <p>
 * this class relate to setting class fragment which controll what user choose for their theme
 * it stored using shared pref
 */
public class SettingUtil {

    public static final String TAG = SettingUtil.class.getSimpleName();

    private SharedPreferences pref;
    private int theme;

    public static final int THEME_LIGHT = 0;
    public static final int THEME_DARK = 1;

    public SettingUtil(Context context) {
        pref = context.getSharedPreferences("prefApp", Context.MODE_PRIVATE);
        theme = pref.getInt(CommonUtil.THEME_KEY, 0);
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;

        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(CommonUtil.THEME_KEY, theme);
        editor.apply();
    }
}
