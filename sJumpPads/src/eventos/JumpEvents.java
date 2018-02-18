package eventos;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class JumpEvents implements Listener{
	
	@SuppressWarnings("all")
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Block b = p.getLocation().getBlock();
		
		if(b.getType() == Material.STONE_PLATE){
			if(p.getLocation().subtract(0D, 1D, 0D).getBlock().getType() == Material.DIAMOND_BLOCK){
				
				Vector vec = p.getLocation().getDirection().multiply(1.5D).setY(1D);
				
				p.setVelocity(vec);
				
				p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 20);
				
				p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 4F, 4F);
				
				p.setFallDistance(-999F);
			}
		}
	}

}
