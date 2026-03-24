package me.jakepronger.spinedebug;

import me.jakepronger.spine.Spine;
import me.jakepronger.spine.core.FeatureEngine;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SpineDebug extends JavaPlugin {

    private Spine spine;

    private Logger log;

    @Override
    public void onEnable() {
        this.spine = new Spine(this);
        FeatureEngine
        features();

        log.info("Enabled");
    }

    @Override
    public void onDisable() {
        log.info("Disabled");
    }

    private void features() {
        //spine.feature();
    }

    private void listeners() {
        /*registry.listener(PlayerJoinEvent.class, new TestListener()::onJoin)
                .register();*/
    }

    private void commands() {
        /*registry.command(
                "test",
                      new TestCommand()::onCommand
                )
                .description("my command description")
                .permission(Permission.ADMIN)
                .register();*/
    }

}
