package me.skevydev.com.snickblocker;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.com.snickblocker.events.PlayerPreLogin;
import me.skevydev.com.snickblocker.utils.NickManager;

public class Main extends JavaPlugin {
	
	private NickManager nickManager;
	
	@Override
	public void onEnable() {
		if(!new File(this.getDataFolder(), "config.yml").exists()) {
			saveDefaultConfig();
		}
		nickManager = new NickManager();
		Bukkit.getPluginManager().registerEvents(new PlayerPreLogin(), this);
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§aPlugin §fsNickBlocker §ahabilitado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§aDeveloper: §fSkevyDev");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getPluginManager().registerEvents(new PlayerPreLogin(), this);
	}
	
	public static Main getInstance() {
		return Main.getPlugin(Main.class);
	}
	
	public NickManager getNickManager() {
		return nickManager;
	}
	
}