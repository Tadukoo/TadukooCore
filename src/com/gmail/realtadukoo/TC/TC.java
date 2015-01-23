package com.gmail.realtadukoo.TC;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TFO.TFO;
import com.gmail.lucario77777777.TMS.TM;
import com.gmail.lucario77777777.TVF.TVF;
import com.gmail.realtadukoo.TC.commands.handling.CComExec;
import com.gmail.realtadukoo.TC.listeners.CPlayerListener;
import com.gmail.realtadukoo.TCh.TCh;
import com.gmail.realtadukoo.TP.TP;
import com.gmail.realtadukoo.TBP.TB;
import com.gmail.realtadukoo.TBPB.TBB;

public class TC extends JavaPlugin{
	// Used by other classes to use functions in here
	public static TC plugin;
	
	// Used for other plugins
	public boolean TAdjustments = false, TBible = false, TBibleBooks = false, TChat = false, TEssentials = false,
			TFakeOp = false, TMobSpawning = false, TPerms = false, TVanillaFeel = false;
	//public TA TadukooAdjustments = null; Future Tadukoo Adjustments plugin
	public TB TadukooBible = null;
	public TBB TadukooBibleBooks = null;
	public TCh TadukooChat = null;
	public TE TadukooEssentials = null;
	public TFO TadukooFakeOp = null;
	public TM TadukooMobSpawning = null;
	public TP TadukooPerms = null;
	public TVF TadukooVanillaFeel = null;
	
	// plugin.yml
	PluginDescriptionFile pdfFile = this.getDescription();
	
	// config.yml
	public static FileConfiguration config;
	
	// playerList.yml
	public static FileConfiguration players;
	public static File playersFile;
	
	// language.yml file
	public static FileConfiguration language;
	public static File languageFile;
	
	@Override
	public void onDisable () {
		// Set everything to null to prevent memory leaks
		plugin = null;
		//TadukooAdjustments = null;
		TadukooBible = null;
		TadukooBibleBooks = null;
		TadukooChat = null;
		TadukooEssentials = null;
		TadukooFakeOp = null;
		TadukooMobSpawning = null;
		TadukooPerms = null;
		TadukooVanillaFeel = null;
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
		getCommand("t").setExecutor(new CComExec());
		
		// Register events.
		this.getServer().getPluginManager().registerEvents(new CPlayerListener(this), this);
	}
	
	/*
	 * Checks for any other Tadukoo plugins on the server.
	 * Sets the variables for the plugins if they're on the server.
	 */
	private void checkforTadukooPlugins() {
		/*// Check for Tadukoo Adjustments.
		if(getServer().getPluginManager().getPlugin("Tadukoo_Adjustments") != null){
			TAdjustments = true;
			TadukooAdjustments = (TA) getServer().getPluginManager().getPlugin("Tadukoo_Adjustments");
			getLogger().log(Level.INFO, "Hooked into Tadukoo Adjustments.");
		}*/
		// Check for Tadukoo Bible.
		if(getServer().getPluginManager().getPlugin("Tadukoo_Bible") != null){
			TBible = true;
			TadukooBible = (TB) getServer().getPluginManager().getPlugin("Tadukoo_Bible");
			getLogger().log(Level.INFO, "Hooked into Tadukoo Bible.");
			TadukooBible.updateTadukooPlugins(false, false, false, true, false, false, false, false, false);
		}
		// Check for Tadukoo Bible Books.
		if(getServer().getPluginManager().getPlugin("Tadukoo_Bible_Books") != null){
			TBibleBooks = true;
			TadukooBibleBooks = (TBB) getServer().getPluginManager().getPlugin("Tadukoo_Bible_Books");
			getLogger().log(Level.INFO, "Hooked into Tadukoo Bible Books.");
		}
		// Check for Tadukoo Chat.
		if(getServer().getPluginManager().getPlugin("Tadukoo_Chat") != null){
			TChat = true;
			TadukooChat = (TCh) getServer().getPluginManager().getPlugin("Tadukoo_Chat");
			getLogger().log(Level.INFO, "Hooked into Tadukoo Chat.");
		}
		// Check for Tadukoo Essentials.
		if(getServer().getPluginManager().getPlugin("Tadukoo_Essentials") != null){
			TEssentials = true;
			TadukooEssentials = (TE) getServer().getPluginManager().getPlugin("Tadukoo_Essentials");
			getLogger().log(Level.INFO, "Hooked into Tadukoo Essentials.");
		}
		// Check for Tadukoo Fake Op.
		if(getServer().getPluginManager().getPlugin("Tadukoo_Fake_Op") != null){
			TFakeOp = true;
			TadukooFakeOp = (TFO) getServer().getPluginManager().getPlugin("Tadukoo_Fake_Op");
			getLogger().log(Level.INFO, "Hooked into Tadukoo Fake Op.");
		}
		// Check for Tadukoo Mob Spawning.
		if(getServer().getPluginManager().getPlugin("Tadukoo_Mob_Spawning") != null){
			TMobSpawning = true;
			TadukooMobSpawning = (TM) getServer().getPluginManager().getPlugin("Tadukoo_Mob_Spawning");
			getLogger().log(Level.INFO, "Hooked into Tadukoo Mob Spawning.");
		}
		// Check for Tadukoo Perms
		if(getServer().getPluginManager().getPlugin("Tadukoo_Perms") != null){
			TPerms = true;
			TadukooPerms = (TP) getServer().getPluginManager().getPlugin("Tadukoo_Perms");
			getLogger().log(Level.INFO, "Hooked into Tadukoo Perms.");
		}
		// Check for Tadukoo Vanilla Feel
		if(getServer().getPluginManager().getPlugin("Tadukoo_Vanilla_Feel") != null){
			TVanillaFeel = true;
			TadukooVanillaFeel = (TVF) getServer().getPluginManager().getPlugin("Tadukoo_Vanilla_Feel");
			getLogger().log(Level.INFO, "Hooked into Tadukoo Vanilla Feel.");
		}
	}
	
	/*
	 * Used to re-run checkforTadukooPlugins so that none are missed.
	 */
	public void updateTadukooPlugins(boolean Bible, boolean BibleBooks, boolean Chat, boolean Core, 
			boolean Essentials, boolean FakeOp, boolean MobSpawning, boolean Perms, boolean VanillaFeel){
		if(Bible){
			TBible = true;
			TadukooBible = (TB) getServer().getPluginManager().getPlugin("Tadukoo_Bible");
		}
		if(BibleBooks){
			TBibleBooks = true;
			TadukooBibleBooks = (TBB) getServer().getPluginManager().getPlugin("Tadukoo_Bible_Books");
		}
		if(Chat){
			TChat = true;
			TadukooChat = (TCh) getServer().getPluginManager().getPlugin("Tadukoo_Chat");
		}
		if(Essentials){
			TEssentials = true;
			TadukooEssentials = (TE) getServer().getPluginManager().getPlugin("Tadukoo_Essentials");
		}
		if(FakeOp){
			TFakeOp = true;
			TadukooFakeOp = (TFO) getServer().getPluginManager().getPlugin("Tadukoo_Fake_Op");
		}
		if(MobSpawning){
			TMobSpawning = true;
			TadukooMobSpawning = (TM) getServer().getPluginManager().getPlugin("Tadukoo_Fake_Op");
		}
		if(Perms){
			TPerms = true;
			TadukooPerms = (TP) getServer().getPluginManager().getPlugin("Tadukoo_Fake_Op");
		}
		if(VanillaFeel){
			TVanillaFeel = true;
			TadukooVanillaFeel = (TVF) getServer().getPluginManager().getPlugin("Tadukoo_Fake_Op");
		}
	}
	
	/*
	 * Load a language.
	 */
	public void reloadLanguage(){
		String Language = config.getString("language");
		
	    if (languageFile == null) {
	    	languageFile = new File(getDataFolder(), "languages/" + Language + ".yml");
	    }
	    language = YamlConfiguration.loadConfiguration(languageFile);
	 
	    Reader defConfigFile = this.getTextResource("languages/" + Language + ".yml");
	    if (defConfigFile == null) {
	    	this.getLogger().log(Level.WARNING, "Couldn't find " + Language + " language file in plugin!");
	    	this.getLogger().log(Level.WARNING, "Setting to en_US...");
	    	config.set("language", "en_US");
	    	saveConfig();
	    	defConfigFile = this.getTextResource("languages/en_US.yml");
	    }
	    YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigFile);
	    language.setDefaults(defConfig);
	}
	
	/*
	 * Get a language.
	 */
	public FileConfiguration getLanguage(){
	    if(language == null){
	        this.reloadLanguage();
	    }
	    return language;
	}
	
	/*
	 * Load playerList.yml
	 */
	public void reloadPlayerList(){
	    if(playersFile == null){
	    	playersFile = new File(getDataFolder(), "playerList.yml");
	    }
	    players = YamlConfiguration.loadConfiguration(playersFile);
	}
	
	/*
	 * Get a UUID from playerList.yml
	 */
	public UUID getUUID(String player){
	    if(players == null){
	        plugin.reloadPlayerList();
	    }
	    return UUID.fromString(players.getString(player));
	}
	
	/*
	 * Set a UUID in playerList.yml
	 */
	public void setUUID(String player, UUID ID){
		if(players == null){
			plugin.reloadPlayerList();
		}
		players.set(player, ID);
	}
	
	/*
	 * Save playerList.yml
	 */
	public void savePlayerList(){
	    if (players == null || playersFile == null){
	    	return;
	    }
	    try{
	        players.save(playersFile);
	    }catch (IOException ex){
	        plugin.getLogger().log(Level.SEVERE, "Could not save player records to " + playersFile + ex);
	    }
	}
}
