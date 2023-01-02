package com.renatusnetwork.survivors.monsters;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class MonsterManager {

    public static void TpMonster(Player player) {

        Location loc = player.getLocation();

        int roll = (int) (Math.random() * (20 - 1));

        int x = loc.getBlockX() + roll;
        int y = loc.getBlockY() + 2;
        roll = (int) (Math.random() * (20 - 1));

        int z = loc.getBlockZ() + roll;
        World w = loc.getWorld();
        Location location = new Location(w, x, y, z);

        player.teleport(location);

    }

}
