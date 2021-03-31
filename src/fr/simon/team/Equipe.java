package fr.simon.team;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.entity.Player;

import fr.simon.zone.Zone;

public class Equipe {

	//private MainClass mc;
	private ArrayList<UUID> UUIDs; //liste des UUID permettant de remettre les joueurs dans leur équipe lors de leur reco
	private ArrayList<Player> players; //liste des joueurs composant l'équipe
	private Color c; //couleur de l'équipe (servant d'identifiant)
	private Zone z = null; //zone correspondant à la base sécuriser
	private int point; //nombre de points que posséde l'équipe
	
	public Equipe(Color c) { //constructeur avec uniquement la couleur qui crée une liste vierge
		this.players = new ArrayList<Player>();
		this.UUIDs = new ArrayList<UUID>();
		this.c = c;
		this.point = 0;
	}
	
	//getter et setter de la zone
	public Zone getZone() {
		return this.z;
	}
	
	public void setZone(Zone newZone) {
		this.z = newZone;
		
	}
	
	//ajout d'un joueur à l'équipe
	public void addPlayer(Player p) {
		this.players.add(p);
		if(!this.UUIDs.contains(p.getUniqueId())) {
			this.UUIDs.add(p.getUniqueId());
		}
	}
	
	//enléve un joueur de l'équipe (retourne false si échec (donc équipe inchangé) true sinon)
	public boolean removePlayer(Player p) {
		return this.players.remove(p);
	}
	
	//vérifie si l'équipe contien le joueur p
	public boolean containPlayer(Player p) {
		return this.players.contains(p);
	}
	
	public void addPoint(int p) {
		this.point= this.point + p;
	}
	
	public boolean isColor(Color c) {
		return this.c.equals(c);
	}
	
	public Color getColor() {
		return this.c;
	}
	
	public ArrayList<Player> getPlayers(){
		return this.players;
	}

	public int getPoint() {
		return this.point;
	}

	public ArrayList<UUID> getUUIDs() {
		return UUIDs;
	}

	public void setUUIDs(ArrayList<UUID> uUIDs) {
		UUIDs = uUIDs;
	}

	public boolean containPlayer(UUID id) {
		return this.UUIDs.contains(id);
	}
}
