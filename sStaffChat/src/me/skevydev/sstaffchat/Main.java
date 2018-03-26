package me.skevydev.sstaffchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.sstaffchat.commands.ScCommand;
import me.skevydev.sstaffchat.commands.ScpCommand;
import me.skevydev.sstaffchat.commands.StaffChatCommand;
import me.skevydev.sstaffchat.events.SpeakStaff;

public class Main extends JavaPlugin{
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin sStaffChat Habilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
		setupCommands();
		setupEvents();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Plugin sAddress Desabilitado!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Author: SkevyDev");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Website: github.com/skevydev");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
	public void setupCommands() {
		getCommand("staffchat").setExecutor(new StaffChatCommand());
		getCommand("sc").setExecutor(new ScCommand());
		getCommand("scp").setExecutor(new ScpCommand());
	}
	
	public void setupEvents() {
		Bukkit.getPluginManager().registerEvents(new SpeakStaff(), this);
	}

}
