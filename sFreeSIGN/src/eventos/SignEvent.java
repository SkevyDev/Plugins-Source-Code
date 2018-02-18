package eventos;

import org.bukkit.Bukkit;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SignEvent implements Listener{
	
	@EventHandler
	public void onSign(SignChangeEvent e){
		Player p = e.getPlayer();
		if(e.getLine(0).equalsIgnoreCase("[FREE]")){
			e.setLine(0, "§2§l[FREE]");
		}
		
		if(e.getLine(0).equalsIgnoreCase("§2§l[FREE]")){
		if(e.getLine(1).equalsIgnoreCase("")){
			p.sendMessage("§a§lSIGN §fVocê deve inserir uma ID!");
			return;
			}
		p.sendMessage("§a§lSIGN §fPlaca free criada com sucesso!");
		}
		
	}
	
	@SuppressWarnings("all")
	@EventHandler
    public void on(PlayerInteractEvent e) {
            Player p = e.getPlayer();
           
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (e.getClickedBlock().getState() instanceof Sign) {
                            Sign s = (Sign) e.getClickedBlock().getState();
                           
                            if (s.getLine(0).equalsIgnoreCase("§2§l[FREE]")) {
                                    try {
                                            String[] string = s.getLine(1).split(":");
                                            int ID = Integer.valueOf(string[0]);
                                            int Byte = 0;
                                           
                                            if (s.getLine(1).contains(":")) {
                                                    Byte = Integer.valueOf(string[1]);
                                            }
                                           
                                            Inventory inv = Bukkit.createInventory(null, 27, "§2Items Grátis");
                                            
                                            for (int i = 0; i < inv.getSize(); i++) {
                                                    inv.setItem(i, new ItemStack(ID, 64, (byte) Byte));
                                            }
                                           
                                            p.openInventory(inv);
                                           
                                    } catch (NumberFormatException ex) {
                                            p.sendMessage("§c§lSIGN §fNenhuma ID válida!");
                                    }
                            }
                    }
            }

	}
}
