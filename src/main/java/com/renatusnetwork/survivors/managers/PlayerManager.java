package com.renatusnetwork.survivors.managers;

import com.renatusnetwork.survivors.objects.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class PlayerManager {

    private static final ArrayList<PlayerStats> playerStatsList = new ArrayList<>();

    public static void addPlayerStats(PlayerStats player) {
        playerStatsList.add(player);
    }

    public static void removePlayerStats(PlayerStats playerStats) {
        playerStatsList.remove(playerStats);
    }

    public static PlayerStats getPlayerStats(Player player) {
        UUID uuid = player.getUniqueId();
        for (PlayerStats playerStat : playerStatsList) {
            if (uuid.equals(playerStat.getUuid())) {
                return playerStat;
            }
        }
        return null;
    }






}
