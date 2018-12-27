package me.skevydev.com.snickblocker.utils;

import java.util.List;

import me.skevydev.com.snickblocker.Main;

public class NickManager {

	private Main main;
	private List<String> nicks;
	private String kickMessage;
	
	public NickManager() {
		main = Main.getInstance();
		nicks = main.getConfig().getStringList("Nicks");
		for(String message : main.getConfig().getStringList("Kick-Message")) {
			kickMessage += message + "\n";
		}
	}
	
	public boolean hasNick(String nick) {
		return nicks.contains(nick);
	}
	
	public String getKickMessage() {
		return kickMessage.replace("&", "§");
	}
	
}