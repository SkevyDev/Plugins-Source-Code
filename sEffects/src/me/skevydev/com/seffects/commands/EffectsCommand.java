package me.skevydev.com.seffects.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.skevydev.com.seffects.inventories.GuiEffects;

public class EffectsCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("effects")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§c§lEFFECTS: §fApenas players pode executar esse comando!");
				return true;
			}
			Player p = (Player) sender;
			if(args.length >= 0) {
				new GuiEffects().open(p);
			}
		}
		return false;
	}
	
}