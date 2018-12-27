package me.skevydev.com.scommandblocker.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.skevydev.com.scommandblocker.Main;
import me.skevydev.com.scommandblocker.utils.CommandManager;

public class PlayerExecuteCommand implements Listener {

	@EventHandler
	private void onCommandPreprocess(PlayerCommandPreprocessEvent e) {
		CommandManager command = Main.getInstance().getCommandManager();
		if(command.hasCommand(e.getMessage())) {
			e.getPlayer().sendMessage(command.getErrorMessage());
			e.setCancelled(true);
		}
	}
	
}