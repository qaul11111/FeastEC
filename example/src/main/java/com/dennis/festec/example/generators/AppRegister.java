package com.dennis.festec.example.generators;


import com.dennis.latte_core.wechat.templates.AppRegisterTemplate;
import com.example.annotations.AppRegisterGenerator;

@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.dennis.festec.example",
        registerTemplete = AppRegisterTemplate.class
)
public interface AppRegister {
}
