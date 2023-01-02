package com.renatusnetwork.survivors.jobs;

import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AlchemistJob {

    public static void applyJob(Player player) {

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.setType("alchemist");

        player.getInventory().addItem(new ItemStack(Material.QUARTZ_BLOCK,64));

        player.getInventory().addItem(new ItemStack(Material.SEA_LANTERN,12));

        player.getInventory().addItem(new ItemStack(Material.BREWING_STAND_ITEM,2));

        player.getInventory().addItem(new ItemStack(Material.CHEST,2));

        player.getInventory().addItem(new ItemStack(Material.GLASS_BOTTLE,6));

        player.getInventory().addItem(new ItemStack(Material.SIGN,1));

        player.getInventory().addItem(new ItemStack(BlacksmithJob.getBlacksmithPick(player)));

        ItemStack egg = new ItemStack(Material.MONSTER_EGG,32);
        egg.setDurability((short) 55);

        player.getInventory().addItem(egg);

        player.getInventory().addItem(getAlchemistSword(player));

        player.getInventory().addItem(new ItemStack(Material.WORKBENCH,1));

    }

    public static void refillItems(Player player) {

        ItemStack egg = new ItemStack(Material.MONSTER_EGG,32);
        egg.setDurability((short) 55);

        player.getInventory().addItem(egg);

    }

    public static ItemStack getAlchemistWater() {
        ItemStack item = new ItemStack(Material.POTION);
        item.setDurability((short) 16);
        ItemMeta itemMeta = item.getItemMeta();
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getAlchemistPowder() {
        ItemStack item = new ItemStack(Material.SULPHUR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&7&lSulphur"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&fUse this to make potions"));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getAlchemistSword(Player player) {
        ItemStack blacksmithPick = new ItemStack(Material.STONE_SWORD);
        ItemMeta pickMeta = blacksmithPick.getItemMeta();
        pickMeta.setDisplayName(ColorUtils.translateColor("&8&lSword"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&7You can kill stuff..."));
        pickMeta.setLore(lore);
        pickMeta.spigot().setUnbreakable(true);
        blacksmithPick.setItemMeta(pickMeta);
        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(blacksmithPick);
        return blacksmithPick;
    }




}
