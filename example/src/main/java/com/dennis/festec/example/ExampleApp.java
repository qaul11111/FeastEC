package com.dennis.festec.example;

import android.app.Application;

import com.dennis.latte_core.app.Latte;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1")
                .configure();
    }
}
