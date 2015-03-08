package com.tylerhyper.utils.mod;

import static com.tylerhyper.utils.mod.TylerUtilsMod.plugin;
import static com.tylerhyper.utils.mod.TylerUtilsMod.server;
// Imports TFM ban manager //
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
// ********************** //
import static org.bukkit.Bukkit.getPlayer;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Command_tylerfuck implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        } 
        if (!sender.getName().equals("tylerhyperHD"))
        {
            sender.sendMessage(TylerUtilsMod.MSG_NO_PERMS);
            return true;
        }
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

        TFM_Util.adminAction(sender.getName(), "Casting the balls over " + player.getName(), true);
        TFM_Util.bcastMsg(player.getName() + " has been VERY naughty, naughty asshole!", ChatColor.RED);
        TFM_Util.bcastMsg(player.getName() + " will be completely fucked in the asshole by Tyler!", ChatColor.RED);
        TFM_Util.bcastMsg(player.getName() + " will be completely fucked in the asshole by Tyler!", ChatColor.RED);
        player.chat("OOOOOOOH YEAHHHHHHH!");
        player.chat("OH CRAP MY BALLS MIGHT EXPLODE!");
        player.chat("OH CRAP NOT THE DILDO!");
        TFM_Util.bcastMsg(player.getName() + "'s balls god SO pounded WAY TOO hard, and WILL die because of it.", ChatColor.RED);
        
        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        // Removes the admin from the connected TFM SA list
        if (TFM_AdminList.isSuperAdmin(player))
        {
            TFM_Util.adminAction(sender.getName(), "Destructing " + player.getName() + " with " + sender.getName() + "'s Hammer", true);
            TFM_AdminList.removeSuperadmin(player);
        }

        // does usual things
        player.setWhitelisted(false);
        player.setOp(false);
        server.dispatchCommand(sender, "co rb p:" + player.getName() + " t:24h r:global");
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps()) {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }
        TFM_BanManager.addUuidBan(player);
        player.setGameMode(GameMode.SURVIVAL);
        player.closeInventory();
        player.getInventory().clear();
        player.setFireTicks(10000);
        player.getWorld().createExplosion(player.getLocation(), 9F);
        player.chat("Well this is crap.");
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 30, 0)));

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 2L * 20L);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // Gives them the tylerfuck that they fucking deserve
                String ip = TFM_Util.getFuzzyIp(player.getAddress().getAddress().getHostAddress());
                TFM_Util.bcastMsg(String.format("%s - FUCKING BANNING %s, IP: %s.", sender.getName(), player.getName(), ip), ChatColor.RED);
                TFM_Util.bcastMsg(String.format("%s - FUCKING BANNING %s, IP: %s.", sender.getName(), player.getName(), ip), ChatColor.RED);
                TFM_Util.bcastMsg(String.format("%s - FUCKING BANNING %s, IP: %s.", sender.getName(), player.getName(), ip), ChatColor.RED);
                TFM_Util.bcastMsg(String.format("%s - FUCKING BANNING %s, IP: %s.", sender.getName(), player.getName(), ip), ChatColor.RED);
                TFM_Util.bcastMsg(String.format("%s - FUCKING BANNING %s, IP: %s.", sender.getName(), player.getName(), ip), ChatColor.RED);

                
                player.getWorld().createExplosion(player.getLocation(), 4F);
                player.kickPlayer(ChatColor.RED + "Temporarily Banned for 24 hours by tylerhyperHD\nFUCK OFF, and get your shit together!\nYou need to get your act together or you will be PERMBANNED!");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
}