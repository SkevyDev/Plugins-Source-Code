package me.skevydev.com.seffects.utils;

import java.util.HashMap;

import org.bukkit.Effect;
import org.bukkit.entity.Player;

public class HashManager {

	public HashMap<Player, Effect> effect = new HashMap<>();
	
	public Effect getEffect(Player p) {
		return effect.get(p);
	}
	
	public void addEffect(Player p, Effect effect) {
		if(hasEffect(p)) {
			removeEffect(p);
		}
		this.effect.put(p, effect);
	}
	
	public void removeEffect(Player p) {
		if(hasEffect(p)) {
			effect.remove(p);
		}
	}
	
	public boolean hasEffect(Player p) {
		return effect.containsKey(p);
	}
	
}