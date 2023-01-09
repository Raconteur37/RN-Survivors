package com.renatusnetwork.survivors.listeners;

import com.renatusnetwork.survivors.items.ItemManager;
import com.renatusnetwork.survivors.jobs.BlacksmithJob;
import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BlacksmithListener implements Listener {

    static ItemStack clay = BlacksmithJob.getSpecialClay();
    static ItemStack refinedMineral = BlacksmithJob.getRefinedMineral();
    static ItemStack armorToken = BlacksmithJob.getArmorToken();
    static ItemStack blacksmithCharm = BlacksmithJob.getBlacksmithCharm();
    static ItemStack weaponToken = BlacksmithJob.getWeaponToken();

    @EventHandler
    public static void onMine(BlockBreakEvent event) {

        Player player = event.getPlayer();
        PlayerStats playerStats = PlayerManager.getPlayerStats(player);

        if (playerStats.getType().equals("blacksmith")) {

            Block block = event.getBlock();

            if (block.getType().equals(Material.COAL_ORE)) {

                /*
                int roll = (int) (Math.random() * (100 - 1)) + 1;
                if (roll <= 75) {
                    player.getInventory().addItem(new ItemStack(Material.COAL));
                }

                 */
                int roll = (int) (Math.random() * (100 - 1)) + 1;
                if (roll <= 35) {
                    player.getInventory().addItem(clay);
                    player.playSound(player.getLocation(), Sound.ANVIL_BREAK,1,1);
                }
                roll = (int) (Math.random() * (100 - 1)) + 1;
                if (roll <= 2) {
                    //player.getInventory().addItem(blacksmithCharm);
                }
            }

        }

    }

    @EventHandler
    public static void onEvent(FurnaceSmeltEvent event) {
        if (event.getSource().hasItemMeta() && event.getSource().getType().equals(Material.CLAY_BALL)) {
            event.setResult(refinedMineral);
        }
    }

    @EventHandler
    public static void onUse(PlayerInteractEvent event) {

        Action action = event.getAction();


        if (action.equals(Action.LEFT_CLICK_BLOCK) && PlayerManager.getPlayerStats(event.getPlayer()).getType().equals("blacksmith")) {

            if (event.getPlayer().getInventory().getItemInHand().hasItemMeta() &&
            event.getPlayer().getInventory().getItemInHand().getType().equals(Material.HOPPER) &&
            event.getClickedBlock().getType().equals(Material.ANVIL)) {

                Player player = event.getPlayer();

                player.getWorld().playEffect(player.getLocation(),Effect.FIREWORKS_SPARK,1);

                ItemManager.removeCertainAmount(player,Material.HOPPER,1);

                int roll = (int) (Math.random() * (100 - 1)) + 1;

                if (roll <= 30) { // weapon token
                    player.getInventory().addItem(weaponToken);
                } else { // armor token
                    player.getInventory().addItem(armorToken);
                }


                roll = (int) (Math.random() * (100 - 1)) + 1;
                if (roll <= 3) {
                    //player.getInventory().addItem(blacksmithCharm);
                }

            }
        }

    }



}
