package com.renatusnetwork.survivors.listeners;

import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener implements Listener {



    @EventHandler
    public static void onDrop(PlayerDropItemEvent event) {

        Player player = event.getPlayer();

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);

        if (playerStats.isEssentialItem(event.getItemDrop().getItemStack())) {
            event.setCancelled(true);
            player.sendMessage(ColorUtils.translateColor("&cYou cant drop essential items!"));
        }

    }


}
