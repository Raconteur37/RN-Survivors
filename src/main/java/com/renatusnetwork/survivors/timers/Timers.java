package com.renatusnetwork.survivors.timers;

import com.renatusnetwork.survivors.Survivors;
import com.renatusnetwork.survivors.commands.SendWaveCMD;
import com.renatusnetwork.survivors.managers.TimerManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Timers {

    public static void startXpGain(String title) {

        if (!TimerManager.exists(title)) {
            BukkitTask timer = new BukkitRunnable() {
                @Override
                public void run() {
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        player.setLevel(player.getLevel() + 1);
                    }
                }
            }.runTaskTimerAsynchronously(Survivors.getPlugin(), 30, 40);
            TimerManager.addTimer("xptimer",timer);
        }

    }

    public static void summonZombies(Location loc, String title) {

        if (!TimerManager.exists(title)) {
            BukkitTask timer = new BukkitRunnable() {
                @Override
                public void run() {
                    SendWaveCMD.dangerousZombie(loc);
                }
            }.runTaskTimer(Survivors.getPlugin(), 20, 20);
            TimerManager.addTimer("wavetimer",timer);
        }


    }



}
