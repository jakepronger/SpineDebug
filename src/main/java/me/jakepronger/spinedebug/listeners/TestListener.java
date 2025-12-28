package me.jakepronger.spinedebug.listeners;

import org.bukkit.event.player.PlayerJoinEvent;

public class TestListener {

    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("hi labubu");
    }

}
