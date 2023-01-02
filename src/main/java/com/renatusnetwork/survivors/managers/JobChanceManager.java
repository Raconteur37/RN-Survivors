package com.renatusnetwork.survivors.managers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class JobChanceManager {

    static int totalPlayers;

    static int currBuilders = 0;
    static int currBlacksmiths = 0;
    static int currBakers = 0;
    static int currAlchemists = 0;

    static final double BUILDER_CHANCE = .50;
    static final double BLACKSMITH_CHANCE = .25;
    static final double BAKER_CHANCE = .125;
    static final double ALCHEMIST_CHANCE = .125;

    static int maxBuilders,maxBlacksmiths,maxBakers,maxAlchemist;

    public static void editJobCount(String job, boolean op) {

        switch (job) {

            case("builder"): {
                if (op)
                    currBuilders++;
                else
                    currBuilders--;
                break;
            }

            case("blacksmith"): {
                if (op)
                    currBlacksmiths++;
                else
                    currBlacksmiths--;
                break;
            }

            case("baker"): {
                if (op)
                    currBakers++;
                else
                    currBakers--;
                break;
            }

            case("alchemist"): {
                if (op)
                    currAlchemists++;
                else
                    currAlchemists--;
                break;
            }

            default: {
                Bukkit.getConsoleSender().sendMessage("Error adding job in job chance manager");
            }

        }

    }

    public static void clearMaxJobs() {

        if (reachedMaxBuilders()) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (player.getInventory().contains(Material.RECORD_12)) {
                    player.getInventory().remove(Material.RECORD_12);
                }
            }
        }
        if (reachedMaxBlacksmiths()) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (player.getInventory().contains(Material.RECORD_8)) {
                    player.getInventory().remove(Material.RECORD_8);
                }
            }
        }
        if (reachedMaxBakers()) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (player.getInventory().contains(Material.RECORD_4)) {
                    player.getInventory().remove(Material.RECORD_4);
                }
            }
        }
        if (reachedMaxAlchemists()) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (player.getInventory().contains(Material.RECORD_6)) {
                    player.getInventory().remove(Material.RECORD_6);
                }
            }
        }
    }

    public static void addMaxPlayers(int player) {
        totalPlayers += player;
    }

    public static void setNumJobs() {
        maxBuilders = (int) Math.ceil(totalPlayers * BUILDER_CHANCE);
        maxBlacksmiths = (int) Math.ceil(totalPlayers * BLACKSMITH_CHANCE);
        maxBakers = (int) Math.ceil(totalPlayers * BAKER_CHANCE);
        maxAlchemist = (int) Math.ceil(totalPlayers * ALCHEMIST_CHANCE);
    }

    public static boolean reachedMaxBuilders() {
        return (currBuilders >= maxBuilders);
    }

    public static boolean reachedMaxBlacksmiths() {
        return (currBlacksmiths >= maxBlacksmiths);
    }

    public static boolean reachedMaxBakers() {
        return (currBakers >= maxBakers);
    }

    public static boolean reachedMaxAlchemists() {
        return (currAlchemists >= maxAlchemist);
    }




}
