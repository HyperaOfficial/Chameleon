package dev.hypera.chameleon.bungeecord.test;

import dev.hypera.chameleon.bungeecord.BungeeCordChameleon;
import dev.hypera.chameleon.common.test.MyPlugin;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * This class represents the code needed for a Chameleon project to support BungeeCord.
 */
public class MyBungeeCord extends Plugin {

    private BungeeCordChameleon chameleon;

    @Override
    public void onEnable() {
        chameleon = new BungeeCordChameleon(this) {
            private final MyPlugin myPlugin = new MyPlugin(this);
            @Override public void onEnable() {myPlugin.onEnable();}
            @Override public void onDisable() {myPlugin.onDisable();}
        };
        chameleon.onEnable();
    }

    @Override
    public void onDisable() {
        chameleon.onDisable();
    }

}
