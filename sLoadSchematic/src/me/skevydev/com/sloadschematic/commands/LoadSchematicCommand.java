package me.skevydev.com.sloadschematic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.skevydev.com.sloadschematic.Main;

public class LoadSchematicCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("loadschematic")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§cVocê não pode executar esse comando no console.");
				return true;
			}
			Player p = (Player) sender;
			if(p.hasPermission("sloadschematic.admin")) {
				if(args.length == 0) {
					p.sendMessage("§cUse: /loadschematic [name]");
				}else if(args.length == 1) {
					try {
						Main.getInstance().getSchematic().loadByName(p, args[0]);
						p.sendMessage("§aSchematic §f" + args[0] + " §acarregado com sucesso!");
					}catch(NullPointerException e) {
						p.sendMessage("§cNenhuma schematic encontrada com esse nome.");
					}
				}else {
					p.sendMessage("§cUse: /loadschematic [name]");
				}
			}else {
				p.sendMessage("§cVocê não tem permissão para executar esse comando.");
			}
		}
		return false;
	}
	
}