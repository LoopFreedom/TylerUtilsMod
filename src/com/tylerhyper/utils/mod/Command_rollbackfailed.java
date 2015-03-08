package com.tylerhyper.utils.mod;

import me.StevenLawson.TotalFreedomMod.Bridge.TFM_WorldEditBridge;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_RollbackManager;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_rollbackfailed implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (TFM_AdminList.isSeniorAdmin(sender)) {
         if (args.length != 1)
        {
            return false;
        }
        final Player player = getPlayer(args[0]);
        if (player == null)
        {
            sender.sendMessage(TylerUtilsMod.PLAYER_NOT_FOUND);
            return true;
        }
    try
     {
         TFM_WorldEditBridge.undo(player, 15);
     }
         catch (NoClassDefFoundError ex)
     {
     }
         Player sender_p = Bukkit.getPlayer(sender.getName());
         TFM_RollbackManager.rollback(player.getName());
         sender_p.sendMessage("Hopefully that fixes it :D");
     }
     return true;
    }
}