package utils;

import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_7_R1.ChatSerializer;
import net.minecraft.server.v1_7_R1.IChatBaseComponent;
import net.minecraft.server.v1_7_R1.PacketPlayOutChat;

public class RawJSON {

	public void getMessageJSON(Player p) {
		IChatBaseComponent comp = ChatSerializer.a(
				"{\"text\":\"§bApenas um teste\",\"extra\":[{\"text\":\" §f[Modo de Jogo]\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§7Clique para alterar seu modo de jogo!\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/gamemode 1\"}}]}");
		PacketPlayOutChat packet = new PacketPlayOutChat(comp);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}

}
