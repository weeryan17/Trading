package com.weeryan17.trading.invManagement;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.weeryan17.trading.Main;

public class Events implements Listener {
	private Main instance;
	public Events(Main instance){
		this.instance = instance;
	}
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Inv inv = new Inv(instance);
		int slot = e.getSlot();
		ItemStack item = e.getCurrentItem();
		Player p = (Player) e.getWhoClicked();
		String name = p.getName();
		if(this.instance.getConfig().getString("Players." + name + "Menu") == "list"){
			ItemMeta meta = item.getItemMeta();
			String display = meta.getDisplayName();
			ConfigurationSection requesting = instance.getConfig().getConfigurationSection("Players." + name + ".Requested to Trade");
			for (String key : requesting.getKeys(false)) {
	        	boolean trader = this.instance.getConfig().getBoolean("Players." + name + ".Requested to Trade" + key);
	        	if(trader == true){
	        		if(display == key){
	        			Player pl = Bukkit.getPlayer(key);
	        			inv.openTradeMenu(pl, p);
						this.instance.getConfig().set("Player." + name + ".Requested to Trade" + key, false);
						this.instance.getConfig().set("Players." + name + "Menu", "tradeRight");
						this.instance.getConfig().set("Players." + key + "Menu", "tradeLeft");
	        		}
	        	}
			}
		}
	}
}
