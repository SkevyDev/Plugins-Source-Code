package me.skevydev.sfirst.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.skevydev.sfirst.utils.Arrays;

public class DefinirFirstCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("definirfirst")) {
			if(sender.hasPermission("sfirst.command.definirfirst") || sender.isOp()) {
				if(args.length == 0) {
					sender.sendMessage("§a§lFIRST §fDigite: §a/definirfirst [player]");
					return true;
				}
				
				if(args.length == 1) {
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if(target == null) {
						sender.sendMessage("§c§lFIRST §fJogador não encontrado!");
					}else {
						Arrays.first.set(0, target.getName());
						Bukkit.broadcastMessage("§a§lFIRST §fO player §a" + target.getName() + " §fé o mais novo first!");
					}
				}else if(args.length > 1) {
					sender.sendMessage("§c§lFIRST §fUse: §c/definirfirst [player]");
					return true;
				}
			}else {
				sender.sendMessage("§c§lFIRST §fVocê não tem permissão para executar este comando!");
			}
		}
		return false;
	}

}
