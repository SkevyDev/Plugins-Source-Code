package me.skevydev.com.login.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.skevydev.com.login.Main;
import me.skevydev.com.login.utils.Login;

public class Join implements Listener {

	@EventHandler
	void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Login login = new Login(p);
		Main.getInstance().loggingIn.add(p);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if(Main.getInstance().loggingIn.contains(p)) {
					if(!login.isRegistered()) {
						p.sendMessage("§cRegistre-se digitando: /register [senha] [senha]");
					}else {
						p.sendMessage("§aLogue-se digitando: /login [senha]");
					}
				}
			}
		}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20 * 3);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if(Main.getInstance().loggingIn.contains(p)) {
					p.kickPlayer("Você foi kickado por demorar!");
				}
			}
		}.runTaskLater(Main.getInstance(), 20 * 15);
	}
	
	@EventHandler
	void onChat(AsyncPlayerChatEvent e) {
		if(Main.getInstance().loggingIn.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	void onProcessCommand(PlayerCommandPreprocessEvent e) {
		if(!(e.getMessage().startsWith("/register") || e.getMessage().startsWith("/login"))) {
			if(Main.getInstance().loggingIn.contains(e.getPlayer())) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	void onPickupItems(PlayerPickupItemEvent e) {
		if(Main.getInstance().loggingIn.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	void onMove(PlayerMoveEvent e) {
		if(Main.getInstance().loggingIn.contains(e.getPlayer())) {
			e.setTo(e.getFrom());
		}
	}
	
}