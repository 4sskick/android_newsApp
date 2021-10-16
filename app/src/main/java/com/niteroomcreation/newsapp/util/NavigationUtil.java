package com.niteroomcreation.newsapp.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.niteroomcreation.newsapp.data.datasource.NewsModel;
import com.niteroomcreation.newsapp.presentation.feature.detail.DetailActivity;

/**
 * Created by Septian Adi Wijaya on 23/09/2021.
 * please be sure to add credential if you use people's code
 */
public class NavigationUtil {

    public static void gotoDetail(Activity activity, NewsModel model) {
        Intent i = new Intent(activity, DetailActivity.class);

        Bundle b = new Bundle();
        b.putParcelable("model", model);
        i.putExtras(b);

        activity.startActivity(i);
    }
}
