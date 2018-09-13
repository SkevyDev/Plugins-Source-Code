package me.skevydev.com.login;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.com.login.commands.LoginCommand;
import me.skevydev.com.login.commands.RegisterCommand;
import me.skevydev.com.login.configurations.MysqlConfig;
import me.skevydev.com.login.connection.ConnectionManager;
import me.skevydev.com.login.events.Join;

public class Main extends JavaPlugin {

	private ConnectionManager connection;
	private MysqlConfig mysqlConfig;
	public ArrayList<Player> loggingIn = new ArrayList<>();
	
	@Override
	public void onEnable() {
		mysqlConfig = new MysqlConfig(this);
		connection = new ConnectionManager();
		Bukkit.getConsoleSender().sendMessage("§aPlugin de login habilitado com sucesso!");
		connection.open();
		connection.createTable();
		setupCommands();
		setupEvents();
	}
	
	@Override
	public void onDisable() {
		connection.close();
	}
	
	void setupCommands() {
		getCommand("login").setExecutor(new LoginCommand());
		getCommand("register").setExecutor(new RegisterCommand());
	}
	
	void setupEvents() {
		Bukkit.getPluginManager().registerEvents(new Join(), this);
	}
	
	public static Main getInstance() {
		return Main.getPlugin(Main.class);
	}
	
	public MysqlConfig getMysqlConfig() {
		return mysqlConfig;
	}
	
}