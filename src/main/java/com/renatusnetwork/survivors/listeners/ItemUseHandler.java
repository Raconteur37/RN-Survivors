package com.renatusnetwork.survivors.listeners;

import com.renatusnetwork.survivors.items.ItemManager;
import com.renatusnetwork.survivors.jobs.AlchemistJob;
import com.renatusnetwork.survivors.jobs.BakerJob;
import com.renatusnetwork.survivors.jobs.BlacksmithJob;
import com.renatusnetwork.survivors.jobs.BuilderJob;
import com.renatusnetwork.survivors.managers.JobChanceManager;
import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.monsters.*;
import com.renatusnetwork.survivors.objects.PlayerStats;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ItemUseHandler implements Listener {

    @EventHandler
    public static void onUse(PlayerInteractEvent event) {

        Action action = event.getAction();

        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {

            Player player = event.getPlayer();
            PlayerStats playerStats = PlayerManager.getPlayerStats(player);

            ItemStack item =  player.getInventory().getItemInHand();

            if (item.hasItemMeta()) {

                Material material = item.getType();

                if (material.equals(Material.GOLD_NUGGET)) {
                    if (playerStats.getType().equals("none")) {
                        player.getInventory().remove(Material.GOLD_NUGGET);
                        //int role = (int) (Math.random() * (100 - 1)) + 1;
                        if (!JobChanceManager.reachedMaxBuilders()) {
                            ItemManager.giveBuilderItem(player);
                        }
                        if (!JobChanceManager.reachedMaxBlacksmiths()) {
                            ItemManager.giveBlacksmithItem(player);
                        }
                        if (!JobChanceManager.reachedMaxBakers()) {
                            ItemManager.giveBakerItem(player);
                        }
                        if (!JobChanceManager.reachedMaxAlchemists()) {
                            ItemManager.giveAlchemistItem(player);
                        }

                    } else {
                        player.sendMessage(ColorUtils.translateColor("&cYou already have a class!"));
                    }
                }

                if (material.equals(Material.RECORD_12)) {
                    if (playerStats.getType().equals("none")) {
                        ItemManager.clearJobItems(player);
                        ItemManager.giveSpecialBook(player);
                        BuilderJob.applyJob(player);
                        JobChanceManager.editJobCount(playerStats.getType(),true);
                        JobChanceManager.clearMaxJobs();
                    } else {
                        player.sendMessage(ColorUtils.translateColor("&cYou already have a class!"));
                    }
                }

                if (material.equals(Material.RECORD_8)) {
                    if (playerStats.getType().equals("none")) {
                        ItemManager.clearJobItems(player);
                        ItemManager.giveSpecialBook(player);
                        BlacksmithJob.applyJob(player);
                        JobChanceManager.editJobCount(playerStats.getType(),true);
                        JobChanceManager.clearMaxJobs();
                    } else {
                        player.sendMessage(ColorUtils.translateColor("&cYou already have a class!"));
                    }
                }

                if (material.equals(Material.RECORD_4)) {
                    if (playerStats.getType().equals("none")) {
                        ItemManager.clearJobItems(player);
                        ItemManager.giveSpecialBook(player);
                        BakerJob.applyJob(player);
                        JobChanceManager.editJobCount(playerStats.getType(),true);
                        JobChanceManager.clearMaxJobs();
                    } else {
                        player.sendMessage(ColorUtils.translateColor("&cYou already have a class!"));
                    }
                }

                if (material.equals(Material.RECORD_6)) {
                    if (playerStats.getType().equals("none")) {
                        ItemManager.clearJobItems(player);
                        ItemManager.giveSpecialBook(player);
                        AlchemistJob.applyJob(player);
                        JobChanceManager.editJobCount(playerStats.getType(),true);
                        JobChanceManager.clearMaxJobs();
                    } else {
                        player.sendMessage(ColorUtils.translateColor("&cYou already have a class!"));
                    }
                }

                if (material.equals(Material.BOOK)) {
                    if (playerStats.getType().equals("builder")) {
                        if (player.getLevel() >= 25) {
                            player.setLevel(player.getLevel() - 25);
                            BuilderJob.refillItems(player);
                        } else {
                            player.sendMessage(ColorUtils.translateColor("&4Not enough xp (Cost 25)"));
                        }
                    } else if (playerStats.getType().equals("blacksmith")) {
                        if (player.getLevel() >= 30) {
                            player.setLevel(player.getLevel() - 30);
                            BlacksmithJob.refillItems(player);
                        } else {
                            player.sendMessage(ColorUtils.translateColor("&4Not enough xp (Cost 30)"));
                        }
                    } else if (playerStats.getType().equals("baker")) {
                        if (player.getLevel() >= 25) {
                            player.setLevel(player.getLevel() - 25);
                            BakerJob.refillItems(player);
                        } else {
                            player.sendMessage(ColorUtils.translateColor("&4Not enough xp (Cost 25)"));
                        }
                    } else if (playerStats.getType().equals("alchemist")) {
                        if (player.getLevel() >= 20) {
                            player.setLevel(player.getLevel() - 20);
                            AlchemistJob.refillItems(player);
                        } else {
                            player.sendMessage(ColorUtils.translateColor("&4Not enough xp (Cost 20)"));
                        }
                    }
                }

                if (material.equals(Material.IRON_INGOT)) {
                    if (ItemManager.getAmountOfItem(player,Material.IRON_INGOT) >= 20) {
                        if (player.getInventory().getHelmet() == null) {
                            player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                        }
                        if (player.getInventory().getChestplate() == null) {
                            player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                        }
                        if (player.getInventory().getLeggings() == null) {
                            player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                        }
                        if (player.getInventory().getBoots() == null) {
                            player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                        }
                        ItemManager.removeCertainAmount(player,Material.IRON_INGOT,20);
                    } else {
                        if (player.getInventory().getHelmet() == null) {
                            player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
                        }
                        if (player.getInventory().getChestplate() == null) {
                            player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                        }
                        if (player.getInventory().getLeggings() == null) {
                            player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                        }
                        if (player.getInventory().getBoots() == null) {
                            player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
                        }
                        ItemManager.removeCertainAmount(player,Material.IRON_INGOT,1);
                    }
                }

                if (material.equals(Material.FIREWORK_CHARGE)) {
                    if (ItemManager.getAmountOfItem(player,Material.FIREWORK_CHARGE) >= 7) {
                        player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                        ItemManager.removeCertainAmount(player,Material.FIREWORK_CHARGE,7);
                    } else {
                        player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
                        ItemManager.removeCertainAmount(player,Material.FIREWORK_CHARGE,1);
                    }
                }

                if (material.equals(Material.EMERALD)) {
                    //if (playerStats.isMonster()) {
                        int role = (int) (Math.random() * (100 - 1)) + 1;

                        ItemManager.giveZombieItem(player);

                        ItemManager.giveSkeletonItem(player);

                        if (role >= 25) {
                            ItemManager.giveCreeperItem(player);
                        }

                        if (role >= 50) {
                            ItemManager.giveCaveSpiderItem(player);
                        }

                        if (role >= 75) {
                            ItemManager.giveBlazeItem(player);
                        }

                        if (role >= 85) {
                            ItemManager.giveSquidItem(player);
                        }

                        if (role >= 95) {
                            ItemManager.givePigmanItem(player);
                        }

                        if (role >= 99) {
                            ItemManager.giveCorruptedSurvivorItem(player);
                        }

                        ItemManager.removeCertainAmount(player,Material.EMERALD,1);

                    //} else {
                    //    player.sendMessage(ColorUtils.translateColor("&cYou are not a monster!...don't think that low of yourself"));
                    //}
                }

                if (material.equals(Material.ROTTEN_FLESH)) {

                    player.getInventory().clear();

                    Zombie.setMonster(player);

                    event.setCancelled(true);

                    MonsterManager.TpMonster(player);

                }

                if (material.equals(Material.BONE)) {

                    player.getInventory().clear();

                    Skeleton.setMonster(player);

                    event.setCancelled(true);

                    MonsterManager.TpMonster(player);

                }

                if (material.equals(Material.TNT)) {

                    player.getInventory().clear();

                    Creeper.setMonster(player);

                    event.setCancelled(true);

                    MonsterManager.TpMonster(player);

                }

                if (material.equals(Material.SULPHUR) && playerStats.isMonster()) {

                    player.getLocation().getWorld().createExplosion(player.getLocation(),5,true);

                    player.setHealth(0);

                }

                if (material.equals(Material.SPIDER_EYE)) {

                    player.getInventory().clear();

                    CaveSpider.setMonster(player);

                    event.setCancelled(true);

                    MonsterManager.TpMonster(player);

                }

                if (material.equals(Material.BLAZE_POWDER)) {

                    player.getInventory().clear();

                    Blaze.setMonster(player);

                    event.setCancelled(true);

                    MonsterManager.TpMonster(player);

                }

                if (material.equals(Material.FLINT_AND_STEEL)) {

                    player.getInventory().clear();

                    Squid.setMonster(player);

                    event.setCancelled(true);

                    MonsterManager.TpMonster(player);

                }

                if (material.equals(Material.PORK)) {

                    player.getInventory().clear();

                    Pigman.setMonster(player);

                    event.setCancelled(true);

                    MonsterManager.TpMonster(player);

                }

                if (material.equals(Material.NETHER_STAR)) {

                    player.getInventory().clear();

                    CorruptedSurvivor.setMonster(player);

                    event.setCancelled(true);

                    MonsterManager.TpMonster(player);

                }



            }
        }
    }
}
