package comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utils.MCAddress;

public class IpCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(label.equalsIgnoreCase("ip")){
			if(sender.hasPermission("saddress.command.ip")){
				if(args.length == 0){
					sender.sendMessage("");
					sender.sendMessage("§6§lADDRESS §fUse: /ip [player]");
					sender.sendMessage("");
					return true;
				}
				if(args.length == 1){
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if(target == null){
						sender.sendMessage("§c§lADDRESS §fJogador não encontrado!");
					}else{
						sender.sendMessage("§a§lADDRESS §fO ip do player §f" + target.getName() + " §fé: §a" + MCAddress.getAddress(target));
					}
				}else if(args.length > 1){
					sender.sendMessage("");
					sender.sendMessage("§6§lADDRESS §fUse: /ip [player]");
					sender.sendMessage("");
					return true;
				}
			}else{
				sender.sendMessage("§c§lADDRESS §fVocê não tem a permissão: §csaddress.command.ip, §fpara executar esse comando!");
			}
		}
		return false;
	}

}
