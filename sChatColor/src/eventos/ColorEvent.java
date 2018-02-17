package eventos;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ColorEvent implements Listener{
	
	@EventHandler
	public void onChatColor(AsyncPlayerChatEvent e){
		String msg = e.getMessage();
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		e.setMessage(msg);
	}

}
