package fr.simon.arene;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.simon.main.MainClass;

public class Arene {

	private MainClass mc;
	private Location coffre;
	public boolean teleport;
	private ArrayList<ItemStack> invCoffre = new ArrayList<ItemStack>();
	
	public Arene(MainClass mc) {
		this.mc = mc;
	}
	
	public void setCoffreLocation(Location coffre) {
		this.coffre = coffre;
	}
	
	public Location getCoffre() {
		return this.coffre;
	}
	
	//reprendre au niveau de la mise en place du coffre aléatoire
	
	//set un inventaire au hasard dans le coffre
	private void randomCoffre() {
		int fer = (int) (Math.random()*32);
		int or = (int) (Math.random()*24);
		int diamand = (int) (Math.random()*6);
		int emeraude = (int) (Math.random()*4);
		
		invCoffre.add(new ItemStack(Material.IRON_INGOT, fer));
		invCoffre.add(new ItemStack(Material.GOLD_INGOT, or));
		invCoffre.add(new ItemStack(Material.DIAMOND, diamand));
		invCoffre.add(new ItemStack(Material.EMERALD, emeraude));
	}
	
	public void setCoffre(World w) {
		this.randomCoffre();
		
		teleport = false;
		
		Block b = w.getBlockAt(this.coffre);
		if(b.getType().equals(Material.CHEST)) {
			Chest chest = (Chest) b.getState();
			Inventory InvChest = chest.getInventory();
			InvChest.clear();
			for(ItemStack is : invCoffre) {
				InvChest.addItem(is);
			}
			
			invCoffre.clear();
		}
		
		Bukkit.broadcastMessage("Le coffre a spawn !");
		
	}
}
