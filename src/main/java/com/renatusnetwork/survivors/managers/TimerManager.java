package com.renatusnetwork.survivors.managers;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TimerManager {

    static HashMap<String, BukkitTask> timers = new HashMap<>();

    public static void addTimer(String title, BukkitTask runnable) {

        timers.put(title,runnable);

    }

    public static BukkitTask getRunnable(String title) {
        if (timers.containsKey(title)) {
            return timers.get(title);
        } else {
            return null;
        }
    }

    public static boolean exists(String title) {
        return timers.containsKey(title);
    }

    public static void stopTimer(String title) {
        if (exists(title)) {
            BukkitTask bukkitTask = timers.get(title);
            bukkitTask.cancel();
            timers.remove(title);
        }
    }

    public static void stopAllTimers() {

        for (BukkitTask value : timers.values()) {
            value.cancel();
        }
        for (String key : timers.keySet()) {
            timers.remove(key);
        }


    }


}
