package com.renatusnetwork.survivors.commands;

import com.renatusnetwork.survivors.managers.JobChanceManager;
import com.renatusnetwork.survivors.timers.Timers;
import com.renatusnetwork.survivors.utils.BroadcastUtils;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColor("&4 console cannot to that"));
            return false;
        }

        if (sender.isOp()) {
            BroadcastUtils.broadcastTitle("Survive", "RN-Survivors");

            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                //if (!player.equals(sender)){
                player.getWorld().playSound(player.getLocation(), Sound.PORTAL_TRAVEL, 1, 1);
                JobChanceManager.addMaxPlayers(1);
                //}
            }

            JobChanceManager.setNumJobs(); // Builds max amount of players and corresponding jobs


            Player player = (Player) sender;

            Timers.startXpGain("xptimer");

        }
        return false;
    }
}
