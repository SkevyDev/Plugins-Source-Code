package me.skevydev.com.sscoreboard.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.skevydev.com.sscoreboard.utils.BoardManager;

public class JoinScore implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		new BoardManager().send(e.getPlayer());
	}
	
}