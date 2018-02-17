package eventos;

import org.bukkit.Effect;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventDamage implements Listener {

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		Entity p = e.getEntity();
		
		if(p instanceof Player){
			p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 20);
		}
		
		if(p instanceof Animals){
			p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 20);
		}
		
	}
	
}
