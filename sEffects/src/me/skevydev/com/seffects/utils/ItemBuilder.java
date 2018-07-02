package me.skevydev.com.seffects.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

	private String name = "Default";
	private Material material = Material.AIR;
	private int amount = 1;
	private short data = 0;
	
	public ItemBuilder(Material material, int amount, short data) {
		this.material = material;
		this.amount = amount;
		this.data = data;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setData(short data) {
		this.data = data;
	}
	
	public ItemStack build() {
		ItemStack item = new ItemStack(material, amount, data);
		ItemMeta itemMETA = item.getItemMeta();
		itemMETA.setDisplayName(name);
		item.setItemMeta(itemMETA);
		return item;
	}
	
}