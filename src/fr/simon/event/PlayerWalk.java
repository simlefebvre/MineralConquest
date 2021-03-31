package fr.simon.event;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.simon.main.MainClass;
import fr.simon.team.Equipe;

public class PlayerWalk implements Listener{

	private MainClass mc;
	public PlayerWalk(MainClass mc) {
		this.mc = mc;
	}

	
	@EventHandler
	public void onPlayerWalk(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Location pl = p.getLocation();
		Equipe eq = mc.el.getTeam(p);
		if(eq != null) {//si le joueur posséde une équipe
			if(eq.getZone() != null) {
				if(eq.getZone().getPorte()!=null) {
					for(Location l : eq.getZone().getPorte()) {
						if(pl.distance(l) < 4) {
							
							
							if(eq.getColor().equals(Color.RED)) {
								//on peut récup le monde de cette facon car lle nether est interdit
								if(p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY() + 1, l.getBlockZ()).getType().equals(Material.RED_STAINED_GLASS)){
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+1, l.getBlockZ()).setType(Material.AIR);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+2, l.getBlockZ()).setType(Material.AIR);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+3, l.getBlockZ()).setType(Material.AIR);
								}
							}else if(eq.getColor().equals(Color.GREEN)) {
								//on peut récup le monde de cette facon car lle nether est interdit
								if(p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY() + 1, l.getBlockZ()).getType().equals(Material.GREEN_STAINED_GLASS)){
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+1, l.getBlockZ()).setType(Material.AIR);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+2, l.getBlockZ()).setType(Material.AIR);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+3, l.getBlockZ()).setType(Material.AIR);
								}
							}else if(eq.getColor().equals(Color.BLUE)) {
								//on peut récup le monde de cette facon car lle nether est interdit
								if(p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY() + 1, l.getBlockZ()).getType().equals(Material.BLUE_STAINED_GLASS)){
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+1, l.getBlockZ()).setType(Material.AIR);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+2, l.getBlockZ()).setType(Material.AIR);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+3, l.getBlockZ()).setType(Material.AIR);
								}
							}else if(eq.getColor().equals(Color.YELLOW)) {
								//on peut récup le monde de cette facon car lle nether est interdit
								if(p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY() + 1, l.getBlockZ()).getType().equals(Material.YELLOW_STAINED_GLASS)){
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+1, l.getBlockZ()).setType(Material.AIR);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+2, l.getBlockZ()).setType(Material.AIR);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+3, l.getBlockZ()).setType(Material.AIR);
								}
							}
						}else {
							
							if(eq.getColor().equals(Color.RED)) {
								//on peut récup le monde de cette facon car lle nether est interdit
								if(!p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY() + 1, l.getBlockZ()).getType().equals(Material.RED_STAINED_GLASS)){
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+1, l.getBlockZ()).setType(Material.RED_STAINED_GLASS);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+2, l.getBlockZ()).setType(Material.RED_STAINED_GLASS);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+3, l.getBlockZ()).setType(Material.RED_STAINED_GLASS);
								}
							}else if(eq.getColor().equals(Color.GREEN)) {
								//on peut récup le monde de cette facon car lle nether est interdit
								if(!p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY() + 1, l.getBlockZ()).getType().equals(Material.GREEN_STAINED_GLASS)){
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+1, l.getBlockZ()).setType(Material.GREEN_STAINED_GLASS);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+2, l.getBlockZ()).setType(Material.GREEN_STAINED_GLASS);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+3, l.getBlockZ()).setType(Material.GREEN_STAINED_GLASS);
								}
							}else if(eq.getColor().equals(Color.BLUE)) {
								//on peut récup le monde de cette facon car lle nether est interdit
								if(!p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY() + 1, l.getBlockZ()).getType().equals(Material.BLUE_STAINED_GLASS)){
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+1, l.getBlockZ()).setType(Material.BLUE_STAINED_GLASS);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+2, l.getBlockZ()).setType(Material.BLUE_STAINED_GLASS);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+3, l.getBlockZ()).setType(Material.BLUE_STAINED_GLASS);
								}
							}else if(eq.getColor().equals(Color.YELLOW)) {
								//on peut récup le monde de cette facon car lle nether est interdit
								if(!p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY() + 1, l.getBlockZ()).getType().equals(Material.YELLOW_STAINED_GLASS)){
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+1, l.getBlockZ()).setType(Material.YELLOW_STAINED_GLASS);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+2, l.getBlockZ()).setType(Material.YELLOW_STAINED_GLASS);
									p.getWorld().getBlockAt(l.getBlockX(), l.getBlockY()+3, l.getBlockZ()).setType(Material.YELLOW_STAINED_GLASS);
								}
							}
						}
						
					}
				}
			}
		}
	}
}

