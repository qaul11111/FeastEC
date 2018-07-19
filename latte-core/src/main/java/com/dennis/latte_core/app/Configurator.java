package com.dennis.latte_core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 配置文件的存储和获取
 */
public class Configurator {

    // WeakHashMap 键值对在不使用的时候会进行回收, 并且非常及时, 但是在配置中使用不合适
    private static final HashMap<String, Object> LATTE_CONFIGS = new HashMap<>();

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator() {
        // 刚刚初始化的时候, 配置必定是没有完成的
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    /**
     * 静态内部类的单列模式
     */
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        initIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    /**
     * 初始化 apiHost
     *
     * @param host
     * @return
     */
    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    /**
     * 初始化字体
     *
     * @param descriptor
     * @return
     */
    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    /**
     * 检查配置完整性
     */
    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }
}
