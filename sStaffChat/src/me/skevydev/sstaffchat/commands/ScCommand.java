package me.skevydev.sstaffchat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.skevydev.sstaffchat.utils.Arrays;

public class ScCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("sc")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§c§lSTAFFCHAT §fVocê precisa ser um player para executar este comando!");
				return true;
			}
			
			Player p = (Player) sender;
			if(p.hasPermission("sstaffchat.command.sc") || p.hasPermission("sstaffchat.command.staffchat") || p.isOp()) {
				if(args.length == 0) {
					if(Arrays.staffchat.contains(p.getName())) {
						Arrays.staffchat.remove(p.getName());
						p.sendMessage("§c§lSTAFFCHAT §fVocê saiu do chat staff!");
					}else {
						Arrays.staffchat.add(p.getName());
						p.sendMessage("§a§lSTAFFCHAT §fVocê agora está no chat da staff!");
					}
				}else if(args.length > 0) {
					p.sendMessage("§c§lSTAFFCHAT §fUse: §c/sc");
					return true;
				}
			}else {
				p.sendMessage("§c§lSTAFFCHAT §fVocê não tem permissão para executar este comando!");
			}
		}
		return false;
	}

}
