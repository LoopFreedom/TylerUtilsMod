package com.tylerhyper.utils.mod;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_whore implements CommandExecutor {
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

            player.sendMessage(TylerUtilsMod.PLAYER_NOT_FOUND);
            return true;
        }
        Player sender_p = Bukkit.getPlayer(sender.getName());
        sender_p.chat("Hey " + player.getName() + ", guess what?");
        player.chat("What?");
        sender_p.chat("U whore.");
        sender_p.chat("C:");
        player.setHealth(0.0);
        player.chat("U whore.");
        sender_p.chat("C:");
    }
        return true;
    }
}
