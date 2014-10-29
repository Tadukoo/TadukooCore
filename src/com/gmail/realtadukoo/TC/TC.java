package com.gmail.realtadukoo.TC;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.realtadukoo.TC.commands.handling.CoreCommandExec;

import com.gmail.realtadukoo.TBP.TB;

public class TC extends JavaPlugin{
	// Used by other classes to use functions in here
	public static TC plugin;
	
	// Used for other plugins
	public TB TadukooBible;
	
	// plugin.yml
	PluginDescriptionFile pdfFile = this.getDescription();
	
	// config.yml
	public static FileConfiguration config;
	
	// Used for if permissions are on or off
	public Boolean perms = null;
	
	@Override
	public void onDisable () {
		// Set everything to null to prevent memory leaks
		plugin = null;
		pdfFile = null;
		config = null;
		
		// Save config.yml
		saveConfig();
	}
	
	@Override
	public void onEnable () {			
		// Set plugin so other classes may use this class through it.
		plugin = this;
		
		// Set config.yml
		config = getConfig();
		
		// Set permissions to on or off.
		perms = getConfig().getBoolean("Permissions");
		
		checkforTadukooPlugins();
		
		// Load commands from the command executor class.
		getCommand("t").setExecutor(new CoreCommandExec(this, perms));
	}

	private void checkforTadukooPlugins() {
		if(getServer().getPluginManager().getPlugin("Tadukoo_Bible") != null){
			TadukooBible = (TB) getServer().getPluginManager().getPlugin("Tadukoo_Bible");
		}
	}
}
