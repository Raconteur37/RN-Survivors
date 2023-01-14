package com.renatusnetwork.survivors.objects;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public class PlayerStats {

    private Player player;
    private UUID uuid;
    private String type = "none";
    private boolean isMonster = false;
    private String bakerCraftType;
    private String monsterType = "none";
    private int kills = 0;

    private ArrayList<ItemStack> essentialItemsList = new ArrayList<>();

    public PlayerStats(Player player) {
        this.player = player;
        uuid = player.getUniqueId();
    }

    public void addKill() {
        kills++;
    }

    public int getKills() {
        return kills;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getPlayer() {
        return player;
    }

    public String getType() {
        return type;
    }

    public boolean isEssentialItem(ItemStack item) {
        return essentialItemsList.contains(item);
    }

    public void addEssentialItem(ItemStack item) {
        essentialItemsList.add(item);
    }

    public void setBakerCraftType(String type) {
        bakerCraftType = type;
    }

    public String getBakerCraftType() {
        return bakerCraftType;
    }

    public void setMonster(boolean b) {
        isMonster = b;
    }

    public boolean isMonster() {
        return isMonster;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String type) {
        monsterType = type;
    }



}
