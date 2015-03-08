package com.tylerhyper.utils.mod;

import me.StevenLawson.TotalFreedomMod.TFM_Admin;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_clearall implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        TFM_Util.adminAction(sender.getName(), "Cleaning all supered IPs of all admins.", true);
            for(Player player : Bukkit.getOnlinePlayers())
                {
            final TFM_Admin admin = TFM_AdminList.getEntry(player);
            final String ip = TFM_Util.getIp(player);
                int counter = 0;
                for (int i = 0; i < admin.getIps().size(); i++)
                {
                    if (admin.getIps().get(i).equals(ip))
                    {
                        continue;
                    }
                    admin.removeIp(admin.getIps().get(i));
                    counter++;
                }

                TFM_AdminList.saveAll();
                player.sendMessage(counter + " IPs removed.");
                player.sendMessage(admin.getIps().get(0) + " is now your only IP address");
                return true;
            }
    return true;
}
}