package me.skevydev.com.scommandblocker;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.com.scommandblocker.events.PlayerExecuteCommand;
import me.skevydev.com.scommandblocker.utils.CommandManager;

public class Main extends JavaPlugin {

	private CommandManager commandManager;
	
	@Override
	public void onEnable() {
		if(!new File(this.getDataFolder(), "config.yml").exists()) {
			this.saveDefaultConfig();
		}
		commandManager = new CommandManager();
		Bukkit.getPluginManager().registerEvents(new PlayerExecuteCommand(), this);
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§aPlugin §fsCommandBlocker §ahabilitado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§aDeveloper: §fSkevyDev");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
	public static Main getInstance() {
		return Main.getPlugin(Main.class);
	}
	
	public CommandManager getCommandManager() {
		return commandManager;
	}
	
}