package com.niteroomcreation.newsapp.presentation.feature.news.viewholder;

import androidx.annotation.NonNull;

import com.niteroomcreation.newsapp.databinding.INewsTextBinding;
import com.niteroomcreation.newsapp.data.datasource.NewsModel;
import com.niteroomcreation.newsapp.presentation.base.BaseViewHolder;
import com.niteroomcreation.newsapp.util.listener.ItemViewClickListener;

/**
 * Created by Septian Adi Wijaya on 26/03/2021.
 * please be sure to add credential if you use people's code
 * <p>
 * View Holder recycler class for text item view type
 */
public class TextViewHolder extends BaseViewHolder {

    public static final String TAG = TextViewHolder.class.getSimpleName();

    private INewsTextBinding binding;
    private ItemViewClickListener<NewsModel> mListener;

    public TextViewHolder(@NonNull INewsTextBinding binding, @NonNull ItemViewClickListener<NewsModel> mListener) {
        super(binding.getRoot());

        this.binding = binding;
        this.mListener = mListener;
    }

    @Override
    public void bindData(NewsModel model) {
        binding.setNewsTextType(model);
        binding.setCallback(mListener);
    }
}
