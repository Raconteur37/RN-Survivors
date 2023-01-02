package com.renatusnetwork.survivors.listeners;

import com.renatusnetwork.survivors.items.ItemManager;
import com.renatusnetwork.survivors.managers.PlayerManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BuilderListener implements Listener {

    @EventHandler
    public static void onUse(PlayerInteractEvent event) {

        Action action = event.getAction();


        if (action.equals(Action.LEFT_CLICK_BLOCK) && PlayerManager.getPlayerStats(event.getPlayer()).getType().equals("builder")) {

            if (event.getPlayer().getInventory().getItemInHand().hasItemMeta() &&
                    event.getPlayer().getInventory().getItemInHand().getType().equals(Material.HOPPER) &&
                    event.getClickedBlock().getType().equals(Material.SMOOTH_BRICK)) {

                    event.getClickedBlock().setType(Material.OBSIDIAN);

                ItemManager.removeCertainAmount(event.getPlayer(),Material.HOPPER,1);

                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.IRONGOLEM_THROW,1,1);

            }

        }
    }


}
