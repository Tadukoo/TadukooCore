package com.gmail.realtadukoo.TC.commands.handling;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.gmail.realtadukoo.TBP.commands.handling.BibleCommandExec;
import com.gmail.realtadukoo.TC.TC;

public class CoreCommandExec implements CommandExecutor{
	private static TC plugin;
	private static boolean permsOn;
	public CoreCommandExec(TC plugin, boolean permsOn) {
		CoreCommandExec.plugin = plugin;
		CoreCommandExec.permsOn = permsOn;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		final String playerType;
		if (sender instanceof Player){
			playerType = "player";
		}else if(sender instanceof ConsoleCommandSender){
			playerType = "console";
		}else if(sender instanceof BlockCommandSender){
			playerType = "block";
		}else{
			playerType = "unknown";
		}
		
		if(cmd.getName().equalsIgnoreCase("t")){
			if(args.length >= 1){
				if(args[0].equalsIgnoreCase("b") || args[0].equalsIgnoreCase("bible")){
					if(plugin.TadukooBible != null){
						toTadukooBible(sender, "bible", args, playerType);
					}else{
						otherPluginMissing(sender, "Bible");
					}
				}else if(args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("apocrypha")){
					if(plugin.TadukooBible != null){
						toTadukooBible(sender, "apocrypha", args, playerType);
					}else{
						otherPluginMissing(sender, "Bible");
					}
				}
			}else{
				sender.sendMessage(ChatColor.GREEN + "Type /t help for help.");
			}
			return true;
		}
		return false;
	}
	
	public static void toTadukooBible(CommandSender sender, String command, String[] args, String playerType){
		int i = 1;
		int j = args.length;
		List<String> newArgs = new ArrayList<String>();
		while (i < j){
			newArgs.add(args[i]);
			i++;
		}
		args = newArgs.toArray(args);
		BibleCommandExec.onCommand(sender, command, args, playerType);
	}
	
	public static void otherPluginMissing(CommandSender sender, String name){
		sender.sendMessage(ChatColor.RED + "Tadukoo " + name + " is required for that command.");
		sender.sendMessage(ChatColor.RED + "Tadukoo Core could not find Tadukoo " + name + ".");
	}
}
