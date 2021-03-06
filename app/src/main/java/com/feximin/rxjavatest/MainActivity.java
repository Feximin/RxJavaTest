package com.feximin.rxjavatest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.but_0).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ActivityObserverOn.class)));
        findViewById(R.id.but_1).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ActivitySubscribeOn.class)));
        findViewById(R.id.but_2).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ActivityMap.class)));
        findViewById(R.id.but_3).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ActivityFlatMap.class)));

    }
}
