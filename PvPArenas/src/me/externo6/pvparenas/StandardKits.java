package me.externo6.pvparenas;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StandardKits implements Listener{
	
	@EventHandler
	public void onSignCreate(SignChangeEvent sign){
		Player player = sign.getPlayer();
		if(sign.getLine(0).equalsIgnoreCase("PvPArenas")){
			if(!player.hasPermission("pvparenas.signcreate")){
		sign.setLine(0, ChatColor.DARK_RED + "Not Permitted");
		sign.setLine(1, "");
		sign.setLine(2, "");
		sign.setLine(3, "");
			}
		}
}
	@EventHandler
	public void onPlayerInteractStandardKit(PlayerInteractEvent event)
	{
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			Block block = event.getClickedBlock();
			if ((block.getType() == Material.WALL_SIGN) || (block.getType() == Material.SIGN_POST))
			{
				Sign sign = (Sign)block.getState();
				Player player = event.getPlayer();
				ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
				ItemMeta swordmeta = sword.getItemMeta();
				swordmeta.setDisplayName(ChatColor.GOLD + "PVP");
				sword.setItemMeta(swordmeta);
				ItemStack bow = new ItemStack(Material.BOW, 1);
				ItemMeta bowmeta = sword.getItemMeta();
				bowmeta.setDisplayName(ChatColor.GOLD + "PVP");
				bow.setItemMeta(bowmeta);
				ItemStack arrows = new ItemStack(Material.ARROW, 64);
				ItemMeta arrowsmeta = sword.getItemMeta();
				arrowsmeta.setDisplayName(ChatColor.GOLD + "PVP");
				arrows.setItemMeta(arrowsmeta);
				ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
				ItemMeta helmetmeta = helmet.getItemMeta();
				helmetmeta.setDisplayName(ChatColor.GOLD + "PVP");
				helmet.setItemMeta(helmetmeta);
				ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				ItemMeta chestplatemeta = chestplate.getItemMeta();
				chestplatemeta.setDisplayName(ChatColor.GOLD + "PVP");
				chestplate.setItemMeta(chestplatemeta);
				ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				ItemMeta leggingsmeta = leggings.getItemMeta();
				leggingsmeta.setDisplayName(ChatColor.GOLD + "PVP");
				leggings.setItemMeta(leggingsmeta);
				ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
				ItemMeta bootsmeta = boots.getItemMeta();
				bootsmeta.setDisplayName(ChatColor.GOLD + "PVP");
				boots.setItemMeta(bootsmeta);
				if ((sign.getLine(0).equals(ChatColor.DARK_BLUE + "PvPArenas")) && (sign.getLine(1).equals("Kit")))
					if (player.getWorld().getName().equalsIgnoreCase("games"))
					{
						player.getInventory().clear();
						player.getInventory().setHelmet(helmet);
						player.getInventory().setChestplate(chestplate);
						player.getInventory().setLeggings(leggings);
						player.getInventory().setBoots(boots);
						player.getInventory().setItemInHand(sword);
						player.getInventory().addItem(bow);
						player.getInventory().addItem(arrows);
						player.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED + "PvPArenas"+ ChatColor.GOLD + "]" + ChatColor.GREEN + " Kit " + ChatColor.GOLD + "PVP " + ChatColor.GREEN + "Given and has been equipt!");
					}
			}
		}
	}

}
