package com.dennis.festec.example.generators;

import com.dennis.latte_core.wechat.templates.WXEntryTemplate;
import com.example.annotations.EntryGenerator;

@EntryGenerator(
        packageName = "com.dennis.festec.example",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {



}
