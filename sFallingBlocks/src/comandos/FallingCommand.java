package comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FallingCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("fallingblock")){
			if(!(sender instanceof Player)){
				sender.sendMessage("§c§lFALLING §fVocê deve ser um jogador!");
				return true;
			}
			Player p = (Player) sender;
			if(args.length == 0){
				p.sendMessage("§6§lFALLING §fDigite: /fallingblock [block id]");
				return true;
			}
			
			if(args.length == 1){
				try {
					String[] string = args[0].split(":");
					int ID = Integer.valueOf(string[0]);
					int BYTE = Integer.valueOf(string[1]);
					
					p.getWorld().spawnFallingBlock(p.getLocation(), ID, (byte) BYTE);
					p.sendMessage("§a§lFALLING §fVocê spawnou um bloco com id: §a" + ID + "§f:§a" + BYTE + "§a!");
				} catch (NumberFormatException e) {
					p.sendMessage("§c§lFALLING §fVocê deve inserir um número!");
				}
			}else if(args.length > 1){
				p.sendMessage("§6§lFALLING §fDigite: /fallingblock [block id]");
			}
		}
		return false;
	}

}
