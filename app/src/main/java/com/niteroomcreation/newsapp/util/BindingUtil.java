package com.niteroomcreation.newsapp.util;

import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.niteroomcreation.newsapp.R;

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

    @BindingAdapter("set_background")
    public static void setBackground(ImageView imageView, String color) {

        switch (color) {
            case "RED":
                imageView.setBackgroundColor(imageView.getContext().getResources().getColor(R.color.red));
                break;
            case "BLACK":
                imageView.setBackgroundColor(imageView.getContext().getResources().getColor(R.color.black));
                break;
            case "YELLOW":
                imageView.setBackgroundColor(imageView.getContext().getResources().getColor(R.color.yellow));
                break;
            case "BLUE":
                imageView.setBackgroundColor(imageView.getContext().getResources().getColor(R.color.blue));
                break;
            case "PURPLE":
                imageView.setBackgroundColor(imageView.getContext().getResources().getColor(R.color.purple));
                break;
            default:
                imageView.setBackgroundColor(imageView.getContext().getResources().getColor(R.color.red));
        }
    }

    @BindingAdapter("set_checked")
    public static void toggleFav(ImageView view, boolean isFav) {
        if (isFav) {
            view.setColorFilter(ContextCompat.getColor(view.getContext(), R.color.primaryColor));
        } else
            view.setColorFilter(ContextCompat.getColor(view.getContext(), R.color.dark_icon_tint_color));
    }
}
