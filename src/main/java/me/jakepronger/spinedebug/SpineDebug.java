package me.jakepronger.spinedebug;

import me.jakepronger.spine.Spine;
import me.jakepronger.spine.enums.Permission;
import me.jakepronger.spine.interfaces.Dispatcher;
import org.bukkit.event.player.PlayerJoinEvent;
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
        dispatcher.event(PlayerJoinEvent.class, e -> {
            e.getPlayer().sendMessage("hi labubu");
        });
        dispatcher.register(
                "test",
                (stack) -> {
                    stack.getSender().sendMessage("yoyo! you ran a command!");
                },
                "my command description",
                Permission.ADMIN
        );
    }

    @Override
    public void onDisable() {

    }

}
