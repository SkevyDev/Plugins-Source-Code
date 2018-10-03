package me.skevydev.com.santiproxy.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import me.skevydev.com.santiproxy.Main;

public class JoinEvent implements Listener {

	@EventHandler
	void onAsyncJoin(AsyncPlayerPreLoginEvent e) {
		if(Main.getInstance().getProxyChecker().isProxy(e.getAddress().getHostAddress())) {
			Main.getInstance().getProxyChecker().setTotalProxy(Main.getInstance().getProxyChecker().getTotalProxy() + 1);
			e.disallow(Result.KICK_OTHER, "§c[AntiProxy]\n\n§7Você não pode entrar no servidor com proxy.\n§cErro? Entre em contato conosco!\n§fDiscord: §fDiscord#0001");
		}
	}
	
}