package me.jakepronger.spinedebug.features;

import me.jakepronger.spine.api.SpineAPI;
import me.jakepronger.spine.api.command.CommandContext;

import me.jakepronger.spine.api.contract.Feature;
import me.jakepronger.spine.enums.Permission;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Set;

public class TestOLD implements Feature {
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

            // Crucial: Swapping to a 2D item baseline so the block-rendering panic stops!
            ItemStack item = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta meta = item.getItemMeta();

            if (meta != null) {
                // Points to your lowered hand layout
                meta.setItemModel(NamespacedKey.minecraft("air"));
                meta.displayName(Component.empty());

                // Fully blanks out the item tooltip hover text in the inventory UI
                meta.setHideTooltip(true);

                // Your adventure mode blocks remain completely functional here
                Set<Material> set = Set.of(Material.GRASS_BLOCK);
                meta.setCanDestroy(set);

                item.setItemMeta(meta);
            }

            ctx.player().getInventory().setItemInMainHand(item);

        } else {
            ctx.sender().sendMessage("hi console!");
        }
    }
}
