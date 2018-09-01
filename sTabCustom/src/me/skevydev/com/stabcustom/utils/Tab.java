package me.skevydev.com.stabcustom.utils;

import java.lang.reflect.Field;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutPlayerListHeaderFooter;

public class Tab {

	public void send(Player p, String header, String footer) {
		if(header == null) header = "";
		if(footer == null) footer = "";
		
		IChatBaseComponent tabHeader = ChatSerializer.a("{\"text\":\"" + header + "\"}");
		IChatBaseComponent tabFooter = ChatSerializer.a("{\"text\":\"" + footer + "\"}");
		
		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter(tabHeader);
		try {
			Field f = packet.getClass().getDeclaredField("b");
			f.setAccessible(true);
			f.set(packet, tabFooter);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
		}
	}
	
	public int getPing(Player p) {
		return ((CraftPlayer)p).getHandle().ping;
	}
	
}