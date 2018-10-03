package me.skevydev.com.santiproxy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.com.santiproxy.commands.AntiProxyCommand;
import me.skevydev.com.santiproxy.events.JoinEvent;
import me.skevydev.com.santiproxy.utils.ProxyChecker;

public class Main extends JavaPlugin {

	private ProxyChecker proxyChecker;
	
	@Override
	public void onEnable() {
		proxyChecker = new ProxyChecker();
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§aPlugin §fsAntiProxy §aHabilitado!");
		Bukkit.getConsoleSender().sendMessage("§aDeveloper: §fSkevyDev");
		Bukkit.getConsoleSender().sendMessage("");
		setupEvents();
	}
	
	void setupCommands() {
		getCommand("antiproxy").setExecutor(new AntiProxyCommand());
	}
	
	void setupEvents() { 
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this); 
	}
	
	public static Main getInstance() {
		return Main.getPlugin(Main.class);
	}
	
	public ProxyChecker getProxyChecker() {
		return proxyChecker;
	}
	
}