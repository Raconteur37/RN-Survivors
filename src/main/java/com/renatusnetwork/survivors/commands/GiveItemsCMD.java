package com.renatusnetwork.survivors.commands;

import com.renatusnetwork.survivors.items.ItemManager;
import com.renatusnetwork.survivors.managers.JobChanceManager;
import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import com.renatusnetwork.survivors.utils.BroadcastUtils;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveItemsCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColor("&4 console cannot to that"));
            return false;
        }

        if (a[0].equalsIgnoreCase("stats")) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                PlayerStats playerStats = PlayerManager.getPlayerStats(player);
                if (playerStats != null) {
                    sender.sendMessage(playerStats.getPlayer().getName() + " kills: " + playerStats.getKills());
                }
            }
        }

        if (sender.isOp()) {
            for (int x  = 0; x < 64; x++) {
                ItemManager.giveItemToken((Player)sender);
            }
            ItemManager.giveMonsterToken(((Player) sender));
        }
        return false;
    }

}
