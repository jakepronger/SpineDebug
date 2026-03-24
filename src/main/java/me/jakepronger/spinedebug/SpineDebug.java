package me.jakepronger.spinedebug;

import me.jakepronger.spine.Spine;
import me.jakepronger.spine.core.FeatureEngine;
import me.jakepronger.spinedebug.features.Test;
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
    }

}
