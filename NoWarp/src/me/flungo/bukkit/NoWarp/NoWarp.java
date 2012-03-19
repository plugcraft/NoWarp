package me.flungo.bukkit.NoWarp;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.bekvon.bukkit.residence.protection.FlagPermissions;

public class NoWarp extends JavaPlugin {
public static NoWarp plugin;
	
	public final Logger logger = Logger.getLogger("MineCraft");
	
	public final PlayerListeners playerListener = new PlayerListeners(this);
	
	public PluginDescriptionFile pdf;
	
	public void onDisable() {
		this.logger.info(pdf.getName() + " is now disabled");
	}
	
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.playerListener, this);
		pdf = this.getDescription();
		this.logger.info(pdf.getName() + " version " + pdf.getVersion() + " is enabled.");
		FlagPermissions.addFlag("warp");
	}
}
