package com.renatusnetwork.survivors.commands;

import com.renatusnetwork.survivors.timers.Timers;
import com.renatusnetwork.survivors.utils.BroadcastUtils;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WinCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColor("&4 console cannot to that"));
            return false;
        }

        if (sender.isOp()) {

            if (a[0].equalsIgnoreCase("monsters")) {
                BroadcastUtils.broadcastTitle(ColorUtils.translateColor("&4&lMonsters Win"),"gg!");
            }

            if (a[0].equalsIgnoreCase("survivors")) {
                BroadcastUtils.broadcastTitle(ColorUtils.translateColor("&b&lSurvivors Win"),"gg!");
            }


        }
        return false;
    }


}
