package fr.simon.team;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.entity.Player;

import fr.simon.main.MainClass;

public class EquipeList {

	private ArrayList<Equipe> equipes; //liste des équipes
	private MainClass mc;
	
	public EquipeList(MainClass mc) {//constructeur par défaut qui instancie une liste vide
		this.equipes = new ArrayList<Equipe>();
		this.mc = mc;
	}
	
	//vérifie si la liste contien l'equipe e
	public boolean containTeam(Equipe e) { 
		return equipes.contains(e);
	}
	
	//ajoute une équipe à la liste
	public void addTeam(Equipe e) {
		this.equipes.add(e);
	}
	
	//suprime une équipe à la liste (retourne false si erreur)
	public boolean removeTeam(Equipe e) {
		return this.equipes.remove(e);
	}
	
	//on par du principe que le retour ce fait par référence /!\ Erreur possible ici !!! /!\
	//récupére l'équipe d'un joueur un particulier (en tt cas la premiére occurence)
	//retourne null si le joueur n'est pas présent
	public Equipe getTeam(Player p) {
		for(Equipe e : this.equipes){
			if(e.containPlayer(p)) {
				return e;
			}
		}
		return null;
	}
	
	public Equipe getTeam(UUID id) {
		for(Equipe e : this.equipes){
			if(e.containPlayer(id)) {
				return e;
			}
		}
		return null;
	}
	
	public Equipe getTeam(Color c) {
		for(Equipe e : this.equipes){
			if(e.isColor(c)) {
				return e;
			}
		}
		return null;
	}
	
	public ArrayList<Equipe> getList() {
		return this.equipes;
	}
	
}
