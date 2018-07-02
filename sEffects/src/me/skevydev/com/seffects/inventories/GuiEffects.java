package me.skevydev.com.seffects.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.skevydev.com.seffects.utils.ItemBuilder;

public class GuiEffects {

	public void open(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, "§cEffects");
		ItemBuilder item = new ItemBuilder(Material.ENDER_PEARL, 1, (short) 0);
		int i = 0;
		for(Effect effects : Effect.values()) {
			item.setName("§3" + effects.name().replace("_", " "));
			inv.setItem(i, item.build());
			i++;
			if(i > 53) break;
		}
		item.setMaterial(Material.PAPER);
		item.setName("§c• Limpar efeito");
		inv.setItem(53, item.build());
		p.openInventory(inv);
	}
	
}