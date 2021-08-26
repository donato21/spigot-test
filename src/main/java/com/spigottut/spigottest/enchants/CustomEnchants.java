package com.spigottut.spigottest.enchants;

import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CustomEnchants {

    public static final Enchantment GLOW = new EnchantWrapper("glow", "", 1);

    public static void register() {
        // Current enchants to array, checks for glow
        boolean registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(GLOW);
        if (!registered) registerEnchant(GLOW);
    }

    public static void registerEnchant(Enchantment enchant) {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchant);
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}