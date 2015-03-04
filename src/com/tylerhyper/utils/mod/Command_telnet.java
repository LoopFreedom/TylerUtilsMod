package com.tylerhyper.utils.mod;

import static com.tylerhyper.utils.mod.TylerUtilsMod.server;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_telnet implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (TFM_AdminList.isSeniorAdmin(sender)) {
        if (args.length == 0)
        {
            return false;
        }
        else if (args.length == 1)
        {
        if (args[0].equals("on"))
        {
            server.dispatchCommand(sender, "plugincontrol enable BukkitTelnet");
        TFM_Util.adminAction(sender.getName(), "Enabling the telnet client for all admins", true);
        return true;
        }
        else if (args[0].equals("off"))
        {
            server.dispatchCommand(sender, "plugincontrol disable BukkitTelnet");
            TFM_Util.adminAction(sender.getName(), "Disabling the telnet client for all admins", true);
        }
        }
    }
    return true;
    }
}