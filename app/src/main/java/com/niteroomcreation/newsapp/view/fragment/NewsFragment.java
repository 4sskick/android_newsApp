package com.niteroomcreation.newsapp.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.niteroomcreation.newsapp.databinding.FNewsBinding;
import com.niteroomcreation.newsapp.model.mock.NewsModelMock;
import com.niteroomcreation.newsapp.util.NewsDiffUtilCallback;
import com.niteroomcreation.newsapp.view.BaseFragment;
import com.niteroomcreation.newsapp.view.adapter.NewsAdapter;

/**
 * Created by Septian Adi Wijaya on 24/03/2021.
 * please be sure to add credential if you use people's code
 */
public class NewsFragment extends BaseFragment {

    public static final String TAG = NewsFragment.class.getSimpleName();

    private FNewsBinding binding;
    private NewsAdapter adapter;

    @Override
    public View onInflateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void initUI() {

        adapter = new NewsAdapter(new NewsDiffUtilCallback());

        binding.newsRv.setLayoutManager(new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL));
        binding.newsRv.setAdapter(adapter);

        //fake data
        NewsModelMock fake = new NewsModelMock();
        adapter.submitList(fake.getFakeListNews());

        binding.newsRvSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //simulate data retrieval on pull to refreshed
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //update data list news
                        //by generating new updated list
                        adapter.submitList(fake.getRandomSortListNews());
                        binding.newsRvSwipe.setRefreshing(false);

                        //notify user update data success
                        //by scrolling on item position
                        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                            @Override
                            public void onItemRangeInserted(int positionStart, int itemCount) {
                                super.onItemRangeInserted(positionStart, itemCount);
                                binding.newsRv.smoothScrollToPosition(positionStart);
                            }
                        });
                    }
                }, 1200);
            }
        });
    }

    @Override
    public void destroyUI() {
        binding = null;
    }
}
