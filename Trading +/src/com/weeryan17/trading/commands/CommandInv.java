package com.weeryan17.trading.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.weeryan17.trading.Main;

import net.md_5.bungee.api.ChatColor;

public class CommandInv implements CommandExecutor {
	private Main instance;
	public CommandInv(Main instance){
		this.instance = instance;
	}
	Inventory inv = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "People wanting to trade");
	public void Tradelist(Player p){
		String name = p.getName();
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE);
		ConfigurationSection requesting = instance.getConfig().getConfigurationSection("Players." + name + ".Requested to Trade");
		for (String key : requesting.getKeys(false)) {
        	boolean trader = this.instance.getConfig().getBoolean("Players." + name + ".Requested to Trade" + key);
        	if(trader == true){
        		ItemMeta meta = item.getItemMeta();
        		meta.setDisplayName(ChatColor.YELLOW + key);
        		inv.addItem(item);
        	}
		}
		p.openInventory(inv);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getLabel().equalsIgnoreCase("trading")){
			Player p = (Player) sender;
			String name = p.getName();
			Tradelist(p);
			this.instance.getConfig().set("Players." + name + "Menu", "list");
		}
		return false;
	}
}
