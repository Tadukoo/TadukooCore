package com.gmail.realtadukoo.TC.listeners;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.realtadukoo.TC.TC;

public class CorePlayerListener implements Listener{
	public TC plugin;
	public CorePlayerListener(TC plugin){
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		String name = player.getName();
		UUID id = player.getUniqueId();
		plugin.getPlayerList().set(name, id);
		plugin.savePlayerList();
	}
}
