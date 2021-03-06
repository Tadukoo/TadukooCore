package com.gmail.realtadukoo.TC.listeners;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.realtadukoo.TC.TC;

public class CPlayerListener implements Listener{
	public TC plugin;
	public CPlayerListener(TC plugin){
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		String name = player.getName();
		UUID ID = player.getUniqueId();
		plugin.setUUID(name, ID);
		plugin.savePlayerList();
	}
}
