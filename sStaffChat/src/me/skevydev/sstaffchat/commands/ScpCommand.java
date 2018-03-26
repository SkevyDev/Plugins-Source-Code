package me.skevydev.sstaffchat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.skevydev.sstaffchat.utils.Arrays;

public class ScpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("scp")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§c§lSCP §fVocê precisa ser um player para executar este comando!");
				return true;
			}
			
			Player p = (Player) sender;
			if(p.hasPermission("sstaffchat.command.scp") || p.isOp()) {
				if(args.length == 0) {
					if(Arrays.staffchat.isEmpty()) {
						p.sendMessage("§c§lSCP §fNão há nenhum player no chat staff!");
					}else {
						int num = Arrays.staffchat.size();
						for(String all : Arrays.staffchat) {
							all = all.toString().replace("[]", "");
							p.sendMessage("§a§lSCP §fTodos players no chat staff (" + num + "): §a" + all);
						}
					}
				}else if(args.length > 0) {
					p.sendMessage("§c§lSCP §fUse: §c/scp");
					return true;
				}
			}else {
				p.sendMessage("§c§lSCP §fVocê não tem permissão para executar este comando!");
			}
		}
		return false;
	}
	
}
