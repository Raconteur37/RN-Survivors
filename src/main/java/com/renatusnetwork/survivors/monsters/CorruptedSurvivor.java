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

public class CorruptedSurvivor {

    public static void setMonster(Player player) {

        PlayerStats playerStats = PlayerManager.getPlayerStats(player);

        playerStats.setMonsterType("corrupted");

        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        helm.getItemMeta().spigot().setUnbreakable(true);

        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        chest.getItemMeta().spigot().setUnbreakable(true);

        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        legs.getItemMeta().spigot().setUnbreakable(true);

        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        boots.getItemMeta().spigot().setUnbreakable(true);


        player.getInventory().setHelmet(helm);
        player.getInventory().setChestplate(chest);
        player.getInventory().setLeggings(legs);
        player.getInventory().setBoots(boots);

        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        sword.getItemMeta().spigot().setUnbreakable(true);

        player.getInventory().addItem(sword);

        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,99999,0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,99999,0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,99999,0));



    }


}
