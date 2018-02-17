package eventos;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdEvent implements Listener{
	
	@EventHandler
	public void onMotd(ServerListPingEvent e){
		e.setMotd("§aMotd §fDefault");
		Random rnd = new Random();
		int mtdRandom = rnd.nextInt(5);
		switch (mtdRandom) {
		case 0:
			e.setMotd(ChatColor.GREEN + "Motd 1");
			break;
		case 1:
			e.setMotd(ChatColor.RED + "Motd 2");
			break;
		case 2:
			e.setMotd(ChatColor.YELLOW + "Motd 3");
			break;
		case 3:
			e.setMotd(ChatColor.BLUE + "Motd 4");
			break;
		case 4:
			e.setMotd(ChatColor.GOLD + "Motd 5");
			break;
		}
	}

}
