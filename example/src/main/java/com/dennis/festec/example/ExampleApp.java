package com.dennis.festec.example;

import android.app.Application;

import com.dennis.latte.ec.database.DatabaseManager;
import com.dennis.latte.ec.icon.FontEcModule;
import com.dennis.latte_core.app.Latte;
import com.dennis.latte_core.net.interceptors.DebugInterceptor;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://192.168.1.105:8080/RestServer/api/")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .configure();

        initStetho();
        DatabaseManager.getInstance().init(this);
    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        );
    }
}
