package com.renatusnetwork.survivors.listeners;

import com.renatusnetwork.survivors.managers.PlayerManager;
import com.renatusnetwork.survivors.objects.PlayerStats;
import com.renatusnetwork.survivors.utils.ColorUtils;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageListener implements Listener {

    @EventHandler
    public static void onDmg(EntityDamageByEntityEvent event) {

        if (event.getDamager() instanceof Player) {

            PlayerStats playerStatsAttacker = PlayerManager.getPlayerStats((Player) event.getDamager());

            if (event.getEntity() instanceof Player) {

                PlayerStats playerStatsVictim = PlayerManager.getPlayerStats((Player) event.getEntity());

                Player victim  = (Player) event.getEntity();

                if (!playerStatsAttacker.isMonster() && !playerStatsVictim.isMonster()) {

                    event.setCancelled(true);

                    playerStatsAttacker.getPlayer().sendMessage(ColorUtils.translateColor("&cDon't attack your fellow survivors!"));

                }

                if (playerStatsAttacker.isMonster() && playerStatsVictim.isMonster()) {

                    event.setCancelled(true);

                    playerStatsAttacker.getPlayer().sendMessage(ColorUtils.translateColor("&cDon't attack your fellow monsters!"));

                }

                if (event.getDamager() instanceof Arrow) {
                    if (((Arrow) event.getDamager()).getShooter() instanceof Player) {

                        Player shooter = (Player) ((Arrow) event.getDamager()).getShooter();

                        PlayerStats shooterStats = PlayerManager.getPlayerStats(shooter);

                        if ((!shooterStats.isMonster() && !playerStatsVictim.isMonster())) {

                            event.setCancelled(true);

                            playerStatsAttacker.getPlayer().sendMessage(ColorUtils.translateColor("&cDon't attack your fellow survivors!"));

                        }

                        if ((shooterStats.isMonster() && playerStatsVictim.isMonster())) {

                            event.setCancelled(true);

                            playerStatsAttacker.getPlayer().sendMessage(ColorUtils.translateColor("&cDon't attack your fellow monsters!"));

                        }

                    }

                }


                if (playerStatsAttacker.getMonsterType().equals("cavespider")) {

                    int role = (int) (Math.random() * (100 - 1)) + 1;

                    if (role <= 25) {
                        victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON,5,2));
                        playerStatsAttacker.getPlayer().sendMessage(ColorUtils.translateColor("&2You poisoned the enemy"));
                    }


                }

                if (playerStatsAttacker.getMonsterType().equals("squid")) {

                    int role = (int) (Math.random() * (100 - 1)) + 1;

                    if (role <= 25) {
                        victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,3,2));
                        victim.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,8,4));
                        playerStatsAttacker.getPlayer().sendMessage(ColorUtils.translateColor("&2You inked the enemy"));
                    }



                }



            }
        }



    }
}
