package eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import me.skevydev.smanutencao.Main;

public class LoginEvent implements Listener{
	
	@EventHandler
	public void onJoin(PlayerLoginEvent e){
		Player p = e.getPlayer();
		if(Main.getInstance().getConfig().getBoolean("Manutencao." + "Status") == true){
			if(!p.hasPermission("smanutencdao.command.manutencao")){
				e.disallow(Result.KICK_FULL, "§c§lMANUTENÇÃO" + "\n" + "\n" + "      §fNo momento estamos em manutenção." + "\n" + "§fTente novamente mais tarde!");
			}
		}
	}

}
