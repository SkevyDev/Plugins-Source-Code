package utils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.sreport.Main;

public class Config {
	
	JavaPlugin main = (JavaPlugin) Main.getPlugin(Main.class);
	
	public void addReport(Player p){
		main.getConfig().set("Reportados." + p.getName() + ".Total de Report", main.getConfig().getInt("Reportados." + p.getName() + ".Total de Report") + 1);
		main.saveConfig();
	}
	
	public int getReport(String p){
		return main.getConfig().getInt("Reportados." + p + ".Total de Report");
	}
}
