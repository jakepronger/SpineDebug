package me.jakepronger.spinedebug;

import me.jakepronger.spine.Spine;
import me.jakepronger.spinedebug.features.Test;
import me.jakepronger.spinedebug.listeners.TestListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SpineDebug extends JavaPlugin {

    private Spine spine;

    private Logger log;

    @Override
    public void onEnable() {
        log = getLogger();
        this.spine = new Spine(this);
        features();

        log.info("Enabled");
    }

    @Override
    public void onDisable() {
        log.info("Disabled");
    }

    private void features() {
        spine.feature(Test.class);
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new TestListener(), this);
    }

}
