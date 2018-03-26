package me.skevydev.sgodmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.skevydev.sgodmode.utils.Arrays;

public class GodCommand implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("god")) {
			if(sender.hasPermission("sgodmode.command.god")) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					if(args.length == 0) {
						if(Arrays.godmode.contains(p.getName())) {
							Arrays.godmode.remove(p.getName());
							p.sendMessage("§c§lGOD §fVocê saiu do modo god!");
						}else {
							Arrays.godmode.add(p.getName());
							p.sendMessage("§a§lGOD §fVocê entrou no modo god!");
						}
					}else if(args.length == 1) {
						Player target = Bukkit.getServer().getPlayer(args[0]);
						if(target == null) {
							p.sendMessage("§c§lGOD §fJogador citado não encontrado!");
						}else {
							if(Arrays.godmode.contains(target.getName())) {
								Arrays.godmode.remove(target.getName());
								p.sendMessage("§c§lGOD §fVocê desativou o modo god do player §c" + target.getName() + "§f!");
							}else {
								Arrays.godmode.add(target.getName());
								p.sendMessage("§a§lGOD §fVocê ativou o modo god do player §a" + target.getName() + "§f!");
							}
						}
					}else if(args.length > 1) {
						p.sendMessage("§c§lGOD §fUse: §c/god [player] ou apenas /god");
						return true;
					}
				}else {
					if(args.length == 0) {
						sender.sendMessage("§a§lGOD §fUse: §a/god [player]");
						return true;
					}
					
					if(args.length == 1) {
						Player target = Bukkit.getServer().getPlayer(args[0]);
						if(target == null) {
							sender.sendMessage("§c§lGOD §fJogador citado não encontrado!");
						}else {
							if(Arrays.godmode.contains(target.getName())) {
								Arrays.godmode.remove(target.getName());
								sender.sendMessage("§c§lGOD §fVocê desativou o modo god do player §c" + target.getName() + "§f!");
							}else {
								Arrays.godmode.add(target.getName());
								sender.sendMessage("§a§lGOD §fVocê ativou o modo god do player §a" + target.getName() + "§f!");
							}
						}
					}else if(args.length > 1) {
						sender.sendMessage("§a§lGOD §fUse: §a/god [player]");
						return true;
					}
				}
			}else {
				sender.sendMessage("§c§lGOD §fVocê não tem permissão para executar este comando!");
			}
		}
		return false;
	}

}
