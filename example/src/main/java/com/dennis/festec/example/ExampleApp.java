package com.dennis.festec.example;

import android.app.Application;

import com.dennis.latte.ec.icon.FontEcModule;
import com.dennis.latte_core.app.Latte;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1")
                .configure();
    }
}
