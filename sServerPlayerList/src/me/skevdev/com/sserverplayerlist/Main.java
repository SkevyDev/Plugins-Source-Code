package me.skevdev.com.sserverplayerlist;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevdev.com.sserverplayerlist.utils.ServerPlayerList;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§aPlugin §fsServerPlayerList §ahabilitado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§aDeveloper: §fSkevyDev");
		new ServerPlayerList().setup();
	}

}