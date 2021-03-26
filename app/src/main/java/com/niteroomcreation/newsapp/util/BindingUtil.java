package com.niteroomcreation.newsapp.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

/**
 * Created by Septian Adi Wijaya on 26/03/2021.
 * please be sure to add credential if you use people's code
 * <p>
 * this class is a custom attribute name that able declared into xml layout class
 */
public class BindingUtil {

    @BindingAdapter("glide_url")
    public static void loadImg(ImageView imageView, String url) {
        // we will  use glide library to load the image from a url
        Glide.with(imageView.getContext()).load(url).into(imageView);
        // now let's use this adapter in our xml file
    }

    @BindingAdapter("glide_circular")
    public static void loadCircularImg(ImageView imageView, String url) {

        // glide can make any image in a circular format with ease
        Glide.with(imageView.getContext()).load(url).circleCrop().into(imageView);
    }
}
