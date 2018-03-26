package me.skevydev.sfirst.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.skevydev.sfirst.utils.Arrays;

public class FirstCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("first")) {
			if(sender.hasPermission("sfirst.command.first") || sender.isOp()) {
				if(args.length >= 0) {
					if(Arrays.first.isEmpty()) {
						sender.sendMessage("§c§lFIRST §fNão há nenhum first no momento!");
					}else {
						sender.sendMessage("§a§lFIRST §fO atual first do servidor: §a" + Arrays.first.get(0));
					}
				}
			}else {
				sender.sendMessage("§c§lFIRST §fVocê não tem permissão para executar este comando!");
			}
		}
		return false;
	}

}
