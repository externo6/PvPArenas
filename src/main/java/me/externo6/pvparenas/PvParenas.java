package me.externo6.pvparenas;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

public class PvParenas extends JavaPlugin implements Listener{
	public final Logger logger = Logger.getLogger("minecraft");
	public static PvParenas plugin;
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!"); 
	}

	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[PvPArenas]" + " Version " + pdfFile.getVersion() + " |" + " Developed for Banxsi.com by externo6");
		registerEvents(this, new StandardKits(), new GodKits());
		getServer().getPluginManager().registerEvents(this, this);	
	}
	
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
	    for (Listener listener : listeners) {
	        Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	    }
	}
	
	//for a few days
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent event){
		Player player = event.getPlayer();
        if (player.hasPermission("pvparenas.remove"))
        {
       	 if((player.getWorld().getName().equalsIgnoreCase("games_hub")) || 
    			 (player.getWorld().getName().equalsIgnoreCase("games")) || 
    			 (player.getWorld().getName().equalsIgnoreCase("godpvp")))  {
       	  player.removePotionEffect(PotionEffectType.ABSORPTION);
    	  player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
    	  player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    	  player.removePotionEffect(PotionEffectType.HARM);
    	  player.removePotionEffect(PotionEffectType.HEAL);
    	  player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
    	  player.removePotionEffect(PotionEffectType.HUNGER);
    	  player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    	  player.removePotionEffect(PotionEffectType.INVISIBILITY);
    	  player.removePotionEffect(PotionEffectType.JUMP);
    	  player.removePotionEffect(PotionEffectType.NIGHT_VISION);
    	  player.removePotionEffect(PotionEffectType.REGENERATION);
    	  player.removePotionEffect(PotionEffectType.SATURATION);
    	  player.removePotionEffect(PotionEffectType.SPEED);
    	  player.removePotionEffect(PotionEffectType.WATER_BREATHING);
    	  player.removePotionEffect(PotionEffectType.WEAKNESS);
    //	  player.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED + "PvPArenas"+ ChatColor.GOLD + "]" + ChatColor.GREEN + " All potion effects (if any) removed.");
       	 }
        }
        else
        {	
	 if((player.getWorld().getName().equalsIgnoreCase("games_hub")) || 
			 (player.getWorld().getName().equalsIgnoreCase("games")) || 
			 (player.getWorld().getName().equalsIgnoreCase("godpvp")))  {
   	  player.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED + "PvPArenas"+ ChatColor.GOLD + "]" + ChatColor.GREEN + " Exempt from potion effects removal.");
	 }
        }
	 }
}
