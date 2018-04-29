package net.hashcodedevelopement.coinsapi;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.hashcodedevelopement.coinsapi.CoinsAPI;

public class Coins extends JavaPlugin {

	String prefix = "§3§lC§b§loins§a§lA§b§lPI §8» §7";
	
	@Override
	public void onEnable() {
		System.out.println(" ");
		System.out.println("   _____      _                    _____ _____ \n  / ____|    (_)             /\\   |  __ \\_   _|\n | |     ___  _ _ __  ___   /  \\  | |__) || |  \n | |    / _ \\| | '_ \\/ __| / /\\ \\ |  ___/ | |  \n | |___| (_) | | | | \\__ \\/ ____ \\| |    _| |_ \n  \\_____\\___/|_|_| |_|___/_/    \\_\\_|   |_____|");
		System.out.println(" ");
		System.out.println("Coded by HashCodeDevelopement | Cerus");
		System.out.println(" ");
		
		getCommand("coins").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			CoinsAPI coinsAPI = new CoinsAPI();
			
			if(args.length == 0){
				if(coinsAPI.exist(player.getUniqueId())){
					player.sendMessage(prefix+"Deine Coins: §a"+coinsAPI.getCoins(player.getUniqueId()));
				} else {coinsAPI.create(player.getUniqueId()); player.performCommand("coins");}
			} else if(args.length == 3){
				if(args[0].equalsIgnoreCase("add")){
					Player r = Bukkit.getPlayer(args[1]);
					if(r != null){
						if (Pattern.matches("[a-zA-Z]+", args[2]) == false) {							
							coinsAPI.addCoins(r.getUniqueId(), Integer.parseInt(args[2]));
						}
					}
				} else if(args[0].equalsIgnoreCase("remove")){
					Player r = Bukkit.getPlayer(args[1]);
					if(r != null){
						if (Pattern.matches("[a-zA-Z]+", args[2]) == false) {							
							coinsAPI.removeCoins(r.getUniqueId(), Integer.parseInt(args[2]));
						}
					}
				} else if(args[0].equalsIgnoreCase("set")){
					Player r = Bukkit.getPlayer(args[1]);
					if(r != null){
						if (Pattern.matches("[a-zA-Z]+", args[2]) == false) {							
							coinsAPI.setCoins(r.getUniqueId(), Integer.parseInt(args[2]));
						}
					}
				}
			}
		}
		return false;
	}
	
}
