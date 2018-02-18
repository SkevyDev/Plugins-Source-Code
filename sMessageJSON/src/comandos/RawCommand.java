package comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utils.RawJSON;

public class RawCommand implements CommandExecutor {

	RawJSON rawSS = new RawJSON();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("modo")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§c§lMODO §fVocê não é um player!");
				return true;
			}
			Player p = (Player) sender;
			if (p.hasPermission("smessagejson.command.modo")) {
				rawSS.getMessageJSON(p);
			} else {
				p.sendMessage(
						"§c§lMODO §fVocê não tem a permissão: §csmessagejson.command.modo, §fpara executar esse comando!");
			}
		}
		return false;

	}
}
