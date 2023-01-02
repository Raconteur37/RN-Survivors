package com.renatusnetwork.survivors.commands;

import com.renatusnetwork.survivors.items.ItemManager;
import com.renatusnetwork.survivors.managers.GameManager;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetMonsterSpawnCMD implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.translateColor("&4 console cannot to that"));
            return false;
        }

        if (sender.isOp()) {

            Player player = (Player) sender;

            GameManager.setMonsterSpawn(player.getLocation());

            player.sendMessage("You set the monster spawn location to here");

        }
        return false;
    }

}
