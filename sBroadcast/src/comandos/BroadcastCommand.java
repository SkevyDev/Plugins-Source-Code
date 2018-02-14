package comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.skevydev.sbroadcast.Main;

public class BroadcastCommand implements CommandExecutor{
	
	private JavaPlugin main = JavaPlugin.getPlugin(Main.class);
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
			if(label.equalsIgnoreCase("broadcast") || label.equalsIgnoreCase("bc")){
				if(sender.hasPermission(main.getConfig().getString("Permission"))){
					if(args.length == 0){
						sender.sendMessage("");
						sender.sendMessage(main.getConfig().getString("Prefix").replace("&", "§") + " " + main.getConfig().getString("UseCommandMessage").replace("&", "§"));
						sender.sendMessage("");
						return true;
					}
					if(args.length >= 1){
						StringBuilder sb = new StringBuilder();
						for(int i = 0; i < args.length; i++){
							sb.append(args[i]).append(" ");
						}
						String broadcastSS = sb.toString();
						broadcastSS = ChatColor.translateAlternateColorCodes('&', broadcastSS);
						Bukkit.broadcastMessage("");
						Bukkit.broadcastMessage(main.getConfig().getString("Prefix").replace("&", "§") + " " + main.getConfig().getString("DefaultColorMessage").replace("&", "§") + broadcastSS);
						Bukkit.broadcastMessage("");
					}
				}else{
					sender.sendMessage("");
					sender.sendMessage(main.getConfig().getString("Prefix").replace("&", "§") + " " + main.getConfig().getString("PermissionMessageError").replace("&", "§"));
					sender.sendMessage("");
				}
			}
		return false;
	}

}
