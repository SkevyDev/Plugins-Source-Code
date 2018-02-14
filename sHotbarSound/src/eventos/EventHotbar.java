package eventos;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class EventHotbar implements Listener{
	
	@EventHandler
	public void onHotbarSound(PlayerItemHeldEvent e){
		Player p = e.getPlayer();
		p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 4F, 4F);
	}

}
