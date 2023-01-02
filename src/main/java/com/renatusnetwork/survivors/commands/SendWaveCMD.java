package com.renatusnetwork.survivors.commands;

import com.renatusnetwork.survivors.Survivors;
import com.renatusnetwork.survivors.items.ItemManager;
import com.renatusnetwork.survivors.managers.TimerManager;
import com.renatusnetwork.survivors.timers.Timers;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class SendWaveCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColor("&4 console cannot to that"));
            return false;
        }

        if (sender.isOp()) {

            Player player = (Player) sender;

            Location loc = player.getLocation();

            Timers.summonZombies(loc,"wavetimer");


        }
        return false;
    }

    public static Zombie dangerousZombie(Location loc) {

        int roll = (int) (Math.random() * (20 - 1));

        int miniroll = (int) (Math.random() * (20 - 1)) + 1;

        if (miniroll > 10) {
            roll = roll * -1;
        }

        int x = loc.getBlockX() + roll;
        int y = loc.getBlockY() + 2;
        roll = (int) (Math.random() * (20 - 1));

        miniroll = (int) (Math.random() * (20 - 1)) + 1;

        if (miniroll > 10) {
            roll = roll * -1;
        }

        int z = loc.getBlockZ() + roll;
        World w = loc.getWorld();
        Location location = new Location(w, x, y, z);

        Zombie zombie = w.spawn(location,Zombie.class);
        zombie.setCustomName(ColorUtils.translateColor("&c&lDeadly Zombie"));
        zombie.setCustomNameVisible(true);

        zombie.setMaxHealth(40);
        zombie.setHealth(40);

        zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,9999,0));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,9999,0));

        for (int i = 0; i < 100; i++) {
            w.playEffect(location, Effect.MOBSPAWNER_FLAMES,10,10);
        }

        return zombie;
    }


}
