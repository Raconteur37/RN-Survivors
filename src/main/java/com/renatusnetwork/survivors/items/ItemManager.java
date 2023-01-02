package com.renatusnetwork.survivors.items;

import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemManager {

    public static void clearJobItems(Player player) {

        if (player.getInventory().contains(Material.GOLD_NUGGET)) {
            player.getInventory().remove(Material.GOLD_NUGGET);
        }
        if (player.getInventory().contains(Material.RECORD_12)) {
            player.getInventory().remove(Material.RECORD_12);
        }
        if (player.getInventory().contains(Material.RECORD_8)) {
            player.getInventory().remove(Material.RECORD_8);
        }
        if (player.getInventory().contains(Material.RECORD_4)) {
            player.getInventory().remove(Material.RECORD_4);
        }
        if (player.getInventory().contains(Material.RECORD_6)) {
            player.getInventory().remove(Material.RECORD_6);
        }

    }

    public static void giveItemToken(Player player) {

        ItemStack itemStack = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&6&lItem Token"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&7Right click to get random jobs"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

    }


    public static void giveBuilderItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.RECORD_12);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&3&lBuilder"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&7Right click to become a Builder"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void giveBlacksmithItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.RECORD_8);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&7&lBlacksmith"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&7Right click to become a Blacksmith"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void giveBakerItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.RECORD_4);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&c&lBaker"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&7Right click to become a Baker"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void giveAlchemistItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.RECORD_6);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&5&lAlchemist"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&7Right click to become a Alchemist"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void giveSpecialBook(Player player) {

        ItemStack itemStack = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&e&lMaterial Book"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&aUse this books to gather more materials &4(Costs XP)"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void removeCertainAmount(Player player, Material material, int amount) {
        for(int i = 0; i < player.getInventory().getSize(); i++){
            ItemStack itm = player.getInventory().getItem(i);
            if(itm != null && itm.getType().equals(material) && itm.hasItemMeta()) {
                int amt = itm.getAmount() - amount;
                itm.setAmount(amt);
                player.getInventory().setItem(i, amt > 0 ? itm : null);
                player.updateInventory();
                break;
            }
        }
    }

    public static int getAmountOfItem(Player player, Material material) {
        int count = 0;
        PlayerInventory inv = player.getInventory();
        for (ItemStack is : inv.all(material).values()) {
            if (is != null && is.getType() == material) {
                count = count + is.getAmount();
            }
        }
        return count;
    }

    public static void giveMonsterToken(Player player) {

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);

        ItemStack itemStack = new ItemStack(Material.EMERALD);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&4&lMonster Token"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&7Right click to get random mob types"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);


    }

    public static void giveZombieItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.ROTTEN_FLESH);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&2&lZombie"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&lRight click to become a &2Zombie"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void giveSkeletonItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.BONE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&f&lSkeleton"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&lRight click to become a &fSkeleton"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void giveCreeperItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.TNT);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&a&lCreeper"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&lRight click to become a &aCreeper"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void giveCaveSpiderItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.SPIDER_EYE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&7&lCave Spider"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&lRight click to become a &7Cave Spider"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void giveBlazeItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&e&lBlaze"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&lRight click to become a &eBlaze"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void giveSquidItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.FLINT);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&7&lSquid"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&lRight click to become a &7Squid"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void givePigmanItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.PORK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&d&lPigman"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&lRight click to become a &dPigman"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }

    public static void giveCorruptedSurvivorItem(Player player) {

        ItemStack itemStack = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&6&lCorrupted Survivor"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&lRight click to become a &6Corrupted Survivor"));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(itemStack);

    }




}
