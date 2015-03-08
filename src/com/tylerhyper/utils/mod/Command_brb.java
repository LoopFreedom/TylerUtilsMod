package com.tylerhyper.utils.mod;

import static com.tylerhyper.utils.mod.TylerUtilsMod.server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;


public class Command_brb implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        
      if (args.length == 1)
        {
        if (args[0].equals("on"))
        {
        TFM_Util.adminAction(ChatColor.RED + sender.getName(), "I'll be right back.", false);
        server.dispatchCommand(sender, "afk");
        return true;
        }
        else if (args[0].equals("off"))
        {
            TFM_Util.adminAction(ChatColor.AQUA + sender.getName(), "I'm back now.", false);
            return true;
        }
    }
   return true;
}
    
}
