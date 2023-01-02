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

public class Pigman {

    public static void setMonster(Player player) {

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);

        playerStats.setMonsterType("zombie");

        ItemStack leatherHelm = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta helmMetaLeather = (LeatherArmorMeta) leatherHelm.getItemMeta();
        helmMetaLeather.setColor(Color.FUCHSIA);
        leatherHelm.setItemMeta(helmMetaLeather);
        ItemMeta helmMeta = leatherHelm.getItemMeta();
        helmMeta.spigot().setUnbreakable(true);
        helmMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3,false);
        leatherHelm.setItemMeta(helmMeta);

        ItemStack leatherChest = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestMetaLeather = (LeatherArmorMeta) leatherChest.getItemMeta();
        chestMetaLeather.setColor(Color.FUCHSIA);
        leatherChest.setItemMeta(chestMetaLeather);
        ItemMeta chestMeta = leatherChest.getItemMeta();
        chestMeta.spigot().setUnbreakable(true);
        chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3,false);
        leatherChest.setItemMeta(chestMeta);

        ItemStack leatherLegs = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta legMetaLeather = (LeatherArmorMeta) leatherLegs.getItemMeta();
        legMetaLeather.setColor(Color.FUCHSIA);
        leatherLegs.setItemMeta(legMetaLeather);
        ItemMeta legMeta = leatherLegs.getItemMeta();
        legMeta.spigot().setUnbreakable(true);
        legMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3,false);
        leatherLegs.setItemMeta(legMeta);

        ItemStack leatherBoots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootMetaLeather = (LeatherArmorMeta) leatherBoots.getItemMeta();
        bootMetaLeather.setColor(Color.FUCHSIA);
        leatherBoots.setItemMeta(bootMetaLeather);
        ItemMeta bootMeta = leatherBoots.getItemMeta();
        bootMeta.spigot().setUnbreakable(true);
        bootMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3,false);
        leatherBoots.setItemMeta(bootMeta);


        player.getInventory().setHelmet(leatherHelm);
        player.getInventory().setChestplate(leatherChest);
        player.getInventory().setLeggings(leatherLegs);
        player.getInventory().setBoots(leatherBoots);

        ItemStack sword = new ItemStack(Material.GOLD_SWORD);
        sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,2);
        sword.getItemMeta().spigot().setUnbreakable(true);

        player.getInventory().addItem(sword);

        ItemStack egg = new ItemStack(Material.MONSTER_EGG,64);
        egg.setDurability((short) 57);

        player.getInventory().addItem(egg);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,99999,0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,99999,2));

    }

}
