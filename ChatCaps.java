package me.skevydev.com.snocapslock.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatCaps implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		for(char a : e.getMessage().toCharArray()) {
			if(count == 0) {
				sb.append(String.valueOf(a).toUpperCase());
			}else {
				sb.append(String.valueOf(a).toLowerCase());
			}
			count++;
		}
		
		e.setFormat("f" + p.getName() + "7" + sb.toString());
	}
	
}