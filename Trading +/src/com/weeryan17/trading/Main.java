package com.weeryan17.trading;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.weeryan17.trading.commands.CommandInv;
import com.weeryan17.trading.commands.TradeCommand;
import com.weeryan17.trading.invManagement.Events;
import com.weeryan17.trading.invManagement.Inv;

public class Main extends JavaPlugin {
	public static Main plugin;
	public void onEnable(){
		plugin = this;
		Events events = new Events(plugin);
		Bukkit.getServer().getPluginManager().registerEvents(events, plugin);
		TradeCommand cmd1 = new TradeCommand(plugin);
		CommandInv cmd2 = new CommandInv(plugin);
		this.getCommand("trade").setExecutor(cmd1);
		this.getCommand("trader").setExecutor(cmd2);
		if(!this.getConfig().contains("TradeMenu.")){
			this.getConfig().set("TradeManu." + "Layout" + ".Border Material", Material.STAINED_GLASS_PANE);
			this.getConfig().set("TradeMenu." + "Layout" + ".Border Material Data Value", (byte) 15);
		}
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, (byte) 15);
		Inv.AddItem(item, "test", null, 0);
	}
	public void onDissable(){
		
	}
}
