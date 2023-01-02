package com.renatusnetwork.survivors.listeners;

import com.renatusnetwork.survivors.items.ItemManager;
import com.renatusnetwork.survivors.managers.GameManager;
import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathListener implements Listener {

    @EventHandler
    public static void onDeath(PlayerDeathEvent event) {

        Player player = event.getEntity();

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);

        if (!playerStats.isMonster()) {
            player.getWorld().spawnEntity(player.getLocation(), EntityType.LIGHTNING);
            Bukkit.broadcastMessage(ColorUtils.translateColor(""+player.getDisplayName() + " &lHAS FALLEN"));

            player.getInventory().clear();
            playerStats.setMonster(true);

        }

    }

    @EventHandler
    public static void onRespawn(PlayerRespawnEvent event) {

        Player player = event.getPlayer();

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);

        if (playerStats.isMonster()) {

            playerStats.setMonsterType("none");

            player.teleport(GameManager.getMonsterSpawn());

            ItemManager.giveMonsterToken(player);


        }



    }





}
