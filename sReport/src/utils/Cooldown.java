package utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.skevydev.sreport.Main;

public class Cooldown {
	
	public ArrayList<String> reportado = new ArrayList<>();
	
	@SuppressWarnings("all")
	public void getCooldown(Player p){
		Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
			
			@Override
			public void run() {
				if(reportado.contains(p.getName())){
					reportado.remove(p.getName());
				}
			}
		}, 20 * 120);
	}

}
