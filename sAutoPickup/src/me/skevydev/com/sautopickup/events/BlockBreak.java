package me.skevydev.com.sautopickup.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

	@EventHandler
	private void onBlockBreak(BlockBreakEvent e) {
		e.getPlayer().giveExp(e.getExpToDrop());
		e.getBlock().getDrops().forEach(a -> e.getPlayer().getInventory().addItem(a));
		e.getBlock().setType(Material.AIR);
		e.setCancelled(true);
	}
	
}