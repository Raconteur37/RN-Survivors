package com.renatusnetwork.survivors.listeners;

import com.renatusnetwork.survivors.managers.JobChanceManager;
import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        PlayerStats playerStats = new PlayerStats(player);
        PlayerManager.addPlayerStats(playerStats);

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        PlayerStats playerStats = PlayerManager.getPlayerStats(player);

        if (playerStats != null) {
            String type = playerStats.getType();

            JobChanceManager.editJobCount(type,false);

            PlayerManager.removePlayerStats(playerStats);
        }




    }

}
