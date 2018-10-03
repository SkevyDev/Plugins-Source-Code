package me.skevydev.com.santiproxy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.skevydev.com.santiproxy.Main;

public class AntiProxyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("antiproxy")) {
			if(sender.hasPermission("santiproxy.admin")) {
				if(args.length >= 0) {
					sender.sendMessage("");
					sender.sendMessage("§c§lANTI-PROXY");
					sender.sendMessage("§cTotal de proxies que tentaram conectar (Pós reinicio do servidor): §f" +
							Main.getInstance().getProxyChecker().getTotalProxy());
					sender.sendMessage("");
				}
			}else {
				sender.sendMessage("§c[AntiProxy] §fVocê não tem permissão para executar este comando!");
			}
		}
		return false;
	}
	
}