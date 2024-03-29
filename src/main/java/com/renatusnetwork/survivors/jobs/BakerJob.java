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

public class BakerJob {

    public static void applyJob(Player player) {

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.setType("baker");

        ItemStack pick = getBackerPick(player);
        player.getInventory().addItem(pick);

        player.getInventory().addItem(new ItemStack(Material.BRICK,128));

        player.getInventory().addItem(new ItemStack(Material.GLASS,32));

        player.getInventory().addItem(new ItemStack(Material.GRASS,9));

        player.getInventory().addItem(getInfoBook(player));

        player.getInventory().addItem(new ItemStack(Material.CHEST,2));

        player.getInventory().addItem(new ItemStack(Material.WORKBENCH,1));

        player.getInventory().addItem(new ItemStack(Material.FLOWER_POT_ITEM,1));

        player.getInventory().addItem(new ItemStack(Material.TORCH,6));

        ItemStack BONE_MEAL = new ItemStack(Material.INK_SACK,32);
        BONE_MEAL.setDurability((short) 15);

        player.getInventory().addItem(BONE_MEAL);

        player.getInventory().addItem(new ItemStack(Material.SIGN,1));

    }

    public static void refillItems(Player player) {

        ItemStack BONE_MEAL = new ItemStack(Material.INK_SACK,32);
        BONE_MEAL.setDurability((short) 15);

        player.getInventory().addItem(BONE_MEAL);

    }


    public static ItemStack getBackerPick(Player player) {
        ItemStack blacksmithPick = new ItemStack(Material.STONE_PICKAXE);
        ItemMeta pickMeta = blacksmithPick.getItemMeta();
        pickMeta.setDisplayName(ColorUtils.translateColor("&8&lPickaxe"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&7You could use it to kneed dough"));
        pickMeta.setLore(lore);
        pickMeta.spigot().setUnbreakable(true);
        blacksmithPick.setItemMeta(pickMeta);
        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(blacksmithPick);
        return blacksmithPick;
    }

    public static ItemStack getBackerSugar() {
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&lBaker's Sugar"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&fRight click a pot to make an ingredient"));
        lore.add(ColorUtils.translateColor("&for surround it with an ingredient to make &afood"));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getBackerSpice() {
        ItemStack item = new ItemStack(Material.NETHERRACK);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&c&lBaker's Spice"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&aAdd some spice to that thaaaang"));
        lore.add(ColorUtils.translateColor("&fPut this to the left and right of sugar to make &6Pumpkin Pie"));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getBakerSweetener() {
        ItemStack item = new ItemStack(Material.GLOWSTONE);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&e&lBaker's Sweetener"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&aIt's sweet...never sour"));
        lore.add(ColorUtils.translateColor("&fSurround sugar in this to make a &eGolden Apple"));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getBakerTang() {
        ItemStack item = new ItemStack(Material.WHEAT);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&6&lWHEAT"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&aITS WHEAT OMG EVERYTHING A BAKER NEEDS"));
        lore.add(ColorUtils.translateColor("&fPut this to the left and right of sugar to make a &cCake"));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getInfoBook(Player player) {
        ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
        bookMeta.setTitle("Baker Guide");
        bookMeta.setAuthor("Renatus");

        List<String> pages = new ArrayList<String>();
        pages.add("--==Baker...      " +
                "As a baker, you need to make food and golden apples to keep your survivors bellies full!"); // Page 1
        pages.add("--==Instructions...    " +
                "Place down your grass then use bonemeal to get seeds from the grass. Use seeds to craft sugar and then infuse that sugar to get ingredients"); // Page 2
        pages.add("--==Recipes==--         "); // Page 3
        pages.add("--==Sugar==--      " +
                "   Fill all 9 spots in the crafting table with seeds ");
        pages.add("--==Ingredients==--      " +
                "   Right click sugar on your flower pot to get a random ingredient ");
        pages.add("--==Pie==--      " +
                "   In the middle of the crafting table, put sugar in the middle then to the left and right put the spice ");
        pages.add("--==Golden Apple==--      " +
                "   Put sugar in the middle of the crafting table then surround it with sweetener ");
        pages.add("--==Cake==--      " +
                "   In the middle of the crafting table, put sugar in the middle then to the left and right put wheat ");

        bookMeta.setPages(pages);

        writtenBook.setItemMeta(bookMeta);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(writtenBook);


        return writtenBook;
    }



}
