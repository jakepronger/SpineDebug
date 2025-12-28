package me.jakepronger.spinedebug.commands;

import io.papermc.paper.command.brigadier.CommandSourceStack;

public class TestCommand {

    public void onCommand(CommandSourceStack stack) {
        stack.getSender().sendMessage("yoyo! hi!");
    }

}
