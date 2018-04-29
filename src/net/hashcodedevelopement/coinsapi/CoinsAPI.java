package net.hashcodedevelopement.coinsapi;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CoinsAPI {

	public CoinsAPI() {
	}

	public int getCoins(UUID uuid){
		int i = 0;
		if(exist(uuid)){
			FileConfiguration configuration = YamlConfiguration.loadConfiguration(new File("plugins//CoinsAPI//Playerdata//"+uuid+".yml"));
			i = configuration.getInt("Coins");
		}
		return i;
	}
	
	public void setCoins(UUID uuid, int i){
		if(exist(uuid)){
			FileConfiguration configuration = YamlConfiguration.loadConfiguration(new File("plugins//CoinsAPI//Playerdata//"+uuid+".yml"));
			configuration.set("Coins", i);
			try {
				configuration.save(new File("plugins//CoinsAPI//Playerdata//"+uuid+".yml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addCoins(UUID uuid, int i){
		if(exist(uuid)){
			FileConfiguration configuration = YamlConfiguration.loadConfiguration(new File("plugins//CoinsAPI//Playerdata//"+uuid+".yml"));
			int c = configuration.getInt("Coins");
			configuration.set("Coins", (c + i));
			try {
				configuration.save(new File("plugins//CoinsAPI//Playerdata//"+uuid+".yml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeCoins(UUID uuid, int i){
		if(exist(uuid)){
			FileConfiguration configuration = YamlConfiguration.loadConfiguration(new File("plugins//CoinsAPI//Playerdata//"+uuid+".yml"));
			int c = configuration.getInt("Coins");
			configuration.set("Coins", (c - i));
			try {
				configuration.save(new File("plugins//CoinsAPI//Playerdata//"+uuid+".yml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void payCoins(UUID uuid1, UUID uuid2, int i){
		if(hasCoins(uuid1, i)){
			addCoins(uuid2, i);
			removeCoins(uuid1, i);
		}
	}
	
	public boolean hasCoins(UUID uuid, int i){
		boolean b = false;
		if(exist(uuid)){
			FileConfiguration configuration = YamlConfiguration.loadConfiguration(new File("plugins//CoinsAPI//Playerdata//"+uuid+".yml"));
			int c = configuration.getInt("Coins");
			if(c >= i){
				b = true;
			}
		}
		return b;
	}
	
	void create(UUID uniqueId) {
		if(!exist(uniqueId)){
			FileConfiguration configuration = YamlConfiguration.loadConfiguration(new File("plugins//CoinsAPI//Playerdata//"+uniqueId+".yml"));
			configuration.set("Coins", 0);
			try {
				configuration.save(new File("plugins//CoinsAPI//Playerdata//"+uniqueId+".yml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	boolean exist(UUID uniqueId) {
		return new File("plugins//CoinsAPI//Playerdata//"+uniqueId+".yml").exists();
	}
	
}
