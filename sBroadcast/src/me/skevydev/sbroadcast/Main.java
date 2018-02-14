package me.skevydev.sbroadcast;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import comandos.BroadcastCommand;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin AshBroadcast Enabled");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Website: https://dev.bukkit.org/members/SkevyDev");
		Bukkit.getConsoleSender().sendMessage("");
		registrarComandos();
		if(!new File(getDataFolder(), "config.yml").exists()){
			saveDefaultConfig();
		}
	}
	
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin AshBroadcast Desabilitado!");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
	public void registrarComandos(){
		getCommand("broadcast").setExecutor(new BroadcastCommand());
		getCommand("bc").setExecutor(new BroadcastCommand());
	}

}