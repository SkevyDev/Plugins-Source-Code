package me.skevydev.com.login.configurations;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class MysqlConfig {

	private File fMysql;
	private FileConfiguration fcMysql;
	
	public MysqlConfig(Plugin plugin) {
		if(!plugin.getDataFolder().exists()) plugin.getDataFolder().mkdirs();
		fMysql = new File(plugin.getDataFolder(), "mysql.yml");
		if(!fMysql.exists()) plugin.saveResource("mysql.yml", false);
		fcMysql = YamlConfiguration.loadConfiguration(fMysql);
	}
	
	public FileConfiguration getConfig() {
		return fcMysql;
	}
	
	public void save() {
		try {
			fcMysql.save(fMysql);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reload() {
		try {
			fcMysql.load(fMysql);
		}catch(IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	
}