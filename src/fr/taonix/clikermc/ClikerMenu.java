package fr.taonix.clikermc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ClikerMenu implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {

		Inventory cliker = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		if(current == null) return;
		
		Inventory clikerg = Bukkit.createInventory(null, 27, "       §6§l > §r§4§l Le cliker §6§l < ");
		
		ItemStack cl = new ItemStack(Material.COBBLESTONE, 1);
		ItemMeta Mcl = cl.getItemMeta();
		Mcl.setDisplayName("§4Clikez !");
		cl.setItemMeta(Mcl);
		
		clikerg.setItem(13, cl);
		
		
		


		if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§4Cliker")) {
			event.setCancelled(true);
			player.closeInventory();
			player.openInventory(clikerg);

		}

	}
}//fin de inventory click event



