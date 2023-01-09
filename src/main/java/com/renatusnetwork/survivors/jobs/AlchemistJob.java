package com.renatusnetwork.survivors.jobs;

import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class AlchemistJob {

    public static void applyJob(Player player) {

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.setType("alchemist");

        player.getInventory().addItem(new ItemStack(Material.QUARTZ_BLOCK,64));

        player.getInventory().addItem(new ItemStack(Material.SEA_LANTERN,12));

        player.getInventory().addItem(new ItemStack(Material.BREWING_STAND_ITEM,2));

        player.getInventory().addItem(new ItemStack(Material.CHEST,2));

        player.getInventory().addItem(getInfoBook(player));

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

    public static ItemStack getInfoBook(Player player) {
        ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
        bookMeta.setTitle("Alchemist Guide");
        bookMeta.setAuthor("Renatus");

        List<String> pages = new ArrayList<String>();
        pages.add("--==Alchemist...      " +
                "As an alchemist you need to create potions for your team and make sure your team can protect themselves"); // Page 1
        pages.add("--==Instructions...    " +
                "Place down your slimes then kill them to get slimeballs, then use slimeballs to craft potion items and make potions!"); // Page 2
        pages.add("--==Recipes==--         "); // Page 3
        pages.add("--==Awkward Potion==--      " +
                "   Make a U shape in the crafting table with slimeballs ");
        pages.add("--==Sulphur==--      " +
                "   Make an hourglass shape with slimeballs in the crafting table ");
        pages.add("--==Blaze Powder==--      " +
                "   Make a O in the crafting table with the slimeballs ");
        pages.add("--==Glistening Melon==--      " +
                "   Make a stair shape facing left with slimeballs in the crafting table ");
        pages.add("--==Ghast Tear==--      " +
                "   Make a | straight in the middle of the crafting table with slimeballs ");


        bookMeta.setPages(pages);

        writtenBook.setItemMeta(bookMeta);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(writtenBook);


        return writtenBook;
    }




}
