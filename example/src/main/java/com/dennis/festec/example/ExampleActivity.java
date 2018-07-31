package com.dennis.festec.example;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Toast;

import com.dennis.latte.ec.launcher.LauncherDelegate;
import com.dennis.latte.ec.launcher.LauncherScrollDelegate;
import com.dennis.latte.ec.main.EcBottomDelegate;
import com.dennis.latte.ec.sign.ISignListener;
import com.dennis.latte.ec.sign.SignInDelegate;
import com.dennis.latte.ec.sign.SignUpDelegate;
import com.dennis.latte_core.activities.ProxyActivity;
import com.dennis.latte_core.app.Latte;
import com.dennis.latte_core.delegates.LatteDelegate;
import com.dennis.latte_core.ui.launcher.ILauncherListener;
import com.dennis.latte_core.ui.launcher.OnLauncherFinishTag;

import qiu.niorgai.StatusBarCompat;

public class ExampleActivity extends ProxyActivity implements
        ISignListener, ILauncherListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        StatusBarCompat.translucentStatusBar(this, true);
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        startWithPop(new EcBottomDelegate());
    }

    @Override
    public void onSignUpSuccess() {
        startWithPop(new SignInDelegate());
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
