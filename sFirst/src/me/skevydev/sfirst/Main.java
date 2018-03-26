package me.skevydev.sfirst;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.sfirst.commands.DefinirFirstCommand;
import me.skevydev.sfirst.commands.FirstCommand;
import me.skevydev.sfirst.events.JoinEvent;

public class Main extends JavaPlugin{
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin sFirst Habilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
		setupCommands();
		setupEvents();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin sFirst Desabilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
	public void setupCommands() {
		getCommand("first").setExecutor(new FirstCommand());
		getCommand("definirfirst").setExecutor(new DefinirFirstCommand());
	}
	
	public void setupEvents() {
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
	}

}
