package me.skevydev.smanutencao;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import comandos.ManutencaoCommand;
import eventos.LoginEvent;
import eventos.MotdEvent;

public class Main extends JavaPlugin {
	
	public static Main instance;
	public static Main getInstance(){
		return instance;
	}
	
	public void onEnable(){
		instance = this;
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin sManutencao Habilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
		registrarComandos();
		registrarEventos();
		if(!new File(getDataFolder(), "config.yml").exists()){
			saveDefaultConfig();
			Bukkit.getConsoleSender().sendMessage("§a§lCONFIG §fConfig criada com sucesso!");
		}
	}
	
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin sManutencao Desabilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
	public void registrarComandos(){
		getCommand("manutencao").setExecutor(new ManutencaoCommand());
	}
	
	public void registrarEventos(){
		Bukkit.getPluginManager().registerEvents(new LoginEvent(), this);
		Bukkit.getPluginManager().registerEvents(new MotdEvent(), this);
	}

}
