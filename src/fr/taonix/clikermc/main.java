package fr.taonix.clikermc;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;




public class main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		
		System.out.println("Le plugin ClikerMC a bien démarer, pour commencer : /cliker");
		getCommand("cliker").setExecutor(new cliker());
		getServer().getPluginManager().registerEvents(new ClikerMenu(), this);
		
		
	}
	
	
	@Override
	public void onDisable() {
		
		System.out.println("Le plugin ClikerMC vient de se désactivé.");
		
		}
	
	@Override
	public void onLoad() {
		
		Bukkit.broadcastMessage("§4Pour commencer avec le plugin : §6§l/cliker");
	}
	
}
