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

public class BlacksmithJob {

    public static void applyJob(Player player) {

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.setType("blacksmith");

        ItemStack pick = getBlacksmithPick(player);
        player.getInventory().addItem(pick);

        ItemStack netherBricks = new ItemStack(Material.NETHER_BRICK,128);
        player.getInventory().addItem(netherBricks);

        ItemStack ironBars = new ItemStack(Material.IRON_FENCE,24);
        player.getInventory().addItem(ironBars);

        ItemStack anvil = new ItemStack(Material.ANVIL,1);
        player.getInventory().addItem(anvil);

        player.getInventory().addItem(getInfoBook(player));

        ItemStack armorstand = new ItemStack(Material.ARMOR_STAND,2);
        player.getInventory().addItem(armorstand);

        ItemStack furnace = new ItemStack(Material.FURNACE,2);
        player.getInventory().addItem(furnace);

        ItemStack torch = new ItemStack(Material.TORCH,6);
        player.getInventory().addItem(torch);

        refillItems(player);

        ItemStack food = new ItemStack(Material.COOKED_BEEF,5);
        player.getInventory().addItem(food);



    }

    public static void refillItems(Player player) {

        ItemStack ore = new ItemStack(Material.COAL_ORE,16);
        player.getInventory().addItem(ore);

        int role = (int) (Math.random() * (100 - 1)) + 1;
        if (role <= 1) {
            player.getInventory().addItem(getBlacksmithCharm());
        }

    }

    public static ItemStack getBlacksmithPick(Player player) {
        ItemStack blacksmithPick = new ItemStack(Material.STONE_PICKAXE);
        ItemMeta pickMeta = blacksmithPick.getItemMeta();
        pickMeta.setDisplayName(ColorUtils.translateColor("&8&lPickaxe"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&7Kind of like a hammer"));
        pickMeta.setLore(lore);
        pickMeta.spigot().setUnbreakable(true);
        blacksmithPick.setItemMeta(pickMeta);
        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(blacksmithPick);
        return blacksmithPick;
    }

    public static ItemStack getSpecialClay() {
        ItemStack item = new ItemStack(Material.CLAY_BALL);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&7&lRaw Mineral"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&aHeat it up"));
        itemMeta.setLore(lore);
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getRefinedMineral() {
        ItemStack item = new ItemStack(Material.HOPPER,1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&7&lRefined Mineral"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&aClick on an &7anvil &ato forge armor token"));
        lore.add(ColorUtils.translateColor("&5Maybe a builder can do something with this?")); // Reinforce walls
        itemMeta.setLore(lore);
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        return item;
    }


    public static ItemStack getArmorToken() {
        ItemStack item = new ItemStack(Material.IRON_INGOT,1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&lArmor Token"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&aRight click to get &fIron Armor"));
        lore.add(ColorUtils.translateColor("&aIf you have &520 &aof these then you get &bDiamond Armor"));
        itemMeta.setLore(lore);
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getBlacksmithCharm() {
        ItemStack item = new ItemStack(Material.SULPHUR,1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&5&lBlacksmith Charm"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&aHave this as an &5alchemist &ato make resistance potions"));
        lore.add(ColorUtils.translateColor("&aHave this as an &4baker &ato make steak"));
        itemMeta.setLore(lore);
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getWeaponToken() {
        ItemStack item = new ItemStack(Material.FIREWORK_CHARGE,1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&lWeapon Token"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&aRight click to get an &fIron Sword"));
        lore.add(ColorUtils.translateColor("&aIf you have &57 &aof these then you get a &bDiamond Sword"));
        itemMeta.setLore(lore);
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getInfoBook(Player player) {
        ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
        bookMeta.setTitle("Blacksmith Guide");
        bookMeta.setAuthor("Renatus");

        List<String> pages = new ArrayList<String>();
        pages.add("--==Blacksmith...      " +
                "As a blacksmith you need to forge weapons and armor for your team!"); // Page 1
        pages.add("--==Instructions...    " +
                "Place down coal and mine with with your pickaxe, then you have a chance to gain raw mineral. Heat up raw mineral in the furnace to get refined minerals."); // Page 2
        pages.add("When you have refined minerals, you can give it to a builder or LEFT click an ANVIL to forge an armor token or a weapon token."); // Page 3
        pages.add("--==Recipes==--");
        pages.add("No crafting recipes");

        bookMeta.setPages(pages);

        writtenBook.setItemMeta(bookMeta);

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);
        playerStats.addEssentialItem(writtenBook);


        return writtenBook;
    }




}
