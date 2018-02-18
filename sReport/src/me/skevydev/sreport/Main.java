package me.skevydev.sreport;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import comandos.ReportCommand;
import eventos.Join;

public class Main extends JavaPlugin {
	
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin sReport Habilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
		registrarComandos();
		registrarEventos();
		if(!new File(getDataFolder(), "config.yml").exists()){
			saveDefaultConfig();
			Bukkit.getConsoleSender().sendMessage("§a§lREPORT §fConfig criada com sucesso!");
		}
	}
	
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin sReport Desabilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
	public void registrarComandos(){
		getCommand("report").setExecutor(new ReportCommand());
	}
	
	public void registrarEventos(){
		Bukkit.getPluginManager().registerEvents(new Join(), this);
	}
	
}
