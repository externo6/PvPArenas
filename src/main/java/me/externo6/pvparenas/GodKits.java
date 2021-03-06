package me.externo6.pvparenas;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GodKits implements Listener{
	
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
	public void onPlayerDeathMessage(PlayerDeathEvent event){
		Player player = event.getEntity();
		Player killer = event.getEntity().getKiller();
	//	ItemStack arrows = new ItemStack(Material.ARROW, 1);
		ItemStack droppedarrow = new ItemStack(Material.ARROW, 1);
		ItemMeta droppedarrowsmeta = droppedarrow.getItemMeta();
		droppedarrowsmeta.setDisplayName(ChatColor.RED + player.getName() + "'s arrow");
		droppedarrow.setItemMeta(droppedarrowsmeta); 
		if ((player.getWorld().getName().equalsIgnoreCase("godpvp")) 
				&& (event.getEntity() instanceof Player) 
				&& (!(player.getKiller() ==null))){
			event.setDeathMessage(null); 
			killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 1));
			player.sendMessage(ChatColor.WHITE + "You were killed by " + killer.getDisplayName());
			killer.sendMessage(ChatColor.WHITE + "You have killed " + player.getDisplayName());
				if (player.getInventory().contains(Material.ARROW)){
					event.getDrops().clear();
					event.getDrops().add(droppedarrow);
				}
				else{
					event.getDrops().clear();
				}
		}
	}
	@EventHandler
	public void onPlayerInteractOneHitKit(PlayerInteractEvent event)
	{
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			Block block = event.getClickedBlock();
			if ((block.getType() == Material.WALL_SIGN) || (block.getType() == Material.SIGN_POST || (block.getType() == Material.SIGN)))
			{
				{
					Sign sign = (Sign)block.getState();
					Player player = event.getPlayer();
					String[] swordlore = {ChatColor.WHITE + "PVP ARENA ONLY"};
					ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
					ItemMeta swordmeta = sword.getItemMeta();
					swordmeta.addEnchant(Enchantment.DAMAGE_ALL, 9999, true);
					swordmeta.setLore(Arrays.asList(swordlore));
					swordmeta.setDisplayName(ChatColor.DARK_RED + "INSTA-KILL");
					sword.setItemMeta(swordmeta);
					String[] helmetlore = {ChatColor.WHITE + "PVP ARENA ONLY"};
					ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
					ItemMeta helmetmeta = helmet.getItemMeta();
					helmetmeta.addEnchant(Enchantment.DURABILITY, 3, true);
					helmetmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
					helmetmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
					helmetmeta.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
					helmetmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
					helmetmeta.addEnchant(Enchantment.OXYGEN, 1, true);
					helmetmeta.addEnchant(Enchantment.WATER_WORKER, 1, true);
					helmetmeta.setLore(Arrays.asList(helmetlore));
					helmetmeta.setDisplayName(ChatColor.DARK_RED + "INSTA-KILL");
					helmet.setItemMeta(helmetmeta);
					String[] chestplatelore = {ChatColor.WHITE + "PVP ARENA ONLY"};
					ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
					ItemMeta chestplatemeta = chestplate.getItemMeta();
					chestplatemeta.addEnchant(Enchantment.DURABILITY, 3, true);
					chestplatemeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
					chestplatemeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
					chestplatemeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
					chestplatemeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
					chestplatemeta.setLore(Arrays.asList(chestplatelore));
					chestplatemeta.setDisplayName(ChatColor.DARK_RED + "INSTA-KILL");
					chestplate.setItemMeta(chestplatemeta);
					String[] legginslore = {ChatColor.WHITE + "PVP ARENA ONLY"};
					ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
					ItemMeta leggingsmeta = leggings.getItemMeta();
					leggingsmeta.addEnchant(Enchantment.DURABILITY, 3, true);
					leggingsmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
					leggingsmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
					leggingsmeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
					leggingsmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
					leggingsmeta.setLore(Arrays.asList(legginslore));
					leggingsmeta.setDisplayName(ChatColor.DARK_RED + "INSTA-KILL");
					leggings.setItemMeta(leggingsmeta);
					String[] bootslore = {ChatColor.WHITE + "PVP ARENA ONLY"};
					ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
					ItemMeta bootsmeta = boots.getItemMeta();
					bootsmeta.addEnchant(Enchantment.DURABILITY, 3, true);
					bootsmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
					bootsmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
					bootsmeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
					bootsmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
					bootsmeta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
					bootsmeta.setLore(Arrays.asList(bootslore));
					bootsmeta.setDisplayName(ChatColor.DARK_RED + "INSTA-KILL");
					boots.setItemMeta(bootsmeta);
					String[] bowlore = {ChatColor.WHITE + "PVP ARENA ONLY"};
					ItemStack bow = new ItemStack(Material.BOW, 1);
					ItemMeta bowmeta = bow.getItemMeta();
					bowmeta.addEnchant(Enchantment.ARROW_DAMAGE, 9999, true);
					bowmeta.setLore(Arrays.asList(bowlore));
					bowmeta.setDisplayName(ChatColor.DARK_RED + "INSTA-KILL");
					bow.setItemMeta(bowmeta);
					ItemStack arrows = new ItemStack(Material.ARROW, 1);
					ItemMeta arrowsmeta = arrows.getItemMeta();
					arrowsmeta.setDisplayName(ChatColor.DARK_RED + "INSTA-KILL");
					arrows.setItemMeta(arrowsmeta);
					if ((sign.getLine(0).equals(ChatColor.DARK_BLUE + "PvPArenas")) && (sign.getLine(1).equals("OneHit")))
						if (player.getWorld().getName().equalsIgnoreCase("godpvp"))
						{
							player.getInventory().clear();
							player.getInventory().setHelmet(helmet);
							player.getInventory().setChestplate(chestplate);
							player.getInventory().setLeggings(leggings);
							player.getInventory().setBoots(boots);
							player.getInventory().setItemInHand(sword);
							player.getInventory().addItem(bow);
							player.getInventory().addItem(arrows);
							player.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED + "PvPArenas"+ ChatColor.GOLD + "]" + ChatColor.GREEN + " Kit " + ChatColor.DARK_RED + "INSTA-KILL" + ChatColor.GREEN + "Given and has been equipt!");
						}
				}
			}
		}
	}
	@EventHandler
	public void onPlayerInteractGodKit(PlayerInteractEvent event)
	{
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			Block block = event.getClickedBlock();
			if ((block.getType() == Material.WALL_SIGN) || (block.getType() == Material.SIGN_POST || (block.getType() == Material.SIGN)))
			{
				Sign sign = (Sign)block.getState();
				Player player = event.getPlayer();
				String[] swordlore = {ChatColor.WHITE + "PVP ARENA ONLY"};
				ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
				ItemMeta swordmeta = sword.getItemMeta();
				swordmeta.addEnchant(Enchantment.DURABILITY, 3, true);
				swordmeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
				swordmeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
				swordmeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
				swordmeta.setLore(Arrays.asList(swordlore));
				swordmeta.setDisplayName(ChatColor.DARK_RED + "PVP" + ChatColor.GOLD + "GOD");
				sword.setItemMeta(swordmeta);
				String[] helmetlore = {ChatColor.WHITE + "PVP ARENA ONLY"};
				ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
				ItemMeta helmetmeta = helmet.getItemMeta();
				helmetmeta.addEnchant(Enchantment.DURABILITY, 3, true);
				helmetmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
				helmetmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
				helmetmeta.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
				helmetmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
				helmetmeta.addEnchant(Enchantment.OXYGEN, 1, true);
				helmetmeta.addEnchant(Enchantment.WATER_WORKER, 1, true);
				helmetmeta.setLore(Arrays.asList(helmetlore));
				helmetmeta.setDisplayName(ChatColor.DARK_RED + "PVP" + ChatColor.GOLD + "GOD");
				helmet.setItemMeta(helmetmeta);
				String[] chestplatelore = {ChatColor.WHITE + "PVP ARENA ONLY"};
				ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
				ItemMeta chestplatemeta = chestplate.getItemMeta();
				chestplatemeta.addEnchant(Enchantment.DURABILITY, 3, true);
				chestplatemeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
				chestplatemeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
				chestplatemeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
				chestplatemeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
				chestplatemeta.setLore(Arrays.asList(chestplatelore));
				chestplatemeta.setDisplayName(ChatColor.DARK_RED + "PVP" + ChatColor.GOLD + "GOD");
				chestplate.setItemMeta(chestplatemeta);
				String[] legginslore = {ChatColor.WHITE + "PVP ARENA ONLY"};
				ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
				ItemMeta leggingsmeta = leggings.getItemMeta();
				leggingsmeta.addEnchant(Enchantment.DURABILITY, 3, true);
				leggingsmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
				leggingsmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
				leggingsmeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
				leggingsmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
				leggingsmeta.setLore(Arrays.asList(legginslore));
				leggingsmeta.setDisplayName(ChatColor.DARK_RED + "PVP" + ChatColor.GOLD + "GOD");
				leggings.setItemMeta(leggingsmeta);
				String[] bootslore = {ChatColor.WHITE + "PVP ARENA ONLY"};
				ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
				ItemMeta bootsmeta = boots.getItemMeta();
				bootsmeta.addEnchant(Enchantment.DURABILITY, 3, true);
				bootsmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
				bootsmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
				bootsmeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
				bootsmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
				bootsmeta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
				bootsmeta.setLore(Arrays.asList(bootslore));
				bootsmeta.setDisplayName(ChatColor.DARK_RED + "PVP" + ChatColor.GOLD + "GOD");
				boots.setItemMeta(bootsmeta);
				String[] axelore = {ChatColor.WHITE + "PVP ARENA ONLY"};
				ItemStack axe = new ItemStack(Material.DIAMOND_AXE, 1);
				ItemMeta axemeta = axe.getItemMeta();
				axemeta.addEnchant(Enchantment.DURABILITY, 3, true);
				axemeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
				axemeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
				axemeta.setLore(Arrays.asList(axelore));
				axemeta.setDisplayName(ChatColor.DARK_RED + "PVP" + ChatColor.GOLD + "GOD");
				axe.setItemMeta(axemeta);
				String[] bowlore = {ChatColor.WHITE + "PVP ARENA ONLY"};
				ItemStack bow = new ItemStack(Material.BOW, 1);
				ItemMeta bowmeta = bow.getItemMeta();
				bowmeta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
				bowmeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
				bowmeta.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
				bowmeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
				bowmeta.setLore(Arrays.asList(bowlore));
				bowmeta.setDisplayName(ChatColor.DARK_RED + "PVP" + ChatColor.GOLD + "GOD");
				bow.setItemMeta(bowmeta);
				ItemStack arrows = new ItemStack(Material.ARROW, 64);
				ItemMeta arrowsmeta = arrows.getItemMeta();
				arrowsmeta.setDisplayName(ChatColor.GOLD + "PVP");
				arrows.setItemMeta(arrowsmeta);
				if ((sign.getLine(0).equals(ChatColor.DARK_BLUE + "PvPArenas")) && (sign.getLine(1).equals("God Kit")))
					if (player.getWorld().getName().equalsIgnoreCase("godpvp"))
					{
						player.getInventory().clear();
						player.getInventory().setHelmet(helmet);
						player.getInventory().setChestplate(chestplate);
						player.getInventory().setLeggings(leggings);
						player.getInventory().setBoots(boots);
						player.getInventory().setItemInHand(sword);
						player.getInventory().addItem(axe);
						player.getInventory().addItem(bow);
						player.getInventory().addItem(arrows);
						player.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED + "PvPArenas"+ ChatColor.GOLD + "]" + ChatColor.GREEN + " Kit " + ChatColor.DARK_RED + "PVP" + ChatColor.GOLD + "GOD " + ChatColor.GREEN + "Given and has been equipt!");
					}
			}
		}
	}
}
