package me.jakepronger.spinedebug;

import me.jakepronger.spine.Spine;
import me.jakepronger.spine.enums.Permission;
import me.jakepronger.spine.managers.ConfigManager;
import me.jakepronger.spine.managers.RegistryManager;
import me.jakepronger.spinedebug.commands.TestCommand;
import me.jakepronger.spinedebug.listeners.TestListener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SpineDebug extends JavaPlugin {

    private SpineDebug plugin;
    private Spine spine;

    private RegistryManager registry;
    private ConfigManager config;

    private Logger log;

    @Override
    public void onEnable() {
        this.plugin = this;
        this.log = plugin.getLogger();

        this.spine = new Spine(plugin);
        this.registry = spine.getRegistry();
        this.config = spine.getConfig();

        listeners();
        commands();

        log.info("Enabled");
    }

    @Override
    public void onDisable() {
        log.info("Disabled");
    }

    private void listeners() {
        registry.listener(PlayerJoinEvent.class, new TestListener()::onJoin)
                .register();
    }

    private void commands() {
        registry.command(
                "test",
                      new TestCommand()::onCommand
                )
                .description("my command description")
                .permission(Permission.ADMIN)
                .register();
    }

}
