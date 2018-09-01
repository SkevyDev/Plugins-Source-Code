package me.skevydev.com.stabcustom.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.skevydev.com.stabcustom.Main;
import me.skevydev.com.stabcustom.utils.Tab;

public class JoinTab implements Listener {

	@EventHandler
	private void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Tab tab = new Tab();
		new BukkitRunnable() {
			
			@Override
			public void run() {
				tab.send(p, "\n§a§lTESTE§f§lMC\n\n      §aBem-vindo ao server de testes, §a" + p.getName() + 
						".\n§aConectado em: §fKitPvP\n", "\n§aSeu ping: §f" + tab.getPing(p) +  "§ams\n§aOnline: §f" + 
				Bukkit.getOnlinePlayers().size() + "§a/§f" +Bukkit.getMaxPlayers() + "\n");
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 0, 20 * 3);
	}
	
}