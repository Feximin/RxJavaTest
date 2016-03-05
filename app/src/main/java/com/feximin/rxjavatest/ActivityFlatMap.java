package com.feximin.rxjavatest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by Neo on 16/3/5.
 */
public class ActivityFlatMap extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView txt = new TextView(this);
        txt.setText("操作符-flatMap，将一种类型转化为Observable以与发射时的类型无关");
        setContentView(txt);

        Observable.just("Hello world")
                .flatMap(new Func1<String, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(String s) {
                        Integer[] arr = new Integer[]{0, 1, 2};
                        return Observable.from(arr);
                    }
                }).subscribe(new Action1<Integer>() {
                @Override
                public void call(Integer integer) {
                    //发
                }
        });
    }
}
