package com.renatusnetwork.survivors.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BroadcastUtils {

    public static void broadcastTitle(String main, String subtitle) {

        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.sendTitle(ColorUtils.translateColor("&5&l" + main),subtitle);
        }
    }


}
