package com.dennis.festec.example.generators;

import com.dennis.latte_core.wechat.templates.WXPayEntryTemplate;
import com.example.annotations.PayEntryGenerator;

@PayEntryGenerator(
        packageName = "com.dennis.festec.example",
        payEntryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
