package com.weeryan17.trading.invManagement;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.weeryan17.trading.Main;

import net.md_5.bungee.api.ChatColor;

public class Inv {
	private Main instance;
	public Inv(Main instance){
		this.instance = instance;
	}
	static Inventory inv = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "Trading menu");
	static ArrayList<Integer> slotList = new ArrayList<Integer>();
	public static void AddItem(ItemStack item, String name, String lore, int spot){
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		addLore(item, lore);
		inv.setItem(spot, item);
	}
	public void openTradeMenu(Player p, Player pl){
		Layout(p, pl);
		p.openInventory(inv);
		pl.openInventory(inv);
	}
    private static void addLore(ItemStack i, String s) {
        if (i.getItemMeta().getLore() == null) {
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(s);
            ItemMeta imeta = i.getItemMeta();
            imeta.setLore(lore);
            i.setItemMeta(imeta);
        } else {
            List<String> lore = i.getItemMeta().getLore();
            lore.add(s);
            ItemMeta imeta = i.getItemMeta();
            imeta.setLore(lore);
            i.setItemMeta(imeta);
        }
    }
    public void Layout(Player p, Player pl){
    	String name1 = p.getName();
    	String name2 = pl.getName();
    	byte value = (byte) instance.getConfig().get("TradeMenu." + "Layout" + ".Border Material Data Value");
    	Material material = (Material)this.instance.getConfig().get("TradeManu." + "Layout" + ".Border Material");
    	ItemStack item = new ItemStack(material, value);
    	ItemStack playerItem = new ItemStack(Material.STAINED_GLASS_PANE, (byte) 1);
    	for(int i : getSlotList()){
    	AddItem(item, null, null, i);
    	}
    	getSlotList().clear();
    	AddItem(playerItem, ChatColor.YELLOW + name1, "This is " + ChatColor.YELLOW + name1 + "'s" + ChatColor.RESET + "side for trading", 0);
    	AddItem(playerItem, ChatColor.YELLOW + name2, "This is " + ChatColor.YELLOW + name2 + "'s" + ChatColor.RESET + "side for trading", 8);
    }
    public ArrayList<Integer> getSlotList(){
    	slotList.add(1);
    	slotList.add(2);
    	slotList.add(3);
    	slotList.add(4);
    	slotList.add(5);
    	slotList.add(6);
    	slotList.add(7);
    	slotList.add(13);
    	slotList.add(22);
    	slotList.add(31);
    	slotList.add(40);
    	slotList.add(46);
    	slotList.add(47);
    	slotList.add(48);
    	slotList.add(49);
    	slotList.add(50);
    	slotList.add(51);
    	slotList.add(52);
		return slotList;
    	
    }
}
