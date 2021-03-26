package com.niteroomcreation.newsapp.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.niteroomcreation.newsapp.R;
import com.niteroomcreation.newsapp.databinding.INewsImageBinding;
import com.niteroomcreation.newsapp.databinding.INewsTextBinding;
import com.niteroomcreation.newsapp.model.NewsModel;
import com.niteroomcreation.newsapp.view.adapter.viewholder.BaseViewHolder;
import com.niteroomcreation.newsapp.view.adapter.viewholder.ImageViewHolder;
import com.niteroomcreation.newsapp.view.adapter.viewholder.TextViewHolder;

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
                INewsTextBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.i_news_text, parent, false);
                return new TextViewHolder(binding);

            case VIEWTYPE_IMAGE:
                INewsImageBinding bindingImg = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.i_news_image, parent, false);
                return new ImageViewHolder(bindingImg);

            default:
                INewsTextBinding bindingDefault = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.i_news_text, parent, false);
                return new TextViewHolder(bindingDefault);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bindData(getItem(position));
    }
}
