package me.skevydev.com.snocapslock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.com.snocapslock.events.ChatCaps;

public class Main extends JavaPlugin {

	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§a§lNO-CAPS: §fPlugin habilitado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§aDeveloper: §fSkevyDev");
		setupEvents();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§c§lNO-CAPS: §fPlugin desabilitado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§cDeveloper: §fSkevyDev");
	}
	
	void setupEvents() {
		Bukkit.getPluginManager().registerEvents(new ChatCaps(), this);
	}
	
}