package com.gmail.realtadukoo.TC;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.realtadukoo.TC.commands.handling.CoreCommandExec;
import com.gmail.realtadukoo.TC.listeners.CorePlayerListener;

import com.gmail.realtadukoo.TBP.TB;
import com.gmail.realtadukoo.TBPB.TBB;

public class TC extends JavaPlugin{
	// Used by other classes to use functions in here
	public static TC plugin;
	
	// Used for other plugins
	public TB TadukooBible = null;
	public TBB TadukooBibleBooks = null;
	
	// plugin.yml
	PluginDescriptionFile pdfFile = this.getDescription();
	
	// config.yml
	public static FileConfiguration config;
	
	// playerList.yml
	public static FileConfiguration players;
	public static File playersFile;
	
	@Override
	public void onDisable () {
		// Set everything to null to prevent memory leaks
		plugin = null;
		TadukooBible = null;
		TadukooBibleBooks = null;
		pdfFile = null;
		config = null;
		players = null;
		playersFile = null;
		
		// Save config.yml
		saveConfig();
	}
	
	@Override
	public void onEnable () {			
		// Set plugin so other classes may use this class through it.
		plugin = this;
		
		// Set config.yml
		config = getConfig();
		
		// Check for all Tadukoo plugins.
		checkforTadukooPlugins();
		
		// Load commands from the command executor class.
		getCommand("t").setExecutor(new CoreCommandExec(this));
		
		// Register events.
		this.getServer().getPluginManager().registerEvents(new CorePlayerListener(this), this);
	}
	
	/*
	 * Checks for any other Tadukoo plugins on the server.
	 * Sets the variables for the plugins if they're on the server.
	 */
	private void checkforTadukooPlugins() {
		// Check for Tadukoo Bible.
		if(getServer().getPluginManager().getPlugin("Tadukoo_Bible") != null){
			TadukooBible = (TB) getServer().getPluginManager().getPlugin("Tadukoo_Bible");
		}
		// Check for Tadukoo Bible Books last.
		if(getServer().getPluginManager().getPlugin("Tadukoo_Bible_Books") != null){
			TadukooBibleBooks = (TBB) getServer().getPluginManager().getPlugin("Tadukoo_Bible_Books");
		}
	}
	
	/*
	 * Load playerList.yml
	 */
	public void reloadPlayerList() {
	    if (playersFile == null) {
	    	playersFile = new File(getDataFolder(), "playerList.yml");
	    }
	    players = YamlConfiguration.loadConfiguration(playersFile);
	}
	
	/*
	 * Get playerList.yml
	 */
	public FileConfiguration getPlayerList() {
	    if (players == null) {
	        plugin.reloadPlayerList();
	    }
	    return players;
	}
	
	/*
	 * Save playerList.yml
	 */
	public void savePlayerList() {
	    if (players == null || playersFile == null) {
	    return;
	    }
	    try {
	        getPlayerList().save(playersFile);
	    } catch (IOException ex) {
	        plugin.getLogger().log(Level.SEVERE, "Could not save player records to " + playersFile + ex);
	    }
	}
}
