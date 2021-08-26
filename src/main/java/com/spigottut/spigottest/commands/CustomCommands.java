package com.spigottut.spigottest.commands;

import com.spigottut.spigottest.items.CustomItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CustomCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            //Dumptruck
            if (command.getName().equalsIgnoreCase("dumptruck")) {
                player.getInventory().addItem(CustomItems.GodShear);
            }
        }
        return false;
    }
}
