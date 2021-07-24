package dev.hypera.chameleon.bungeecord;

import dev.hypera.chameleon.bungeecord.commands.BungeeCordCommand;
import dev.hypera.chameleon.core.Chameleon;
import dev.hypera.chameleon.core.commands.Command;
import dev.hypera.chameleon.core.users.ChatUser;
import net.kyori.adventure.platform.bungeecord.BungeeAudiences;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class BungeeCordChameleon extends Chameleon {

    private final @NotNull Plugin bungeePlugin;
    private final @NotNull BungeeAudiences adventure;

    public BungeeCordChameleon(@NotNull Class<? extends dev.hypera.chameleon.core.Plugin> pluginClass, @NotNull Plugin bungeePlugin) throws InstantiationException {
        super(pluginClass);
        this.bungeePlugin = bungeePlugin;
        this.adventure = BungeeAudiences.create(bungeePlugin);
    }

    public @NotNull Plugin getPlugin() {
        return bungeePlugin;
    }

    public @NotNull BungeeAudiences getAdventure() {
        return adventure;
    }

    @Override
    public void registerCommand(@NotNull Command command) {
        bungeePlugin.getProxy().getPluginManager().registerCommand(bungeePlugin, new BungeeCordCommand(this, command));
    }

    @Override
    public @NotNull ChatUser getConsoleSender() {
        return new ChameleonCommandSender(adventure, bungeePlugin.getProxy().getConsole());
    }

}
