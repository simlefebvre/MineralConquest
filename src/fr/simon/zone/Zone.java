package fr.simon.zone;

import java.util.ArrayList;

import org.bukkit.Location;

public class Zone {

	private Location bg;
	private Location hd;
	private Location cofre = null;
	private ArrayList<Location> porte;
	private Location arene = null;
	
	public Zone(Location bg, Location hd) {
		this.bg = bg;
		this.hd = hd;
		this.porte = new ArrayList<>();
	}
	
	public Location getCofre() {
		return this.cofre;
	}
	
	public void setCofre(Location newCoffre) {
		this.cofre = newCoffre;
	}

	public void setArene(Location newArene) {
		this.arene = newArene;
	}
	
	public Location getArene() {
		return this.arene;
	}
	
	public boolean isInZone(Location l) {
		if(l.getY() <= hd.getY() && l.getY() >= bg.getY()) {
			if(l.getX() <= hd.getX() && l.getX() >= bg.getX()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	
	public ArrayList<Location> getPorte() {
		return porte;
	}

	public void addPorte(Location porte) {
		this.porte.add(porte);
	}
	
}
