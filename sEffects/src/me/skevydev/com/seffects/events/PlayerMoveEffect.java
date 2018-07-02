package me.skevydev.com.seffects.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.skevydev.com.seffects.Main;

public class PlayerMoveEffect implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(Main.getInstance().hash.hasEffect(p)) {
			p.playEffect(p.getLocation(), Main.getInstance().hash.getEffect(p), 50);
		}
	}
	
}