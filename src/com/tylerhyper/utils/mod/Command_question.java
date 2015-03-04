package com.tylerhyper.utils.mod;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_question implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
    if (TFM_ConfigEntry.TRAINING_SESSION.getBoolean().booleanValue())
     {
        sender.sendMessage(ChatColor.GREEN + "You've requested to talk during a meeting. We will give u access shortly.");

            for(Player player : Bukkit.getOnlinePlayers())
                {
            if (TFM_Util.isHighRank(player))
            {
                Player sender_p = Bukkit.getPlayer(sender.getName());
                player.sendMessage("§e[§bAdminChat§e] §4CONSOLE §5[Console]§f: " + ChatColor.YELLOW + sender_p.getName() + " has requested to talk.");
            }
        }
     }
    else {
        Player sender_p = Bukkit.getPlayer(sender.getName());
        sender_p.sendMessage(ChatColor.RED + "The question command is not available unless a quiz is active!");
    }
        return true;
    }
}