package eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.skevydev.smanutencao.Main;

public class MotdEvent implements Listener{
	
	@EventHandler
	public void onMotd(ServerListPingEvent e){
		if(Main.getInstance().getConfig().getBoolean("Manutencao." + "Status") == true){
			e.setMotd("§c§lMANUTENÇÃO §fEstamos em manutenção no momento." + "\n" + "§fTente novamente mais tarde!");
		}
	}

}
