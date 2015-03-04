package com.tylerhyper.utils.mod;

import static com.tylerhyper.utils.mod.TylerUtilsMod.server;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_removelagg implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (TFM_AdminList.isSeniorAdmin(sender)) {
        TFM_Util.bcastMsg(ChatColor.RED + "Removing all forms of client and server lagg");
            server.dispatchCommand(sender, "lagg chunk");
            server.dispatchCommand(sender, "lagg clear");
            server.dispatchCommand(sender, "lagg unloadchunks");
            server.dispatchCommand(sender, "setl");
            server.dispatchCommand(sender, "ro 119");
            server.dispatchCommand(sender, "ro 52");
            server.dispatchCommand(sender, "rd");
            server.dispatchCommand(sender, "opall -c");
            server.dispatchCommand(sender, "mp");
            server.dispatchCommand(sender, "purgeall");
            server.dispatchCommand(sender, "lagg gc");
            server.dispatchCommand(sender, "save-all");
            server.dispatchCommand(sender, "cc");
            TFM_Util.bcastMsg(ChatColor.GREEN + "Lagg cleanup completed. Server catching up.");
        }
        return true;
    }
}
