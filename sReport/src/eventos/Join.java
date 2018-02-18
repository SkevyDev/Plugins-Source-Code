package eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.sreport.Main;

public class Join implements Listener{
	
	JavaPlugin main = (JavaPlugin) Main.getPlugin(Main.class);
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if (!main.getConfig().contains("Reportados." + p.getName())) {
		main.getConfig().set("Reportados." + p.getName() + ".Total de Report", 0);
		main.saveConfig();
		}
	}

}
