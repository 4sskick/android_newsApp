package com.niteroomcreation.newsapp.view.adapter.viewholder;

import androidx.annotation.NonNull;

import com.niteroomcreation.newsapp.databinding.INewsImageBinding;
import com.niteroomcreation.newsapp.model.NewsModel;
import com.niteroomcreation.newsapp.util.ItemViewClickListener;

/**
 * Created by Septian Adi Wijaya on 26/03/2021.
 * please be sure to add credential if you use people's code
 * <p>
 * View Holder recycler class for text item view type
 */
public class ImageViewHolder extends BaseViewHolder {

    public static final String TAG = ImageViewHolder.class.getSimpleName();

    private INewsImageBinding binding;
    private ItemViewClickListener<NewsModel> mListener;

    public ImageViewHolder(@NonNull INewsImageBinding binding, @NonNull ItemViewClickListener<NewsModel> mListener) {
        super(binding.getRoot());

        this.binding = binding;
        this.mListener = mListener;
    }

    @Override
    public void bindData(NewsModel model) {
        binding.setNewsImageType(model);
        binding.setCallback(mListener);
    }
}
