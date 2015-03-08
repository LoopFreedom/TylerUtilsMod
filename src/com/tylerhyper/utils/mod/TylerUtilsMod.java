package com.tylerhyper.utils.mod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.Server;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TylerUtilsMod extends JavaPlugin {
    String LOG_PREFIX = "[TylerUtilsMod] ";
    public static final String PLAYER_NOT_FOUND = ChatColor.GRAY + "Player not found!";
    public static final String MSG_NO_PERMS = ChatColor.YELLOW + "You do not have permission to use this command.";
    private final PlayerListener playerListener = new PlayerListener(this);
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
    public static Server server;
    public static TylerUtilsMod plugin;
    public static String pluginName;
    public static String pluginVersion;
    public static final Map<String, EntityType> mobtypes = new HashMap<String, EntityType>();
    Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onLoad()
    {
        TylerUtilsMod.plugin = this;
        TylerUtilsMod.server = plugin.getServer();
        TylerUtilsMod.pluginName = plugin.getDescription().getName();
        TylerUtilsMod.pluginVersion = plugin.getDescription().getVersion();
        super.onLoad();
    }
    
    @Override
    public void onDisable() {
        try {
            this.getConfig().save("config.yml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    	PluginDescriptionFile pdfFile = getDescription();
        getLogger().info("Goodbye world!");
    }

    @Override
    public void onEnable() {
        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(playerListener, this);
        getLogger().info("Plugin designed by tylerhyperHD");
        getLogger().info("/***********************/");
        getLogger().info("TylerUtilsMod for TotalFreedom Servers");
        getLogger().info("/***********************/");
        // Register our commands
        getCommand("tylerutilsmod").setExecutor(new TylerUtilsCmd());
        getCommand("tum").setExecutor(new TylerUtilsCmd());
        getCommand("pos").setExecutor(new PosCommand());
        getCommand("fuckconsole").setExecutor(new annoycommand());
        getCommand("admin").setExecutor(new admincommand());
        getCommand("ai").setExecutor(new Command_admininfo());
        getCommand("admininfo").setExecutor(new Command_admininfo());
        getCommand("blowjob").setExecutor(new Command_blowjob());
        getCommand("blowup").setExecutor(new Command_blowup());
        getCommand("brb").setExecutor(new Command_brb());
        getCommand("clear").setExecutor(new Command_clear());
        getCommand("ci").setExecutor(new Command_clear());
        getCommand("clearall").setExecutor(new Command_clearall());
        getCommand("destroy").setExecutor(new Command_destroy());
        getCommand("destroypussy").setExecutor(new Command_destroypussy());
        getCommand("pussy").setExecutor(new Command_destroypussy());
        getCommand("impl").setExecutor(new Command_impl());
        getCommand("longshaft").setExecutor(new Command_longshaft());
        getCommand("opitems").setExecutor(new Command_opitems());
        getCommand("personal").setExecutor(new Command_personal());
        getCommand("psl").setExecutor(new Command_personal());
        getCommand("pervert").setExecutor(new Command_pervert());
        getCommand("pex").setExecutor(new Command_pex());
        getCommand("purple").setExecutor(new Command_purple());
        getCommand("question").setExecutor(new Command_question());
        getCommand("relogger").setExecutor(new Command_relogger());
        getCommand("removelagg").setExecutor(new Command_removelagg());
        getCommand("requestop").setExecutor(new Command_requestop());
        getCommand("rollbackfailed").setExecutor(new Command_rollbackfailed());
        getCommand("sendtaw").setExecutor(new Command_sendtaw());
        getCommand("shutup").setExecutor(new Command_shutup());
        getCommand("telnet").setExecutor(new Command_telnet());
        getCommand("whore").setExecutor(new Command_whore());
        getCommand("tylerfuck").setExecutor(new Command_whore());
        PluginDescriptionFile pdfFile = this.getDescription();
        getLogger().info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }
    
    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    // Still in use by listeners
    public static void playerMsg(CommandSender sender, String message, ChatColor color)
    {
        sender.sendMessage(color + message);
    }
    
    public static String colorize(String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    // Still in use by listeners
    public static void playerMsg(CommandSender sender, String message)
    {
        TylerUtilsMod.playerMsg(sender, message, ChatColor.GRAY);
    }

    public static File getPluginFile(Plugin plugin, String name)  // BukkitLib @ https://github.com/Pravian/BukkitLib
    {
        return new File(plugin.getDataFolder(), name);
    }
}
