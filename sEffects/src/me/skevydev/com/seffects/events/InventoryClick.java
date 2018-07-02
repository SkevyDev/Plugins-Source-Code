package me.skevydev.com.seffects.events;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.skevydev.com.seffects.Main;

public class InventoryClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			if(e.getInventory().getTitle().equals("§cEffects")) {
				e.setCancelled(true);
				if(e.getCurrentItem() == null || !e.getCurrentItem().hasItemMeta() || 
						!e.getCurrentItem().getItemMeta().hasDisplayName() || 
						e.getCurrentItem().getType() == Material.AIR) return;
				for(Effect effects : Effect.values()) {
					if(e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName()
							.equals("§3" + effects.name().replace("_", " "))) {
						p.closeInventory();
						if(Main.getInstance().hash.getEffect(p) == effects) {
							Main.getInstance().hash.removeEffect(p);
							p.sendMessage("");
							p.sendMessage("§7• Efeito §c" + effects.name().toLowerCase().replace("&", "§") + 
									" §7desativado com sucesso!");
							p.sendMessage("");
							return;
						}
						Main.getInstance().hash.addEffect(p, effects);
						p.sendMessage("");
						p.sendMessage("§7• Efeito §e" + effects.name().toLowerCase().replace("&", "§") + 
								" §7ativado com sucesso!");
						p.sendMessage("");
						break;
					}
				}
				if(e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName()
						.equals("§c• Limpar efeito")) {
					p.closeInventory();
					if(Main.getInstance().hash.hasEffect(p)) {
						p.sendMessage("");
						p.sendMessage("§7• Efeito §c" + Main.getInstance().hash.getEffect(p).name().toLowerCase()
								.replace("&", "§") + " §7desativado com sucesso!");
						p.sendMessage("");
						Main.getInstance().hash.removeEffect(p);
					}else {
						p.sendMessage("");
						p.sendMessage("§c• Nenhum efeito encontrado");
						p.sendMessage("");
					}
				}
			}
		}
	}
	
}