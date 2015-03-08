package com.tylerhyper.utils.mod;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_admininfo implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;

        if (split.length == 0) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "To apply for admin you need to go to the forums @ http://3p1cfreedomcraft.boards.net/");
            return true;
        }
        else {
            return false;
        }
    }
}
