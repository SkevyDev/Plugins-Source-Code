package me.skevydev.sfirst.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.skevydev.sfirst.utils.Arrays;

public class JoinEvent implements Listener{
	
	@EventHandler
	public void onJoinFirst(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(Arrays.first.isEmpty()) {
			Arrays.first.add(p.getName());
		}
	}

}
