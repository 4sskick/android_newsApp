package com.niteroomcreation.newsapp.view.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.niteroomcreation.newsapp.model.NewsModel;
import com.niteroomcreation.newsapp.view.BaseViewHolder;

/**
 * Created by Septian Adi Wijaya on 26/03/2021.
 * please be sure to add credential if you use people's code
 */
public class NewsAdapter extends ListAdapter<NewsModel, BaseViewHolder> {

    public static final String TAG = NewsAdapter.class.getSimpleName();

    private static final int VIEWTYPE_TEXT = 0;
    private static final int VIEWTYPE_IMAGE = 1;

    protected NewsAdapter(@NonNull DiffUtil.ItemCallback<NewsModel> diffCallback) {
        super(diffCallback);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEWTYPE_TEXT:
                break;

            case VIEWTYPE_IMAGE:
                break;

            default:
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bindData(getItem(position));
    }
}
