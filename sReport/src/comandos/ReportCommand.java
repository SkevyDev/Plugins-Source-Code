package comandos;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utils.Config;
import utils.Cooldown;

public class ReportCommand implements CommandExecutor{
	
	Cooldown cd = new Cooldown();
	Config cf = new Config();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("report")){
			if(!(sender instanceof Player)){
				sender.sendMessage("§c§lREPORT §fVocê deve ser um jogador!");
				return true;
			}
			Player p = (Player) sender;
			if(args.length == 0){
				p.sendMessage("§6§lREPORT §fDigite: /report [nick] [motivo]");
				return true;
			}
			
			if(args.length == 1){
				p.sendMessage("§6§lREPORT §fDigite: /report [nick] [motivo]");
				return true;
			}
			
			if(args.length >= 2){
				if(cd.reportado.contains(p.getName())){
					p.sendMessage("§c§lREPORT §fAguarde para reportar novamente!");
					return true;
				}
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target == null){
					p.sendMessage("§c§lREPORT §fJogador não encontrado!");
				}else{
				StringBuilder sb = new StringBuilder();
				for(int i = 1; i < args.length; i++){
					sb.append(args[i]).append(" ");
				}
				String motivo = sb.toString();
				cf.addReport(p);
				for(Player staffs : Bukkit.getOnlinePlayers()){
					if(staffs.hasPermission("sreport.ver")){
						staffs.playSound(staffs.getLocation(), Sound.LEVEL_UP, 4F, 4F);
						staffs.sendMessage("§a§m----------------------------------");
						staffs.sendMessage("               §a§lREPORT");
						staffs.sendMessage("§a§m----------------------------------");
						staffs.sendMessage("§a§lJOGADOR: §f" + target.getName());
						staffs.sendMessage("§a§lMOTIVO: §f" + "\"" + motivo + "\"");
						staffs.sendMessage("§a§lTOTAL DE REPORT'S: §f" + cf.getReport(target.getName()));
						staffs.sendMessage("§a§m----------------------------------");
						}
					}
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 4F, 4F);
					p.sendMessage("§a§m----------------------------------");
					p.sendMessage("§a§lREPORT §fReportado com sucesso!");
					p.sendMessage("§a§m----------------------------------");
					p.sendMessage("§a§lJOGADOR: §f" + target.getName());
					p.sendMessage("§a§lMOTIVO: §f" + "\"" + motivo + "\"");
					p.sendMessage("§a§m----------------------------------");
					cd.reportado.add(p.getName());
					p.sendMessage("§c§lREPORT §fAgora aguarde 2 minutos para reportar novamente!");
					cd.getCooldown(p);
				}
			}
			
		}
		return false;
	}

}
