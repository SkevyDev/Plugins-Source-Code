package me.skevydev.com.sloadschematic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.com.sloadschematic.commands.LoadSchematicCommand;
import me.skevydev.com.sloadschematic.utils.Schematic;

public class Main extends JavaPlugin {

	private Schematic schematic;
	
	@Override
	public void onEnable() {
		schematic = new Schematic();
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§aPlugin §fsLoadSchematic §ahabilitado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§aDeveloper: §fSkevyDev");
		Bukkit.getConsoleSender().sendMessage("");
		setupCommands();
	}
	
	void setupCommands() {
		getCommand("loadschematic").setExecutor(new LoadSchematicCommand());
	}
	
	public static Main getInstance() {
		return Main.getPlugin(Main.class);
	}
	
	public Schematic getSchematic() {
		return schematic;
	}
	
}