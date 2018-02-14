package comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utils.ChatStatus;

public class ChatCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(label.equalsIgnoreCase("chat")){
			if(sender.hasPermission("schatutils.command.chat")){
				if(args.length == 0){
					sender.sendMessage("");
					sender.sendMessage("§6§lCHAT §fUse: /chat [on, off, clear, player]");
					sender.sendMessage("§6on = §fHabilitar o chat");
					sender.sendMessage("§6off = §fDesabilitar o chat");
					sender.sendMessage("§6clear = §fLimpar o chat global");
					sender.sendMessage("§6player = §fLimpar o chat de um player");
					sender.sendMessage("");
					return true;
				}
				
				if(args.length > 2){
					sender.sendMessage("");
					sender.sendMessage("§6§lCHAT §fUse: /chat [on, off, clear, player]");
					sender.sendMessage("§6on = §fHabilitar o chat");
					sender.sendMessage("§6off = §fDesabilitar o chat");
					sender.sendMessage("§6clear = §fLimpar o chat global");
					sender.sendMessage("§6player = §fLimpar o chat de um player");
					sender.sendMessage("");
					return true;
				}
				
				if(!args[0].equalsIgnoreCase("on") && !args[0].equalsIgnoreCase("off") && !args[0].equalsIgnoreCase("clear") && !args[0].equalsIgnoreCase("player")){
					sender.sendMessage("");
					sender.sendMessage("§6§lCHAT §fUse: /chat [on, off, clear, player]");
					sender.sendMessage("§6on = §fHabilitar o chat");
					sender.sendMessage("§6off = §fDesabilitar o chat");
					sender.sendMessage("§6clear = §fLimpar o chat global");
					sender.sendMessage("§6player = §fLimpar o chat de um player");
					sender.sendMessage("");
					return true;
				}
				
					if(args[0].equalsIgnoreCase("on")){
						if(ChatStatus.chatStatus == true){
							sender.sendMessage("");
							sender.sendMessage("§c§lCHAT §fO chat já está ativado!");
							sender.sendMessage("");
						}else{
							ChatStatus.chatStatus = true;
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage("§a§lCHAT §f>> §aChat do servidor habilitado por: §f" + sender.getName());
							Bukkit.broadcastMessage("");
							sender.sendMessage("");
							sender.sendMessage("§a§lCHAT §fHabilitado com sucesso!");
							sender.sendMessage("");
						}
					}else if(args[0].equalsIgnoreCase("off")){
						if(ChatStatus.chatStatus == false){
							sender.sendMessage("");
							sender.sendMessage("§c§lCHAT §fO chat já está desativado!");
							sender.sendMessage("");
						}else{
							ChatStatus.chatStatus = false;
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage("§c§lCHAT §f>> §cChat do servidor desabilitado por: §f" + sender.getName());
							Bukkit.broadcastMessage("");
							sender.sendMessage("");
							sender.sendMessage("§c§lCHAT §fDesabilitado com sucesso!");
							sender.sendMessage("");
						}
					}else if(args[0].equalsIgnoreCase("clear")){
						for(int i = 100; i > 0; i--){
							Bukkit.broadcastMessage("");
						}
						Bukkit.broadcastMessage("§a§lCHAT §f>> §aChat limpado por: §f" + sender.getName());
						sender.sendMessage("");
						sender.sendMessage("§a§lCHAT §flimpado com sucesso!");
						sender.sendMessage("");
					}else if(args[0].equalsIgnoreCase("player")){
						if(args.length == 1){
							sender.sendMessage("");
							sender.sendMessage("§6§lCHAT §fUse: /chat player [player]");
							sender.sendMessage("");
							return true;
						}
							Player target = Bukkit.getServer().getPlayer(args[1]);
							if(target == null){
								sender.sendMessage("");
								sender.sendMessage("§c§lCHAT §fJogador não encontrado!");
								sender.sendMessage("");
							}else{
								for(int i = 100; i > 0; i--){
									target.sendMessage("");
								}
								target.sendMessage("");
								target.sendMessage("§a§lCHAT §f>> §aSeu chat foi limpado por: §f" + sender.getName());
								target.sendMessage("");
								sender.sendMessage("");
								sender.sendMessage("§a§lCHAT §fChat do player §a" + target.getName() + " §flimpado com sucesso!");
								sender.sendMessage("");
							}
					}
			}else{
				sender.sendMessage("");
				sender.sendMessage("§c§lCHAT §fVocê não tem a permissão: §cschatutils.command.chat, §fpara executar esse comando!");
				sender.sendMessage("");
			}
		}
		return false;
	}

}
