package com.renatusnetwork.survivors.jobs;

import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BuilderJob {

    public static void applyJob(Player player) {

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.setType("builder");

        ItemStack pick = getBuilderPick(player);
        player.getInventory().addItem(pick);

        ItemStack sword = getBuilderSword(player);
        player.getInventory().addItem(sword);

        ItemStack helm = getBuilderHelmet();
        player.getInventory().setHelmet(helm);

        ItemStack bread = new ItemStack(Material.BREAD,5);
        player.getInventory().addItem(bread);

        player.getInventory().addItem(new ItemStack(Material.TORCH,32));


        refillItems(player);


    }

    public static void refillItems(Player player) {

        ItemStack smoothBricks = new ItemStack(Material.SMOOTH_BRICK,64);
        player.getInventory().addItem(smoothBricks);

        ItemStack mossyCobblestone = new ItemStack(Material.MOSSY_COBBLESTONE,64);
        player.getInventory().addItem(mossyCobblestone);

        ItemStack bread = new ItemStack(Material.BREAD,2);
        player.getInventory().addItem(bread);

        player.getInventory().addItem(new ItemStack(Material.TORCH,16));


    }

    public static ItemStack getBuilderHelmet() {
        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        return helmet;
    }

    public static ItemStack getBuilderPick(Player player) {
        ItemStack builderPick = new ItemStack(Material.GOLD_PICKAXE);
        ItemMeta pickMeta = builderPick.getItemMeta();
        pickMeta.setDisplayName(ColorUtils.translateColor("&e&lTrusty Pickaxe"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&aA sturdy and efficient pickaxe"));
        pickMeta.setLore(lore);
        pickMeta.spigot().setUnbreakable(true);
        builderPick.setItemMeta(pickMeta);
        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(builderPick);
        return builderPick;
    }

    public static ItemStack getBuilderSword(Player player) {
        ItemStack item = new ItemStack(Material.STONE_SWORD);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&7&lHelpful Sword"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&8Eh it gets the job done"));
        itemMeta.setLore(lore);
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(item);
        return item;
    }








}
