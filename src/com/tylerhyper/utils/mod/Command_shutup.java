package com.tylerhyper.utils.mod;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import static org.bukkit.Bukkit.getPlayer;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_shutup implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
          if (TFM_AdminList.isSuperAdmin(sender)) {
		  if (args.length == 0)
	        {
	            return false;
	        }

	        final Player player = getPlayer(args[0]);

	        if (player == null)
	        {
	            player.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
	            return true;
	        }
	        player.sendMessage(ChatColor.RED + "Now shut the fuck up will ya?");
	        player.setHealth(0);
	        final Location targetPos = player.getLocation();
	        for (int x = -1; x <= 1; x++)
	        {
	            for (int z = -1; z <= 1; z++)
	            {
	                final Location strike_pos = new Location(targetPos.getWorld(), targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
	                targetPos.getWorld().strikeLightning(strike_pos);
	            }
	        }
	}
    return true;
    }
}
