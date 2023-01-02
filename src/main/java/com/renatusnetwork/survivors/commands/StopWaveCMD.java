package com.renatusnetwork.survivors.commands;

import com.renatusnetwork.survivors.managers.TimerManager;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopWaveCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColor("&4 console cannot to that"));
            return false;
        }

        if (sender.isOp()) {
            TimerManager.stopTimer("wavetimer");
        }

        return false;

    }



}


