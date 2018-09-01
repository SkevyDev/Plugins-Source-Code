package me.skevydev.com.sautopickup;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.com.sautopickup.events.BlockBreak;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§aPlugin §fsAutoPickup §ahabilitado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§aDeveloper: §fSkevyDev");
		Bukkit.getConsoleSender().sendMessage("");
		setupEvents();
	}
	
	private void setupEvents() {
		Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
	}
	
}