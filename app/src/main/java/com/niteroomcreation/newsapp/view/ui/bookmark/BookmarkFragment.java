package com.niteroomcreation.newsapp.view.ui.bookmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.niteroomcreation.newsapp.databinding.FBookmarkBinding;
import com.niteroomcreation.newsapp.model.NewsModel;
import com.niteroomcreation.newsapp.util.NewsDiffUtilCallback;
import com.niteroomcreation.newsapp.view.BaseFragment;
import com.niteroomcreation.newsapp.view.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Septian Adi Wijaya on 23/09/2021.
 * please be sure to add credential if you use people's code
 */
public class BookmarkFragment extends BaseFragment {

    public static final String TAG = BookmarkFragment.class.getSimpleName();

    private FBookmarkBinding binding;
    private NewsAdapter adapter;

    @Override
    public View onInflateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FBookmarkBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void initUI() {

        if (getArguments() != null && getArguments().getParcelableArrayList("model") != null) {
            adapter = new NewsAdapter(new NewsDiffUtilCallback(), null);

            binding.bookmarkRv.setLayoutManager(new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL));
            binding.bookmarkRv.setAdapter(adapter);

            List<NewsModel> data = new ArrayList<>();
            for (int i = 0; i < getArguments().getParcelableArrayList("model").size(); i++) {
                data.add((NewsModel) getArguments().getParcelableArrayList("model").get(i));
            }
            adapter.submitList(data);
        } else {
            showProgressLoading("WARNING", "Data doesn't load as expected");
        }
    }

    @Override
    public void destroyUI() {
        binding = null;
    }
}
