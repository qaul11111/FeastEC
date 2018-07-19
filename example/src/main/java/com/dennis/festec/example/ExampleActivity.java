package com.dennis.festec.example;

import com.dennis.latte_core.activities.ProxyActivity;
import com.dennis.latte_core.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {
    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
