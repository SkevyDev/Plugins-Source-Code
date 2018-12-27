package me.skevydev.com.scommandblocker.utils;

import java.util.List;

import me.skevydev.com.scommandblocker.Main;

public class CommandManager {

	private Main main;
	private List<String> commands;
	private String errorMessage;
	
	public CommandManager() {
		main = Main.getInstance();
		commands = main.getConfig().getStringList("CommandBlocker.Commands");
		for(String message : main.getConfig().getStringList("CommandBlocker.Error-Message")) {
			errorMessage += message + "\n";
		}
	}
	
	public boolean hasCommand(String command) {
		return commands.contains(command.replace("/", ""));
	}
	
	public String getErrorMessage() {
		return errorMessage.replace("&", "§");
	}
	
}