package com.spigottut.spigottest.events;

import com.spigottut.spigottest.items.CustomItems;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CustomEvents implements Listener {

    @EventHandler
    public static void onLeftClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(CustomItems.GodShear.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.getWorld().strikeLightning(player.getLocation());
                    player.sendMessage(ChatColor.GOLD+"You have been smited!");
                }
            }
        }
    }

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(CustomItems.GodShear.getItemMeta())) {
                    Player player = event.getPlayer();
                    //TODO: Sounds
                    List sounds = Arrays.stream(Sound.values()).collect(Collectors.toList());
                    Sound sound = (Sound) sounds.get(new Random().nextInt(sounds.size()));
                    player.playSound(player.getLocation(), sound, 1,1);
                }
            }
        }
    }
}
