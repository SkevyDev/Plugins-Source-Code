package me.skevydev.com.sscoreboard;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.com.sscoreboard.commands.ScoreCommand;
import me.skevydev.com.sscoreboard.events.JoinScore;

public class Main extends JavaPlugin {

	private static Economy economy;
	public static Economy getEconomy(){
		return economy;
	}
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§aPlugin §fsScoreboard §ahabilitado com sucesso!");
		setupCommands();
		setupEvents();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§cPlugin §fsScoreboard §cdesabilitado com sucesso!");
	}
	
	void setupCommands() {
		getCommand("score").setExecutor(new ScoreCommand());
	}
	
	void setupEvents() {
		Bukkit.getPluginManager().registerEvents(new JoinScore(), this);
	}
	
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
		if(economyProvider != null) {
			economy = economyProvider.getProvider();
		}
		return (economy != null);
	}
	
}
