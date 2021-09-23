package com.niteroomcreation.newsapp.util;

/**
 * Created by Septian Adi Wijaya on 23/09/2021.
 * please be sure to add credential if you use people's code
 */
public interface ItemEventsListener<T> {
    void onDataLoaded(T models);
}
