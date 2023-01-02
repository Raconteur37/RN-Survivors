package com.renatusnetwork.survivors.monsters;

import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Creeper {

    public static void setMonster(Player player) {

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);

        playerStats.setMonsterType("creeper");

        ItemStack leatherHelm = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta helmMetaLeather = (LeatherArmorMeta) leatherHelm.getItemMeta();
        helmMetaLeather.setColor(Color.LIME);
        leatherHelm.setItemMeta(helmMetaLeather);
        ItemMeta helmMeta = leatherHelm.getItemMeta();
        helmMeta.spigot().setUnbreakable(true);
        helmMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE,2,false);
        leatherHelm.setItemMeta(helmMeta);

        ItemStack leatherChest = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestMetaLeather = (LeatherArmorMeta) leatherChest.getItemMeta();
        chestMetaLeather.setColor(Color.LIME);
        leatherChest.setItemMeta(chestMetaLeather);
        ItemMeta chestMeta = leatherChest.getItemMeta();
        chestMeta.spigot().setUnbreakable(true);
        chestMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE,2,false);
        leatherChest.setItemMeta(chestMeta);

        ItemStack leatherLegs = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta legMetaLeather = (LeatherArmorMeta) leatherLegs.getItemMeta();
        legMetaLeather.setColor(Color.LIME);
        leatherLegs.setItemMeta(legMetaLeather);
        ItemMeta legMeta = leatherLegs.getItemMeta();
        legMeta.spigot().setUnbreakable(true);
        legMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE,2,false);
        leatherLegs.setItemMeta(legMeta);

        ItemStack leatherBoots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootMetaLeather = (LeatherArmorMeta) leatherBoots.getItemMeta();
        bootMetaLeather.setColor(Color.LIME);
        leatherBoots.setItemMeta(bootMetaLeather);
        ItemMeta bootMeta = leatherBoots.getItemMeta();
        bootMeta.spigot().setUnbreakable(true);
        bootMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE,2,false);
        leatherBoots.setItemMeta(bootMeta);


        player.getInventory().setHelmet(leatherHelm);
        player.getInventory().setChestplate(leatherChest);
        player.getInventory().setLeggings(leatherLegs);
        player.getInventory().setBoots(leatherBoots);

        player.getInventory().addItem(giveExplosionItem());

        player.getInventory().addItem(new ItemStack(Material.TNT,16));

        player.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL));

        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,99999,1));



    }

    public static ItemStack giveExplosionItem() {

        ItemStack item = new ItemStack(Material.SULPHUR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ColorUtils.translateColor("&c&lExplode"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translateColor("&aRight click to explode and die"));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;

    }

}
