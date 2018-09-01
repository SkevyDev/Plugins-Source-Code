package me.skevydev.com.stabcustom;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.com.stabcustom.events.JoinTab;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§aPlugin §fsTabCustom §ahabilitado com suceso!");
		Bukkit.getConsoleSender().sendMessage("§aDeveloper: §fSkevyDev");
		Bukkit.getConsoleSender().sendMessage("");
		setupEvents();
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§cPlugin §fsTabCustom §cdesabilitado com suceso!");
		Bukkit.getConsoleSender().sendMessage("§cDeveloper: §fSkevyDev");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
	private void setupEvents() {
		Bukkit.getPluginManager().registerEvents(new JoinTab(), this);
	}
	
}