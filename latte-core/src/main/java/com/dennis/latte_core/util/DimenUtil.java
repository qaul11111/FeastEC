package com.dennis.latte_core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.dennis.latte_core.app.Latte;

public class DimenUtil {

    /**
     * 获取屏幕宽度
     * @return
     */
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     * @return
     */
    public static int getScreenHeight() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
