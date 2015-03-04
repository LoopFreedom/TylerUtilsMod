package com.tylerhyper.utils.mod;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_requestop implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        sender.sendMessage(ChatColor.GREEN + "You've just sent your request for op! An admin will op you soon.");

            for(Player player : Bukkit.getOnlinePlayers())
                {
            if (TFM_AdminList.isSuperAdmin(player))
            {
                Player sender_p = Bukkit.getPlayer(sender.getName());
                player.sendMessage("§e[§bAdminChat§e] §4CONSOLE §5[Console]§f: " + ChatColor.YELLOW + sender_p.getName() + " needs to opped ");
            }
        }

        return true;
    }
}