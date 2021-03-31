package fr.simon.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import fr.simon.main.MainClass;

public class RespawnPlayer implements Listener {

	private MainClass mc;
	public RespawnPlayer(MainClass mc) {
		this.mc = mc;
	}
	
	
	@EventHandler
	public void onRespawnPlayer(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
		p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
	}
	/*
	@EventHandler
	public void onDeathPlayer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		
		p.sendMessage("test");
		
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
	
		
		
		
		for(ItemStack is : e.getDrops()) {
			p.sendMessage(is.toString());
		}
		p.sendMessage("----------");
		
		
		
		
		e.getDrops().remove(new ItemStack(Material.IRON_BOOTS));
		e.getDrops().remove(new ItemStack(Material.IRON_LEGGINGS));
		e.getDrops().remove(new ItemStack(Material.IRON_CHESTPLATE));
		e.getDrops().remove(new ItemStack(Material.IRON_HELMET));
		
		for(ItemStack is : e.getDrops()) {
			p.sendMessage(is.toString());
		}
	}
	*/
	@EventHandler
	public void onMeltArmor(FurnaceSmeltEvent e) {
		ItemStack is = e.getSource();
		
		if(is.getType().equals(Material.IRON_HELMET) || is.getType().equals(Material.IRON_CHESTPLATE) || is.getType().equals(Material.IRON_LEGGINGS) || is.getType().equals(Material.IRON_BOOTS)) {
			e.setCancelled(true);
		}
		
	}
}
