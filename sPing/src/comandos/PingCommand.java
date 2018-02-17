package comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utils.PingStatus;
import utils.PingValue;

public class PingCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("ping")){
				if(!(sender instanceof Player)){
					sender.sendMessage("§c§lPING §fVocê não é um player!");
					return true;
				}
				if(args.length == 0){
					sender.sendMessage("§a§lPING §fSeu ping é de: §a" + PingValue.getPing((Player) sender) + " ms");
					sender.sendMessage("§7Status: " + PingStatus.getPingStatus((Player) sender));
				}else if(args.length == 1){
					if(sender.hasPermission("sping.command.ping")){
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if(target == null){
						sender.sendMessage("§c§lPING §fJogador não encontrado!");
					}else{
						sender.sendMessage("§a§lPING §fPing do jogador §a" + target.getName() + " §fé de: §a" + PingValue.getPing((Player) sender) + " ms");
						sender.sendMessage("§7Status: " + PingStatus.getPingStatus((Player) target));
						}
					}else{
						sender.sendMessage("§c§lPING §fVocê não tem a permissão: §csping.command.ping, §fpara usar esse comando!");
					}
				}else if(args.length > 1){
					sender.sendMessage("");
					sender.sendMessage("§6§lPING");
					sender.sendMessage("");
					sender.sendMessage("§6/ping - §fVer seu ping");
					sender.sendMessage("§6/ping [player] - §fVer o ping de um player");
					sender.sendMessage("");
				}
		}
		return false;
	}
	
}
