package com.renatusnetwork.survivors.listeners;

import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {


    @EventHandler
    public static void onMine(BlockBreakEvent event) {

        Player player = event.getPlayer();

        if (event.getBlock().getType().equals(Material.ENCHANTMENT_TABLE) && !PlayerManager.getPlayerStats(player).isMonster()) {

            event.setCancelled(true);

            player.sendMessage(ColorUtils.translateColor("&cYou cant break your own core!"));

        }

    }


}
