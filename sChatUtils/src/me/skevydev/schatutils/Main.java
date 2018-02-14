package me.skevydev.schatutils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import comandos.ChatCommand;
import eventos.ChatEvent;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin sChatUtils Habilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
		registrarComandos();
		registrarEventos();
	}
	
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin sChatUtils Desabilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
		HandlerList.unregisterAll((JavaPlugin)this);
	}
		
	public void registrarComandos(){
		getCommand("chat").setExecutor(new ChatCommand());
	}
	
	public void registrarEventos(){
		Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
	}
}
