package com.niteroomcreation.newsapp.util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.niteroomcreation.newsapp.model.NewsModel;

/**
 * Created by monta on 27/04/21
 * please make sure to use credit when using people code
 **/
public class NewsDiffUtilCallback extends DiffUtil.ItemCallback<NewsModel> {

    public static final String TAG = NewsDiffUtilCallback.class.getSimpleName();

    @Override
    public boolean areItemsTheSame(@NonNull NewsModel oldItem, @NonNull NewsModel newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull NewsModel oldItem, @NonNull NewsModel newItem) {
        return oldItem.getId() == newItem.getId();
    }
}
