package me.skevydev.smessagejson;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import comandos.RawCommand;

public class Main extends JavaPlugin {

	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin sMessageJSON Habilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
		registrarComandos();
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin sMessageJSON Desabilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
	}

	public void registrarComandos() {
		getCommand("modo").setExecutor(new RawCommand());
	}

}
