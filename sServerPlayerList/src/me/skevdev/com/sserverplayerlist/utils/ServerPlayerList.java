package me.skevdev.com.sserverplayerlist.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerOptions;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;

import me.skevdev.com.sserverplayerlist.Main;

public class ServerPlayerList {

	private List<WrappedGameProfile> message = new ArrayList<WrappedGameProfile>();
	
	public ServerPlayerList() {
		message.add(new WrappedGameProfile("1", ""));
		message.add(new WrappedGameProfile("1", "§a§lTESTE§f§lMC §7(1.8.X)"));
		message.add(new WrappedGameProfile("1", ""));
		message.add(new WrappedGameProfile("1", "§aLoja: §floja.testemc.com"));
		message.add(new WrappedGameProfile("1", "§aTwitter: §f@TesteMC"));
		message.add(new WrappedGameProfile("1", ""));
		message.add(new WrappedGameProfile("1", "§aVenha se divertir conosco!"));
	}
	
	public void setup() {
		ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(Main.getPlugin(Main.class),
				ListenerPriority.NORMAL, Arrays.asList(PacketType.Status.Server.OUT_SERVER_INFO),
				ListenerOptions.ASYNC) {
			@Override
			public void onPacketSending(PacketEvent e) {
				e.getPacket().getServerPings().read(0).setPlayers(message);
			}
		});
	}
	
}