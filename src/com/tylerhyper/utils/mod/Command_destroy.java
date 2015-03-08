package com.tylerhyper.utils.mod;

import me.StevenLawson.TotalFreedomMod.TFM_RollbackManager;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.Bridge.TFM_WorldEditBridge;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import net.minecraft.util.org.apache.commons.lang3.ArrayUtils;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import static org.bukkit.Bukkit.getPlayer;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_destroy implements CommandExecutor {
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
                sender.sendMessage(TylerUtilsMod.PLAYER_NOT_FOUND);
	            return true;
	        }
	        String reason = null;
	        if (args.length >= 2)
	        {
	            reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
	        }
	        sender.sendMessage(ChatColor.RED + "Sending that Mother fucker to hell.");
	        TFM_Util.bcastMsg(player.getName() + " has been sent to Hell.", ChatColor.RED);
	        try
	        {
	            TFM_WorldEditBridge.undo(player, 15);
	        }
	        catch (NoClassDefFoundError ex)
	        {
	        }
	        TFM_RollbackManager.rollback(player.getName());
	        player.setOp(false);
	        player.setGameMode(GameMode.SURVIVAL);
	        player.getInventory().clear();
	        final Location targetPos = player.getLocation();
	        for (int x = -1; x <= 1; x++)
	        {
	            for (int z = -1; z <= 1; z++)
	            {
	                final Location strike_pos = new Location(targetPos.getWorld(), targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
	                targetPos.getWorld().strikeLightning(strike_pos);
	            }
	        }
	        player.setHealth(0.0);
           player.sendMessage(ChatColor.RED + "Welcome to hell mother fucker");
	       player.sendMessage(ChatColor.RED + "You faggot ass bitch go die in a hole");
	       sender.sendMessage(ChatColor.WHITE + "The deed has been done.");
	}
    return true;
    }
}
