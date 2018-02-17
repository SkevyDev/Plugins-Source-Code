package utils;

import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingValue {
	
	public static int getPing(Player p){
		return ((CraftPlayer)p).getHandle().ping;
	}

}
