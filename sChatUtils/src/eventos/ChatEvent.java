package eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import utils.ChatStatus;

public class ChatEvent implements Listener{
	
	@EventHandler
	public void onChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(ChatStatus.chatStatus == false){
			if(p.hasPermission("schatutils.chat")){
				e.setCancelled(false);
			}else{
				e.setCancelled(true);
				p.sendMessage("");
				p.sendMessage("§c§lCHAT §fChat do servidor está desabilitado!");
				p.sendMessage("");
			}
		}else{
			e.setCancelled(false);
		}
	}

}
