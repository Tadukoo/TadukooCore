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

import com.gmail.realtadukoo.TBP.commands.handling.BComExec;

public class CComExec implements CommandExecutor{
	public CComExec() {
		
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
				CEnumCmds ecmd = CEnumCmds.BIBLE;
				ecmd = ecmd.fromString(args[0]);
				if(!ecmd.isAvailable()){
					otherPluginMissing(sender, ecmd);
					return true;
				}
				if(ecmd == CEnumCmds.BIBLE){
					toTadukooBible(sender, "bible", args, playerType);
				}else if(ecmd == CEnumCmds.APOCRYPHA){
					toTadukooBible(sender, "apocrypha", args, playerType);
				}else if(ecmd == CEnumCmds.PERM){
					
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
		BComExec.onCommand(sender, command, args, playerType);
	}
	
	public static void otherPluginMissing(CommandSender sender, CEnumCmds ecmd){
		sender.sendMessage(ChatColor.RED + "Tadukoo " + ecmd.getPlugin() + " is required for that command.");
		sender.sendMessage(ChatColor.RED + "Tadukoo Core could not find Tadukoo " + ecmd.getPlugin() + ".");
	}
}
