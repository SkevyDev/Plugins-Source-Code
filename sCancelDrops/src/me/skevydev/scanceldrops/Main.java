package me.skevydev.scanceldrops;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import eventos.DropEvent;

public class Main extends JavaPlugin {
	
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin sCancelDrop Habilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
		registrarEventos();
	}
	
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin sCancelDrop Desabilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
	public void registrarEventos(){
		Bukkit.getPluginManager().registerEvents(new DropEvent(), this);
	}

}
