package me.jakepronger.spinedebug.listeners;

import me.jakepronger.spinedebug.SpineDebug;
import net.kyori.adventure.text.Component;
import net.minecraft.data.Main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.Set;

public class TestListener implements Listener {

    private JavaPlugin plugin;
    public TestListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("hi labubu");
    }

    private int taskID;

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        /*
        e.getPlayer().sendMessage("debug 1 playterinteractevent: " + e.getAction().isLeftClick());
        if (!e.getAction().isLeftClick())
            return;
        if (e.isBlockInHand())
            return;
        Player p = e.getPlayer();
        ItemStack item = new ItemStack(Material.STRUCTURE_VOID);
        ItemMeta meta = item.getItemMeta();
        meta.setItemModel(NamespacedKey.minecraft("air"));
        meta.displayName(Component.empty());
        meta.setHideTooltip(true);
        meta.setCanDestroy(Set.of(Material.GRASS_BLOCK));
        item.setItemMeta(meta);
        p.getInventory().setItemInMainHand(item);
        e.getPlayer().sendMessage("isHandRaised? " + p.isHandRaised());
        e.getPlayer().isHandRaised();
         */
        if (e.getClickedBlock() == null)
            return;
        Block b = e.getClickedBlock();
        if (b.getType() != Material.GRASS_BLOCK)
            return;
        Player p = e.getPlayer();

        if (taskID != 0) {
            return;

        if (p.getGameMode() != GameMode.SURVIVAL)
            p.setGameMode(GameMode.SURVIVAL);

        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            @Override
            public void run() {
                if (p.)
                p.setGameMode(GameMode.ADVENTURE);
                taskID = 0;
            }
        }, 2, 2);
    }


    private Location blockLoc;
    private Set<Material> materials = Set.of(Material.GRASS_BLOCK);

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        /*
        Bukkit.broadcastMessage("Player moved");
        Player player = event.getPlayer();
        Block targetBlock = player.getTargetBlockExact(5);


        // Logic: If looking at a valid material, set to SURVIVAL.
        // Otherwise, ensure they are in ADVENTURE.
        if (targetBlock != null && materials.contains(targetBlock.getType())) {
            highlightBlock(player, targetBlock);
            if (player.getGameMode() != GameMode.SURVIVAL) {
                player.setGameMode(GameMode.SURVIVAL);
            }
        } else {
            // This covers looking at air, non-listed blocks, or null targets
            if (player.getGameMode() != GameMode.ADVENTURE) {
                player.setGameMode(GameMode.ADVENTURE);
            }
        }
         */
    }

    public void highlightBlock(Player player, Block block) {
        // Check if we already have an entity for this - you'd store this in a Map<Player, Entity>
        // Spawn a Display entity that mimics the block with a slight scale
        BlockDisplay outline = player.getWorld().spawn(block.getLocation(), BlockDisplay.class, e -> {
            e.setBlock(block.getBlockData());
            e.setTransformation(new Transformation(
                    new Vector3f(-0.01f, -0.01f, -0.01f), // Offset
                    new Quaternionf(),
                    new Vector3f(1.02f, 1.02f, 1.02f),    // Scale (slightly larger)
                    new Quaternionf()
            ));
        });
        // You would then task-schedule the removal of this entity
        // to keep it synced with where the player is looking.
    }



}
