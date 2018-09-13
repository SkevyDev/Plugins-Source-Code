package me.skevydev.com.login.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.skevydev.com.login.Main;
import me.skevydev.com.login.utils.Login;

public class RegisterCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("register")) {
			if(!(sender instanceof Player)) {
				Bukkit.getConsoleSender().sendMessage("§cVocê não pode executar esse comando no console.");
				return true;
			}
			Player p = (Player) sender;
			Login login = new Login(p);
			if(!login.isRegistered()) {
				if(args.length <= 1) {
					p.sendMessage("§cUse: /register [senha] [senha]");
				}else if(args.length == 2) {
					if(args[0].length() <= 16) {
						if(args[0].length() >= 4) {
							if(args[1].equals(args[0])) {
								login.setPassword(args[0]);
								login.setup();
								if(Main.getInstance().loggingIn.contains(p)) Main.getInstance().loggingIn.remove(p);
								p.sendMessage("§aRegistrado com sucesso!");
							}else {
								p.sendMessage("§cConfirmação de senha incorreta!");
							}
						}else {
							p.sendMessage("§cA senha tem que ter no minimo 4 caracteres.");
						}
					}else {
						p.sendMessage("§cA senha tem que ter no máximo 16 caracteres.");
					}
				}else {
					p.sendMessage("§cUse: /register [senha] [senha]");
				}
			}else {
				p.sendMessage("§cVocê já está registrado!");
			}
		}
		return false;
	}
	
}