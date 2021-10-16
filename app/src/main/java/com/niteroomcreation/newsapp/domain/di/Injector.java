package com.niteroomcreation.newsapp.domain.di;

import java.util.concurrent.Executor;

/**
 * Created by Septian Adi Wijaya on 16/10/2021.
 * please be sure to add credential if you use people's code
 */
public class Injector {

    public static Executor provideBackgroundThread() {
        return new Executor() {
            @Override
            public void execute(Runnable command) {
                new Thread(command).start();
            }
        };
    }
}
