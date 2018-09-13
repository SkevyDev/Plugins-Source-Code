package me.skevydev.com.login.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import me.skevydev.com.login.Main;

public class ConnectionManager {

	protected static Connection c;
	private String user, password, host, database;
	private int port;
	
	public void open() {
		try {
			user = Main.getInstance().getMysqlConfig().getConfig().getString("MySQL.user");
			password = Main.getInstance().getMysqlConfig().getConfig().getString("MySQL.password");
			host = Main.getInstance().getMysqlConfig().getConfig().getString("MySQL.host");
			port = Main.getInstance().getMysqlConfig().getConfig().getInt("MySQL.port");
			database = Main.getInstance().getMysqlConfig().getConfig().getString("MySQL.database");
			c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
			Bukkit.getConsoleSender().sendMessage(c != null ? "§a§lMYSQL: §fConexão estabelecida com sucesso!" 
					: "§c§lMYSQL: §fFalha ao tentar conectar!");
		}catch(SQLException e) {
			e.printStackTrace();
			Bukkit.getConsoleSender().sendMessage("§fPor esse motivo o plugin está sendo desativado...");
			Main.getInstance().getPluginLoader().disablePlugin(Main.getInstance());
		}
	}
	
	public void close() {
		if(c != null) {
			try {
				c.close();
				Bukkit.getConsoleSender().sendMessage("§c§lMYSQL §fConexão fechada com sucesso!");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createTable() {
		try(PreparedStatement stm = c.prepareStatement("CREATE TABLE IF NOT EXISTS login(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, uuid VARCHAR(36), password VARCHAR(16))")){
			stm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}