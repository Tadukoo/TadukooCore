package com.gmail.realtadukoo.TC.commands.handling;

import com.gmail.realtadukoo.TC.TC;

public enum CEnumCmds{
	APOCRYPHA("apocrypha", "Bible", "a"),
	BIBLE("bible", "Bible", "b"),
	PERM("perm", "Perms", "p", "perms", "permission", "permissions");
	
	private String cmd;
	private String plugin;
	private String alias;
	private String alias2;
	private String alias3;
	private String alias4;
	private String alias5;
	
	/*
	 * Constructor for 1 alias.
	 */
	private CEnumCmds(String cmd, String plugin, String alias){
		this.cmd = cmd;
		this.plugin = plugin;
		this.alias = alias;
	}
	
	/*
	 * Constructor for 2 aliases.
	 */
	private CEnumCmds(String cmd, String plugin, String alias, String alias2){
		this.cmd = cmd;
		this.plugin = plugin;
		this.alias = alias;
		this.alias2 = alias2;
	}
	
	/*
	 * Constructor for 3 aliases.
	 */
	private CEnumCmds(String cmd, String plugin, String alias, String alias2, String alias3){
		this.cmd = cmd;
		this.plugin = plugin;
		this.alias = alias;
		this.alias2 = alias2;
		this.alias3 = alias3;
	}
	
	/*
	 * Constructor for 4 aliases.
	 */
	private CEnumCmds(String cmd, String plugin, String alias, String alias2, String alias3, String alias4){
		this.cmd = cmd;
		this.plugin = plugin;
		this.alias = alias;
		this.alias2 = alias2;
		this.alias3 = alias3;
		this.alias4 = alias4;
	}
	
	/*
	 * Constructor for 5 aliases.
	 */
	private CEnumCmds(String cmd, String plugin, String alias, String alias2, String alias3, String alias4, 
			String alias5){
		this.cmd = cmd;
		this.plugin = plugin;
		this.alias = alias;
		this.alias2 = alias2;
		this.alias3 = alias3;
		this.alias4 = alias4;
		this.alias5 = alias5;
	}
	
	public String getCmd(){
		return cmd;
	}
	
	public String getPlugin(){
		return plugin;
	}
	
	public String getAlias(){
		return alias;
	}
	
	public String getAlias2(){
		return alias2;
	}
	
	public String getAlias3(){
		return alias3;
	}
	
	public String getAlias4(){
		return alias4;
	}
	
	public String getAlias5(){
		return alias5;
	}
	
	public boolean isAvailable(){
		if(plugin.equalsIgnoreCase("Adjustments") && TC.plugin.TAdjustments){
			return true;
		}else if(plugin.equalsIgnoreCase("Bible") && TC.plugin.TBible){
			return true;
		}else if(plugin.equalsIgnoreCase("BibleBooks") && TC.plugin.TBibleBooks){
			return true;
		}else if(plugin.equalsIgnoreCase("Chat") && TC.plugin.TChat){
			return true;
		}else if(plugin.equalsIgnoreCase("Core")){
			return true;
		}else if(plugin.equalsIgnoreCase("Essentials") && TC.plugin.TEssentials){
			return true;
		}else if(plugin.equalsIgnoreCase("FakeOp") && TC.plugin.TFakeOp){
			return true;
		}else if(plugin.equalsIgnoreCase("MobSpawning") && TC.plugin.TMobSpawning){
			return true;
		}else if(plugin.equalsIgnoreCase("Perms") && TC.plugin.TPerms){
			return true;
		}else if(plugin.equalsIgnoreCase("VanillaFeel") && TC.plugin.TVanillaFeel){
			return true;
		}else{
			return false;
		}
	}
	
	public CEnumCmds fromString(String cmd){
		if (cmd != null) {
			for (CEnumCmds c : CEnumCmds.values()) {
				if (cmd.equalsIgnoreCase(c.getCmd()) || cmd.equalsIgnoreCase(c.getAlias()) ||
						cmd.equalsIgnoreCase(c.getAlias2()) || cmd.equalsIgnoreCase(c.getAlias3()) || 
						cmd.equalsIgnoreCase(c.getAlias4()) || cmd.equalsIgnoreCase(c.getAlias5())) {
					return c;
				}
			}
		}
		return null;
	}
}
