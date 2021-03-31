package fr.simon.event;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.simon.main.MainClass;
import fr.simon.team.Equipe;

public class CloseChest implements Listener{

	
	private MainClass mc;
	public CloseChest(MainClass mc) {
		this.mc = mc;
	}
	
	@EventHandler
	public void onChestClose(InventoryCloseEvent e) {
		if(mc.coffre) {
			Inventory i = e.getInventory();
			Player p = (Player) e.getPlayer();
			Equipe eq = mc.el.getTeam(p);
			if(i.getViewers().size() == 1) {
				if(i.getType().equals(InventoryType.CHEST)) {
					if(eq != null) {
						if(eq.getZone().getCofre().equals(e.getInventory().getLocation())) {
							ItemStack[] contenu = i.getContents();
														
							for(ItemStack is : contenu) {
								if(is != null) {
									if(is.getType().equals(Material.DIAMOND)) {
										int k = is.getAmount();
										eq.addPoint(150*k);
										is.setAmount(0);
									}else if(is.getType().equals(Material.GOLD_INGOT)) {
										int k = is.getAmount();
										eq.addPoint(50*k);
										is.setAmount(0);
									}else if(is.getType().equals(Material.IRON_INGOT)) {
										int k = is.getAmount();
										eq.addPoint(10*k);
										is.setAmount(0);
									}else if(is.getType().equals(Material.EMERALD)) {
										int k = is.getAmount();
										eq.addPoint(300*k);
										is.setAmount(0);
									}
								}
							}
							i.clear();
							p.sendMessage("Vous avez maintenant " + eq.getPoint() + " points.");
							
						}
					}	
				}
			}
		}
	}
	
}
