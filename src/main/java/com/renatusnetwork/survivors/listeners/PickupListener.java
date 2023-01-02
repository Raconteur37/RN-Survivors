package com.renatusnetwork.survivors.listeners;

import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickupListener implements Listener {

    @EventHandler
    public static void onItemPickup(PlayerPickupItemEvent event) {

        Player player = event.getPlayer();

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);

        if (playerStats.isMonster()) {
            event.setCancelled(true);
        }


    }


}
