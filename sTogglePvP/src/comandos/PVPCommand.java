package comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PVPCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(label.equalsIgnoreCase("pvp")){
			if(sender.hasPermission("stogglepvp.command.pvp")){
				if(args.length == 0){
					sender.sendMessage("§6§lPVP §fDigite: /pvp [on, off]");
					return true;
				}
				
				if(args.length == 1){
					
					if(!args[0].equalsIgnoreCase("on") && !args[0].equalsIgnoreCase("off")){
						sender.sendMessage("§6§lPVP §fDigite: /pvp [on, off]");
						return true;
					}
					
					if(args[0].equalsIgnoreCase("on")){
						if(Bukkit.getServer().getWorld("world").getPVP() == true){
							sender.sendMessage("§c§lPVP §fO pvp já está ativado!");
						}else{
							Bukkit.getServer().getWorld("world").setPVP(true);
							sender.sendMessage("§a§lPVP §fVocê ativou o pvp!");
							Bukkit.broadcastMessage("§a§lPVP §fPvp ativado por: §f" + sender.getName());
						}
					}else if(args[0].equalsIgnoreCase("off")){
						if(Bukkit.getServer().getWorld("world").getPVP() == false){
							sender.sendMessage("§c§lPVP §fO pvp já está desativado!");
						}else{
							Bukkit.getServer().getWorld("world").setPVP(false);
							sender.sendMessage("§c§lPVP §fVocê desativou o pvp!");
							Bukkit.broadcastMessage("§c§lPVP §fPvp desativado por: §f" + sender.getName());
						}
					}
				}else if(args.length > 1){
					sender.sendMessage("§6§lPVP §fDigite: /pvp [on, off]");
				}
				
			}else{
				sender.sendMessage("§c§lPVP §fVocê não tem a permissão: §cstogglepvpd.command.pvp§f, para executar esse comando!");
			}
		}
		return false;
	}

}
