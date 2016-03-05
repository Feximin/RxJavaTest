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
public class ActivityObserverOn extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView txt = new TextView(this);
        txt.setText("线程高度-observerOn，运行于哪个线程取决于之前最近的一条observerOn命令");
        setContentView(txt);


        Observable.just("Hello world")
                //默认运行在subscribeOn指定的线程，io线程
                .map(s -> {
                    String name = Thread.currentThread().getName();
                    return s;
                })
                .observeOn(Schedulers.io())
                //io线程1
                .map(s -> {
                    String name = Thread.currentThread().getName();
                    return s;
                })
                //io线程1
                .map(s -> {
                    String name = Thread.currentThread().getName();
                    return s;
                })
                .observeOn(AndroidSchedulers.mainThread())
                //main线程
                .map(s -> {
                    String name = Thread.currentThread().getName();
                    return s;
                })
                //main线程
                .map(s -> {
                    String name = Thread.currentThread().getName();
                    return s;
                })
                .observeOn(Schedulers.io())
                //io线程2
                .map(s -> {
                    String name = Thread.currentThread().getName();
                    return s;
                })
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}
