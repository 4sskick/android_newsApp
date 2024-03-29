package com.niteroomcreation.newsapp.presentation.feature.news;

import android.content.Context;
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
import com.niteroomcreation.newsapp.data.datasource.NewsModel;
import com.niteroomcreation.newsapp.data.datasource.local.mock.NewsModelMock;
import com.niteroomcreation.newsapp.util.listener.ItemEventsListener;
import com.niteroomcreation.newsapp.util.listener.ItemViewClickListener;
import com.niteroomcreation.newsapp.util.NavigationUtil;
import com.niteroomcreation.newsapp.util.CallbackDiffUtil;
import com.niteroomcreation.newsapp.presentation.base.BaseFragment;

import java.util.List;

/**
 * Created by Septian Adi Wijaya on 24/03/2021.
 * please be sure to add credential if you use people's code
 */
public class NewsFragment
        extends BaseFragment
        implements ItemViewClickListener<NewsModel> {

    public static final String TAG = NewsFragment.class.getSimpleName();

    private FNewsBinding binding;
    private NewsAdapter adapter;
    private ItemEventsListener<List<NewsModel>> mEventListener;

    @Override
    public View onInflateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void initUI() {

        adapter = new NewsAdapter(new CallbackDiffUtil(), this);

        binding.newsRv.setLayoutManager(new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL));
        binding.newsRv.setAdapter(adapter);

        //fake data
        NewsModelMock fake = new NewsModelMock();
        List<NewsModel> data = fake.getFakeListNews();
        adapter.submitList(data);

        //invoke into listener
        mEventListener.onDataLoaded(data);

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
                        List<NewsModel> dataRefreshed = fake.getRandomSortListNews();
                        adapter.submitList(dataRefreshed);

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

                        mEventListener.onDataLoaded(dataRefreshed);
                    }
                }, 1200);
            }
        });
    }

    @Override
    public void destroyUI() {
        binding = null;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ItemEventsListener) {
            mEventListener = (ItemEventsListener<List<NewsModel>>) context;
        } else
            throw new RuntimeException(context.getClass() + " doesn't implement ItemEventsListener");
    }

    @Override
    public void onItemClicked(NewsModel model) {
        NavigationUtil.gotoDetail(getActivity(), model);
    }
}
