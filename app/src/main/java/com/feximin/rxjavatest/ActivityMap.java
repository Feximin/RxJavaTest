package com.feximin.rxjavatest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import rx.Observable;

/**
 * Created by Neo on 16/3/5.
 */
public class ActivityMap extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView txt = new TextView(this);
        txt.setText("操作符-map，将一种类型转化为另一种类型，新的类型可以与发射时的类型无关");
        setContentView(txt);

        Observable.just("Hello world")
                .map(s -> s.hashCode())
                .map(integer -> String.valueOf(integer))
                .subscribe();

    }
}
