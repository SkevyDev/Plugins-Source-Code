package eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEvent implements Listener{

	@EventHandler
	public void onCancelDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		if(e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD){
			e.setCancelled(true);
			p.sendMessage("§c§lDROP §fVocê não pode dropar esse item! §c(DIAMOND_SWORD)");
		}
		
		if(e.getItemDrop().getItemStack().getType() == Material.DIAMOND_PICKAXE){
			e.setCancelled(true);
			p.sendMessage("§c§lDROP §fVocê não pode dropar esse item! §c(DIAMOND_PICKAGE)");
		}
		
		if(e.getItemDrop().getItemStack().getType() == Material.BOW){
			e.setCancelled(true);
			p.sendMessage("§c§lDROP §fVocê não pode dropar esse item! §c(BOW)");
		}
		
		if(e.getItemDrop().getItemStack().getType() == Material.ARROW){
			e.setCancelled(true);
			p.sendMessage("§c§lDROP §fVocê não pode dropar esse item! §c(ARROW)");
		}
		
		if(e.getItemDrop().getItemStack().getType() == Material.TNT){
			e.setCancelled(true);
			p.sendMessage("§c§lDROP §fVocê não pode dropar esse item! §c(TNT)");
		}
		
	}
	
}
