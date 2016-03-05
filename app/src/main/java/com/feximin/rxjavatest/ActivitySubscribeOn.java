package com.feximin.rxjavatest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Neo on 16/3/5.
 */
public class ActivitySubscribeOn extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView txt = new TextView(this);
        txt.setText("线程高度-subscribeOn，默认运行的线程取决于最早的一条subscribeOn命令，如果未指定，则运行在subscribe命令执行时所在的线程");
        setContentView(txt);


        Observable.just("Hello world")
                //默认运行在subscribeOn指定的线程，io线程
                .map(s -> {
                    String name = Thread.currentThread().getName();
                    return s;
                })
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe();
        Observable.just("Hello world")
                //默认运行在subscribeOn指定的线程，主线程
                .map(s -> {
                    String name = Thread.currentThread().getName();
                    return s;
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe();
        Observable.just("Hello world")
                //默认运行在subscribe所在的线程，主线程
                .map(s -> {
                    String name = Thread.currentThread().getName();
                    return s;
                })
                .subscribe();
    }
}
