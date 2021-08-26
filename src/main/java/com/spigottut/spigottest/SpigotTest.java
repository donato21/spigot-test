package com.spigottut.spigottest;

import com.spigottut.spigottest.commands.CustomCommands;
import com.spigottut.spigottest.enchants.CustomEnchants;
import com.spigottut.spigottest.events.CustomEvents;
import com.spigottut.spigottest.items.CustomItems;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotTest extends JavaPlugin implements Listener {
    /**
     * Create a plugin that adds custom recipe for an enchanted shear, with a custom name and some lore explaining what it does.
     * When you're holding the shears:
     *  - Right clicking with it should play a random sound
     *  - Left clicking should summon a lightning bolt
     */

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("My first plugin has started!");
        getServer().getPluginManager().registerEvents(this, this);
        CustomEnchants.register();
        CustomItems.init();
        getServer().getPluginManager().registerEvents(new CustomEvents(), this);
        getCommand("dumptruck").setExecutor(new CustomCommands());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.AQUA + "Hey fucker! Glad you could make it " +
                ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.AQUA + "!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("My first plugin has stopped!");
    }
}
