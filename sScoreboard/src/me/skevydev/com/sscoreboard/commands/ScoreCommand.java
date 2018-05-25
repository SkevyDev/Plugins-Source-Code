package me.skevydev.com.sscoreboard.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.skevydev.com.sscoreboard.utils.BoardManager;

public class ScoreCommand implements CommandExecutor {

	private ArrayList<Player> semScore = new ArrayList<>(); 
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("score")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§cComando especifico para players!");
				return true;
			}
			Player p = (Player) sender;
			if(args.length >= 0) {
				if(semScore.contains(p)) {
					semScore.remove(p);
					new BoardManager().send(p);
					p.sendMessage("§a§lBOARD: §fScoreboard ativada com sucesso!");
				}else {
					semScore.add(p);
					new BoardManager().clear(p);
					p.sendMessage("§c§lBOARD: §fScoreboard desativada com sucesso!");
				}
			}
		}
		return false;
	}
	
}