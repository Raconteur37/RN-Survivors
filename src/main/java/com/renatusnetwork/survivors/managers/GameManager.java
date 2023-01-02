package com.renatusnetwork.survivors.managers;

import org.bukkit.Location;

public class GameManager {

    private static boolean gameStarted = false;
    private static Location monsterSpawn;
    private static Location monsterSpawnTp;


    public static void setGameStatus(boolean b) {
        gameStarted = b;
    }

    public static boolean getGameStatus() {
        return gameStarted;
    }

    public static void setMonsterSpawn(Location loc) {
        monsterSpawn = loc;
    }

    public static Location getMonsterSpawn() {
        return monsterSpawn;
    }

    public static void setMonsterSpawnTp(Location loc) { monsterSpawnTp = loc; }

    public static Location getMonsterSpawnTp() { return monsterSpawnTp; }


}
