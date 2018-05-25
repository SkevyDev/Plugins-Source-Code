package me.skevydev.com.sscoreboard.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.skevydev.com.sscoreboard.utils.BoardManager;

public class QuitScore implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if(BoardManager.task != null) {
			BoardManager.task.cancel();
		}
	}
	
}