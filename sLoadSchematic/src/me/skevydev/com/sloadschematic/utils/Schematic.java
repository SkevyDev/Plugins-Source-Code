package me.skevydev.com.sloadschematic.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;

public class Schematic {

	public void loadByName(Player p, String name) {
		Location loc = p.getLocation();
		WorldEditPlugin pl = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
		File schematic = new File(pl.getDataFolder() + "/schematics/" + name + ".schematic");
		EditSession session = pl.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(loc.getWorld()), 
				10000);
		try {
			CuboidClipboard clipboard = MCEditSchematicFormat.getFormat(schematic).load(schematic);
			clipboard.rotate2D(90);
			clipboard.paste(session, new Vector(loc.getX(), loc.getY(), loc.getZ()), false);
		}catch(IOException | MaxChangedBlocksException | DataException e) {
			e.printStackTrace();
		}
	}
	
}