package me.skevydev.com.login.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.skevydev.com.login.Main;
import me.skevydev.com.login.utils.Login;

public class LoginCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("login")) {
			if(!(sender instanceof Player)) {
				Bukkit.getConsoleSender().sendMessage("§cVocê não pode executar esse comando no console.");
				return true;
			}
			Player p = (Player) sender;
			Login login = new Login(p);
			if(Main.getInstance().loggingIn.contains(p)) {
				if(args.length == 0) {
					p.sendMessage("§cUse: /login [senha]");
				}else if(args.length == 1) {
					if(args[0].equals(login.getPassword())) {
						if(Main.getInstance().loggingIn.contains(p)) Main.getInstance().loggingIn.remove(p);
						p.sendMessage("§aLogado com sucesso!");
					}else {
						p.sendMessage("§cSenha incorreta, tente novamente!");
					}
				}else {
					p.sendMessage("§cUse: /login [senha]");
				}
			}else {
				p.sendMessage("§cVocê já está logado!");
			}
		}
		return false;
	}
	
}