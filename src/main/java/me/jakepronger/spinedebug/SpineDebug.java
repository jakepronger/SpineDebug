package me.jakepronger.spinedebug;

import me.jakepronger.spine.Spine;
import me.jakepronger.spine.interfaces.Dispatcher;
import org.bukkit.plugin.java.JavaPlugin;

public class SpineDebug extends JavaPlugin {

    private SpineDebug plugin;

    private Spine spine;
    private Dispatcher dispatcher;

    @Override
    public void onEnable() {
        this.plugin = this;
        this.spine = new Spine(plugin);
        this.dispatcher = spine.getDispatcher();
    }

    @Override
    public void onDisable() {

    }

}
