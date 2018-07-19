package com.dennis.latte.ec.icon;

import com.joanzapata.iconify.Icon;

public enum  EcIcons implements Icon {
    icon_scan('\ue657'),
    icon_ali_pay('\ue60f');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
