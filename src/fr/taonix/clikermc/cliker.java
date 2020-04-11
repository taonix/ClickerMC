package fr.taonix.clikermc;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class cliker implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {


		if(sender instanceof Player) {
			Player player = (Player) sender;
		
			
			Inventory cliker = Bukkit.createInventory(null, 9, "      §6§l > §r§4 Menu du cliker §6§l < ");


			ItemStack m = getPlayerHead("JuanFco");
			ItemMeta Mm = m.getItemMeta();
			Mm.setDisplayName("§4Cliker");
			m.setItemMeta(Mm);
			
			ItemStack shop = getPlayerHead("MrSnowDK");
			ItemMeta Mshop = shop.getItemMeta();
			Mshop.setDisplayName("§2Shop");
			shop.setItemMeta(Mshop);
			
			ItemStack playerInfo = getPlayerHead(player.getName());
			ItemMeta MplayerInfo = playerInfo.getItemMeta();
			MplayerInfo.setDisplayName("§2"+ player.getName());
			playerInfo.setItemMeta(MplayerInfo);
			
			

			
			cliker.setItem(0, shop);
			cliker.setItem(4, m);
			cliker.setItem(8, playerInfo);
			
			player.openInventory(cliker);



		}

		return false;
	}
	
	
	public ItemStack getPlayerHead(String player) {
		
		boolean isNewVersion = Arrays.stream(Material.values())
				.map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
				
		Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
		ItemStack item = new ItemStack(type, 1);
		
		if(!isNewVersion)
			item.setDurability((short) 3);
		
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(player);
		
		item.setItemMeta(meta);
		
		return item;
	}

}
