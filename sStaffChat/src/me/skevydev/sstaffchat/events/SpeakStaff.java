package me.skevydev.sstaffchat.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.skevydev.sstaffchat.utils.Arrays;

public class SpeakStaff implements Listener{
	
	@EventHandler
	public void onStaffSpeak(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		if(Arrays.staffchat.contains(p.getName())) {
			for(Player staffs : Bukkit.getOnlinePlayers()) {
				if(staffs.hasPermission("sstaffchat.ver.mensagem") && Arrays.staffchat.contains(staffs.getName())) {
					e.setCancelled(true);
					staffs.sendMessage("§6§lSC §f>> §6" + p.getName() + ": §f" + msg);
				}
			}
		}
	}

}
