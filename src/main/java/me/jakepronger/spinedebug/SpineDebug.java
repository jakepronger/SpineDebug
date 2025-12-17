package me.jakepronger.spinedebug;

import me.jakepronger.spine.Spine;
import me.jakepronger.spine.interfaces.Dispatcher;
import org.bukkit.plugin.java.JavaPlugin;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SpineDebug extends JavaPlugin {

    private SpineDebug plugin;
    private Spine spine;
    private Dispatcher dispatcher;

    @Override
    public void onEnable() {
        this.plugin = this;
        this.spine = new Spine(plugin);
    }

    @Override
    public void onDisable() {

    }

}
