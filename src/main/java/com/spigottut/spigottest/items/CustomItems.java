package com.spigottut.spigottest.items;

import com.spigottut.spigottest.enchants.CustomEnchants;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CustomItems {

    public static ItemStack GodShear;

    public static void init() {
        createGodShear();
    }

    public static void createGodShear() {
        ItemStack item = new ItemStack(Material.SHEARS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Ass");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.YELLOW+"Plays random sound on Right Click");
        lore.add(ChatColor.YELLOW+"Summons lightning on Left Click.");
        lore.add(ChatColor.GRAY+"Said to be a weapon of the Ancient Ones");
        lore.add(ChatColor.GRAY+"used in the time of the Great Abyssal War,");
        lore.add(ChatColor.GRAY+"these God Shears strike fear into those");
        lore.add(ChatColor.GRAY+"who must face it in battle.");
        meta.setLore(lore);
        meta.addEnchant(CustomEnchants.GLOW, 1, true);
        item.setItemMeta(meta);
        GodShear = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("godshear_shaped"),GodShear);
        sr.shape("I "," I");
        sr.setIngredient('I',Material.DIRT);
        Bukkit.getServer().addRecipe(sr);
    }
}
