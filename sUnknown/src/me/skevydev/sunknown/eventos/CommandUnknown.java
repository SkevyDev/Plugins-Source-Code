package me.skevydev.sunknown.eventos;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

public class CommandUnknown implements Listener{
	
	@EventHandler
	public void onCommandUnknown(PlayerCommandPreprocessEvent e) {
		if(e.isCancelled()) {
			return;
		}
		
		Player p = e.getPlayer();
		String msg = e.getMessage().split(" ")[0];
		HelpTopic topico = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
		
		if(topico == null) {
			e.setCancelled(true);
			
			p.sendMessage("§c§lERROR §fComando não encontrando!");
		}
		
	}

}
