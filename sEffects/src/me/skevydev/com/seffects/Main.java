package me.skevydev.com.seffects;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.com.seffects.commands.EffectsCommand;
import me.skevydev.com.seffects.events.InventoryClick;
import me.skevydev.com.seffects.events.PlayerMoveEffect;
import me.skevydev.com.seffects.utils.HashManager;

public class Main extends JavaPlugin {

	public HashManager hash = new HashManager();
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§a§lEFFECTS: §fPlugin habilitado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§aDeveloper: §fSkevyDev");
		Bukkit.getConsoleSender().sendMessage("");
		registerCommands();
		registerEvents();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§c§lEFFECTS: §fPlugin desabilitado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§cDeveloper: §fSkevyDev");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
	void registerCommands() {
		getCommand("effects").setExecutor(new EffectsCommand());
	}
	
	void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new InventoryClick(), this);
		pm.registerEvents(new PlayerMoveEffect(), this);
	}
	
	public static Main getInstance() {
		return Main.getPlugin(Main.class);
	}
	
}