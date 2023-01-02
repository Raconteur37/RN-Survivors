package com.renatusnetwork.survivors.monsters;

import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Blaze {

    public static void setMonster(Player player) {

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);

        playerStats.setMonsterType("blaze");

        ItemStack leatherHelm = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta helmMetaLeather = (LeatherArmorMeta) leatherHelm.getItemMeta();
        helmMetaLeather.setColor(Color.YELLOW);
        leatherHelm.setItemMeta(helmMetaLeather);
        ItemMeta helmMeta = leatherHelm.getItemMeta();
        helmMeta.spigot().setUnbreakable(true);
        helmMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4,false);
        leatherHelm.setItemMeta(helmMeta);

        ItemStack leatherChest = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestMetaLeather = (LeatherArmorMeta) leatherChest.getItemMeta();
        chestMetaLeather.setColor(Color.YELLOW);
        leatherChest.setItemMeta(chestMetaLeather);
        ItemMeta chestMeta = leatherChest.getItemMeta();
        chestMeta.spigot().setUnbreakable(true);
        chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4,false);
        leatherChest.setItemMeta(chestMeta);

        ItemStack leatherLegs = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta legMetaLeather = (LeatherArmorMeta) leatherLegs.getItemMeta();
        legMetaLeather.setColor(Color.YELLOW);
        leatherLegs.setItemMeta(legMetaLeather);
        ItemMeta legMeta = leatherLegs.getItemMeta();
        legMeta.spigot().setUnbreakable(true);
        legMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4,false);
        leatherLegs.setItemMeta(legMeta);

        ItemStack leatherBoots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootMetaLeather = (LeatherArmorMeta) leatherBoots.getItemMeta();
        bootMetaLeather.setColor(Color.YELLOW);
        leatherBoots.setItemMeta(bootMetaLeather);
        ItemMeta bootMeta = leatherBoots.getItemMeta();
        bootMeta.spigot().setUnbreakable(true);
        bootMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4,false);
        leatherBoots.setItemMeta(bootMeta);


        player.getInventory().setHelmet(leatherHelm);
        player.getInventory().setChestplate(leatherChest);
        player.getInventory().setLeggings(leatherLegs);
        player.getInventory().setBoots(leatherBoots);

        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT,3);
        sword.getItemMeta().spigot().setUnbreakable(true);

        ItemStack bow = new ItemStack(Material.BOW);
        bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE,2);
        bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE,2);
        bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK,2);
        bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE,1);
        bow.getItemMeta().spigot().setUnbreakable(true);

        player.getInventory().addItem(sword);
        player.getInventory().addItem(bow);
        player.getInventory().addItem(new ItemStack(Material.ARROW));

        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,99999,1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,99999,0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,99999,1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,99999,0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,99999,1));

    }

}
