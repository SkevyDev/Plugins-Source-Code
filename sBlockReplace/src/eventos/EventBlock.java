package eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import me.skevydev.sblockreplace.Main;

public class EventBlock implements Listener {
	
	@SuppressWarnings("all")
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		Block block = e.getBlock();
		Material material = block.getType();
		
		if(material == Material.DIRT){
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {
					block.setType(Material.STONE);
				}
			}, 20 * 2);
		}
		
		if(material == Material.STONE){
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {
					block.setType(Material.DIRT);
				}
			}, 20 * 2);
		}
		
		if(material == Material.DIAMOND_ORE){
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {
					block.setType(Material.GOLD_ORE);
				}
			}, 20 * 2);
		}
		
		if(material == Material.IRON_ORE){
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {
					block.setType(Material.COAL_ORE);
				}
			}, 20 * 2);
		}
		
		if(material == Material.EMERALD_ORE){
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {
					block.setType(Material.DIAMOND_ORE);
				}
			}, 20 * 2);
		}
	}
	
	@SuppressWarnings("all")
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){
		Block block = e.getBlock();
		Material material = block.getType();
		
		if(material == Material.DIRT){
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {
					block.setType(Material.DIAMOND_ORE);
				}
			}, 20 * 2);
		}
		
		if(material == Material.STONE){
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {
					block.setType(Material.GOLD_ORE);
				}
			}, 20 * 2);
		}
		
		if(material == Material.SPONGE){
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {
					block.setType(Material.COAL_ORE);
				}
			}, 20 * 2);
		}
		
		if(material == Material.COBBLESTONE){
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {
				public void run() {
					block.setType(Material.BED_BLOCK);
				}
			}, 20 * 2);
		}
	}
	
}
