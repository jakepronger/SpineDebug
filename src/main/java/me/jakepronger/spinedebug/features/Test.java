package me.jakepronger.spinedebug.features;

import me.jakepronger.spine.api.SpineAPI;
import me.jakepronger.spine.api.command.CommandContext;
import me.jakepronger.spine.core.Feature;
import me.jakepronger.spine.enums.Permission;

public class Test implements Feature {
    @Override
    public void load(SpineAPI api) {
        api.command("test", this::command)
                .description("Test command")
                .alias("test1")
                .cooldown(5)
                .permission(Permission.ADMIN)
                .register(); // todo: have .audience(PLAYER, CONSOLE, BOTH) def both? & Should command have SpineAPI?
    }

    private void command(CommandContext ctx) {
        if (ctx.isPlayer()){
            ctx.player().sendMessage("hi player: " + ctx.player().getName());
        } else {
            ctx.sender().sendMessage("hi console!");
        }
    }
}
