package com.niteroomcreation.newsapp.view.adapter.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.niteroomcreation.newsapp.model.NewsModel;

/**
 * Created by Septian Adi Wijaya on 26/03/2021.
 * please be sure to add credential if you use people's code
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public static final String TAG = BaseViewHolder.class.getSimpleName();

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bindData(NewsModel model);

}
