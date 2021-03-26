package com.niteroomcreation.newsapp.view.adapter.viewholder;

import androidx.annotation.NonNull;

import com.niteroomcreation.newsapp.databinding.INewsTextBinding;
import com.niteroomcreation.newsapp.model.NewsModel;

/**
 * Created by Septian Adi Wijaya on 26/03/2021.
 * please be sure to add credential if you use people's code
 * <p>
 * View Holder recycler class for text item view type
 */
public class TextViewHolder extends BaseViewHolder {

    public static final String TAG = TextViewHolder.class.getSimpleName();

    private INewsTextBinding binding;

    public TextViewHolder(@NonNull INewsTextBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @Override
    public void bindData(NewsModel model) {
        binding.setNewsTextType(model);
    }
}
