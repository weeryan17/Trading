package com.weeryan17.trading.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.weeryan17.trading.Main;
import com.weeryan17.trading.invManagement.Inv;

import net.md_5.bungee.api.ChatColor;

public class TradeCommand implements CommandExecutor {
	private Main instance;
	public TradeCommand(Main instance){
		this.instance = instance;
	}
	Inv inv = new Inv(instance);
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getLabel().equalsIgnoreCase("trade")){
			if(args.length == 1){
				Player p = Bukkit.getPlayer(args[0]);
				if(p == null){
					sender.sendMessage(ChatColor.RED + "That player doesn't exist");
				} else {
					Player pl = (Player) sender;
					String name = pl.getName();
					String secondPlayerName = p.getName();
					this.instance.getConfig().set("Player." + secondPlayerName + ".Requested to Trade" + name, true);
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Incorect ussage use /trade <player>");
			}
		}
		return false;
	}

}
