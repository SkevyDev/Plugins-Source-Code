package utils;

import org.bukkit.entity.Player;

public class PingStatus {

	public static String getPingStatus(Player p){
		int ping = PingValue.getPing(p);
		if(ping <= 50){
			return "§a§lBOM";
		}
		
		if(ping <= 100){
			return "§2§lRAZOÁVEL";
		}
		
		if(ping <= 200){
			return "§c§lRUIM";
		}
		
		if(ping <= 400){
			return "§4§lMUITO RUIM";
		}
		return "§c§lPÉSSIMO";
	}
	
}
