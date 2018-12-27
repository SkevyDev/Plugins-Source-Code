package me.skevydev.com.snickblocker.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import me.skevydev.com.snickblocker.Main;
import me.skevydev.com.snickblocker.utils.NickManager;

public class PlayerPreLogin implements Listener {

	@EventHandler
	private void onPreLogin(AsyncPlayerPreLoginEvent e) {
		NickManager nick = Main.getInstance().getNickManager();
		if(nick.hasNick(e.getName())) {
			e.disallow(Result.KICK_OTHER, nick.getKickMessage());
		}
	}
	
}