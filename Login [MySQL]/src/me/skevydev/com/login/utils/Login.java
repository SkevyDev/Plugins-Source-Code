package me.skevydev.com.login.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

import me.skevydev.com.login.connection.ConnectionManager;

public class Login extends ConnectionManager {

	private Player p;
	private String password;
	
	public Login(Player p) {
		this.p = p;
		this.password = null;
	}
	
	public Login(Player p, String password) {
		this.p = p;
		this.password = password;
	}
	
	public String getPassword() {
		if(isRegistered()) {
			try{
				PreparedStatement stm = c.prepareStatement("SELECT password FROM login WHERE uuid = ?");
				stm.setString(1, getPlayerUUID());
				ResultSet rs = stm.executeQuery();
				if(rs.next()) password = rs.getString("password");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Player getPlayer() {
		return p;
	}
	
	public void setPlayer(Player p) {
		this.p = p;
	}
	
	public String getPlayerUUID() {
		return p.getUniqueId().toString();
	}
	
	public boolean isRegistered() {
		try{
			PreparedStatement stm = c.prepareStatement("SELECT * FROM login WHERE uuid = ?");
			stm.setString(1, getPlayerUUID());
			ResultSet rs = stm.executeQuery();
			return rs.next();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void setup() {
		try{
			PreparedStatement stm = c.prepareStatement("INSERT INTO login(uuid, password) VALUES(?, ?)");
			stm.setString(1, getPlayerUUID());
			stm.setString(2, getPassword());
			stm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}