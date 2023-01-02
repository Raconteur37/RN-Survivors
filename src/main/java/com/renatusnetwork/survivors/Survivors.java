package com.renatusnetwork.survivors;

import com.renatusnetwork.survivors.commands.*;
import com.renatusnetwork.survivors.jobs.AlchemistJob;
import com.renatusnetwork.survivors.jobs.BakerJob;
import com.renatusnetwork.survivors.listeners.*;
import com.renatusnetwork.survivors.managers.GameManager;
import net.minecraft.server.v1_8_R3.Item;
import net.minecraft.server.v1_8_R3.ShapedRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Survivors extends JavaPlugin {

    private static Survivors plugin;
    private static Logger logger;

    public static Plugin getPlugin() { return plugin; }

    @Override
    public void onEnable() {

        plugin = this;
        logger = getLogger();

        setupCommands();
        registerListeners();

        runRecipes();

    }

    @Override
    public void onDisable() {

        plugin = null; // avoid memory leaks

    }

    private void setupCommands() {

        getCommand("start").setExecutor(new StartCMD());
        getCommand("giveitems").setExecutor(new GiveItemsCMD());
        getCommand("stoptimers").setExecutor(new StopTimersCMD());
        getCommand("startwave").setExecutor(new SendWaveCMD());
        getCommand("stopwave").setExecutor(new StopWaveCMD());
        getCommand("setmonsterspawn").setExecutor(new SetMonsterSpawnCMD());


    }

    private void registerListeners() {

        getServer().getPluginManager().registerEvents(new JoinLeaveHandler(), this);
        getServer().getPluginManager().registerEvents(new ItemUseHandler(), this);
        getServer().getPluginManager().registerEvents(new BlacksmithListener(),this);
        getServer().getPluginManager().registerEvents(new BakerListener(),this);
        getServer().getPluginManager().registerEvents(new BuilderListener(),this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(),this);
        getServer().getPluginManager().registerEvents(new DropListener(),this);
        getServer().getPluginManager().registerEvents(new DamageListener(),this);
        getServer().getPluginManager().registerEvents(new DeathListener(),this);
        getServer().getPluginManager().registerEvents(new PickupListener(),this);

    }

    private void runRecipes() {

        // Baker Sugar Crafting
        ItemStack bakerSugar = BakerJob.getBackerSugar();
        ShapedRecipe sugarRecipe = new ShapedRecipe(bakerSugar);
        sugarRecipe.shape("***","***","***");
        sugarRecipe.setIngredient('*', Material.SEEDS);
        getServer().addRecipe(sugarRecipe);

        // Baker Pumpkin Pie Crafting
        ShapedRecipe pieRecipe = new ShapedRecipe(new ItemStack(Material.PUMPKIN_PIE,5));
        pieRecipe.shape("   ","*$*","   ");
        pieRecipe.setIngredient('$', Material.SUGAR);
        pieRecipe.setIngredient('*',Material.NETHERRACK);
        getServer().addRecipe(pieRecipe);

        // Baker Golden Apple Crafting
        ShapedRecipe goldenAppleRecipe = new ShapedRecipe(new ItemStack(Material.GOLDEN_APPLE,2));
        goldenAppleRecipe.shape("***","*$*","***");
        goldenAppleRecipe.setIngredient('$', Material.SUGAR);
        goldenAppleRecipe.setIngredient('*',Material.GLOWSTONE);
        getServer().addRecipe(goldenAppleRecipe);

        // Baker Cake Crafting
        ShapedRecipe cakeRecipe = new ShapedRecipe(new ItemStack(Material.CAKE,1));
        cakeRecipe.shape("   ","*$*","   ");
        cakeRecipe.setIngredient('$', Material.SUGAR);
        cakeRecipe.setIngredient('*',Material.WHEAT);
        getServer().addRecipe(cakeRecipe);


        // Alchemist Potion Recipe
        ItemStack awkwardPotion = AlchemistJob.getAlchemistWater();
        ShapedRecipe wartRecipe = new ShapedRecipe(awkwardPotion);
        wartRecipe.shape("* *","* *","***");
        wartRecipe.setIngredient('*',Material.SLIME_BALL);
        getServer().addRecipe(wartRecipe);

        // Alchemist Sulphur Recipe
        ItemStack sulphur = AlchemistJob.getAlchemistPowder();
        ShapedRecipe sulphurRecipe = new ShapedRecipe(sulphur);
        sulphurRecipe.shape("***"," * ","***");
        sulphurRecipe.setIngredient('*',Material.SLIME_BALL);
        getServer().addRecipe(sulphurRecipe);

        // Alchemist Blaze Powder Recipe
        ShapedRecipe blazeRecipe = new ShapedRecipe(new ItemStack(Material.BLAZE_POWDER,1));
        blazeRecipe.shape("***","* *","***");
        blazeRecipe.setIngredient('*',Material.SLIME_BALL);
        getServer().addRecipe(blazeRecipe);

        // Alchemist Melon Recipe
        ShapedRecipe melonRecipe = new ShapedRecipe(new ItemStack(Material.SPECKLED_MELON,1));
        melonRecipe.shape("*  ","** ","***");
        melonRecipe.setIngredient('*',Material.SLIME_BALL);
        getServer().addRecipe(melonRecipe);

        // Alchemist Tear Recipe
        ShapedRecipe tearRecipe = new ShapedRecipe(new ItemStack(Material.GHAST_TEAR,1));
        tearRecipe.shape(" * "," * "," * ");
        tearRecipe.setIngredient('*',Material.SLIME_BALL);
        getServer().addRecipe(tearRecipe);


        // Baker Spice Smelting
        //getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.PUMPKIN_PIE,5),bakerSpice.getType()));
    }





}
