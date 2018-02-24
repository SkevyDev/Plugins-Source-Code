package comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.skevydev.smanutencao.Main;

public class ManutencaoCommand implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(label.equalsIgnoreCase("manutencao")){
			if(sender.hasPermission("smanutencao.command.manutencao")){
				if(args.length == 0){
					sender.sendMessage("§6§lMANUTENÇÃO §fDigite: /manutencao [on, off]");
					return true;
				}
				
				if(args.length == 1){
					
					if(!args[0].equalsIgnoreCase("on") && !args[0].equalsIgnoreCase("off")){
						sender.sendMessage("§6§lMANUTENÇÃO §fDigite: /manutencao [on, off]");
						return true;
					}
					
					if(args[0].equalsIgnoreCase("on")){
						if(Main.getInstance().getConfig().getBoolean("Manutencao." + "Status") == true){
							sender.sendMessage("§c§lMANUTENÇÃO §fParece que a manutenção já está habilitada!");
						}else{
							Main.getInstance().getConfig().set("Manutencao." + "Status", true);
							Main.getInstance().saveConfig();
							sender.sendMessage("§c§lMANUTENÇÃO §fManutenção habilitada com sucesso!");
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage("§c§lMANUTENÇÃO >> §fManutenção habilitada!");
							Bukkit.broadcastMessage("§cTodos players serão kickados em 15s.");
							Bukkit.broadcastMessage("");
							for(Player onlines : Bukkit.getOnlinePlayers()){
								if(!onlines.hasPermission("smanutencao.command.manutencao")){
									Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
										
										@Override
										public void run() {
											onlines.kickPlayer("§c§lMANUTENÇÃO" + "\n" + "\n" + "      §fNo momento estamos em manutenção." + "\n" + "§fTente novamente mais tarde!");
										}
									}, 20 * 15);
								}
								Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
									
									@Override
									public void run() {
										Bukkit.broadcastMessage("§c§lMANUTENÇÃO §fKickados com sucesso!");
									}
								}, 20 * 15);
							}
						}
					}else if(args[0].equalsIgnoreCase("off")){
						if(Main.getInstance().getConfig().getBoolean("Manutencao." + "Status") == false){
							sender.sendMessage("§c§lMANUTENÇÃO §fParece que a manutenção já está desabilitada!");
						}else{
							Main.getInstance().getConfig().set("Manutencao." + "Status", false);
							Main.getInstance().saveConfig();
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage("§c§lMANUTENÇÃO >> §fManutenção desabilitada!");
							Bukkit.broadcastMessage("");
						}
					}
				}else if(args.length > 1){
					sender.sendMessage("§6§lMANUTENÇÃO §fDigite: /manutencao [on, off]");
					return true;
				}
			}else{
				sender.sendMessage("§c§lMANUTENÇÃO §fVocê não tem a permissão: §csmanutencao.command.manutencao, §fpara executar esse comando!");
			}
		}
		return false;
	}

}
