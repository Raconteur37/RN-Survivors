package com.renatusnetwork.survivors.listeners;

import com.renatusnetwork.survivors.items.ItemManager;
import com.renatusnetwork.survivors.jobs.BakerJob;
import com.renatusnetwork.survivors.jobs.BlacksmithJob;
import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.FlowerPot;

public class BakerListener implements Listener {

    static ItemStack spice = BakerJob.getBackerSpice();
    static ItemStack sweetener = BakerJob.getBakerSweetener();
    static ItemStack WHEAT = BakerJob.getBakerTang();


    @EventHandler
    public static void onEvent(PlayerInteractEvent event) {

        Action action = event.getAction();


        if (action.equals(Action.RIGHT_CLICK_BLOCK) && PlayerManager.getPlayerStats(event.getPlayer()).getType().equals("baker")) {

            if (event.getPlayer().getInventory().getItemInHand().hasItemMeta() &&
                    event.getPlayer().getInventory().getItemInHand().getType().equals(Material.SUGAR) &&
                    event.getClickedBlock().getType().equals(Material.FLOWER_POT)) {

                Player player = event.getPlayer();

                int roll = (int) (Math.random() * (100 - 1)) + 1;

                if (roll <= 40) {
                    player.getInventory().addItem(spice);
                    player.playSound(player.getLocation(), Sound.SHOOT_ARROW,1,1);
                }else if (roll <= 90) {
                    player.getInventory().addItem(sweetener);
                    player.playSound(player.getLocation(), Sound.SHOOT_ARROW,1,1);
                }
                if (roll > 90) {
                    player.getInventory().addItem(WHEAT);
                }

                ItemManager.removeCertainAmount(player,Material.SUGAR,1);

            }
        }


    }

}



