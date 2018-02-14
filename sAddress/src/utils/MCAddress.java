package utils;

import org.bukkit.entity.Player;

public class MCAddress {
	
	public static String getAddress(Player p){
		return p.getAddress().getHostString();
	}

}
