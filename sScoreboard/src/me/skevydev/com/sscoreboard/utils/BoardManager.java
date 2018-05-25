package me.skevydev.com.sscoreboard.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import me.skevydev.com.sscoreboard.Main;

public class BoardManager {

	public static BukkitTask task = null;
	
	public void send(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("scoreboard", "dummy");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("§c§lSCOREBOARD");
		
		obj.getScore(Bukkit.getOfflinePlayer("§c")).setScore(2);
		obj.getScore(Bukkit.getOfflinePlayer("§f")).setScore(1);
		
		board.registerNewTeam("nick").addPlayer(Bukkit.getOfflinePlayer("§c"));
		board.registerNewTeam("horas").addPlayer(Bukkit.getOfflinePlayer("§f"));
		
		board.getTeam("nick").setPrefix("§cNick: ");
		board.getTeam("nick").setSuffix("§f" + p.getName());
		
		board.getTeam("horas").setPrefix("§cHoras: ");
		board.getTeam("horas").setSuffix("§f00:00:00");
		
		task = new BukkitRunnable() {
			int i = 1;
			@Override
			public void run() {
				switch(i) {
				case 1: obj.setDisplayName("§f§lS§c§lCOREBOARD"); i++; break;
				case 2: obj.setDisplayName("§c§lS§f§lC§c§lOREBOARD"); i++; break;
				case 3: obj.setDisplayName("§c§lSC§f§lO§c§lREBOARD"); i++; break;
				case 4: obj.setDisplayName("§c§lSCO§f§lR§c§lEBOARD"); i++; break;
				case 5: obj.setDisplayName("§c§lSCOR§f§lE§c§lBOARD"); i++; break;
				case 6: obj.setDisplayName("§c§lSCORE§f§lB§c§lOARD"); i++; break;
				case 7: obj.setDisplayName("§c§lSCOREB§f§lO§c§lARD"); i++; break;
				case 8: obj.setDisplayName("§c§lSCOREBO§f§lA§c§lRD"); i++; break;
				case 9: obj.setDisplayName("§c§lSCOREBOA§f§lR§c§lD"); i++; break;
				case 10: obj.setDisplayName("§c§lSCOREBOAR§f§lD"); i++; break;
				case 11: obj.setDisplayName("§c§lS"); i++; break;
				case 12: obj.setDisplayName("§c§lSC"); i++; break;
				case 13: obj.setDisplayName("§c§lSCO"); i++; break;
				case 14: obj.setDisplayName("§c§lSCOR"); i++; break;
				case 15: obj.setDisplayName("§c§lSCORE"); i++; break;
				case 16: obj.setDisplayName("§c§lSCOREB"); i++; break;
				case 17: obj.setDisplayName("§c§lSCOREBO"); i++; break;
				case 18: obj.setDisplayName("§c§lSCOREBOA"); i++; break;
				case 19: obj.setDisplayName("§c§lSCOREBOAR"); i++; break;
				case 20: obj.setDisplayName("§c§lSCORE§f§lBOARD"); i++; break;
				default: i = 1;
				}
				board.getTeam("horas").setSuffix("§f" + getHoras());
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 20, 20);
		p.setScoreboard(board);
	}
	
	Scoreboard getScoreboard(Player p) {
		return Bukkit.getScoreboardManager().getNewScoreboard();
	}
	
	String getHoras() {
		Calendar cal = Calendar.getInstance();
		return new SimpleDateFormat("HH:mm:ss").format(cal.getTime());
	}
	
	public void clear(Player p) {
		getScoreboard(p).clearSlot(DisplaySlot.SIDEBAR);
		p.setScoreboard(getScoreboard(p));
		if(task != null) {
			task.cancel();
		}
	}
	
}
