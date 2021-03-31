package fr.simon.main;

import org.bukkit.plugin.java.JavaPlugin;

import fr.simon.arene.Arene;
import fr.simon.arene.AreneCommande;
import fr.simon.event.CloseChest;
import fr.simon.event.JoinQuitEvent;
import fr.simon.event.PlayerWalk;
import fr.simon.event.RespawnPlayer;
import fr.simon.scoreboard.ScoreBoardManager;
import fr.simon.scoreboard.Timer;
import fr.simon.start.End;
import fr.simon.start.RulesCommande;
import fr.simon.start.StartCommande;
import fr.simon.team.EquipeCommande;
import fr.simon.team.EquipeList;
import fr.simon.zone.ZoneCommande;

public class MainClass extends JavaPlugin {

	
	public EquipeList el;
	public Arene ar;
	public ScoreBoardManager sbm;
	public Timer timer;
	public boolean play = false;
	public boolean coffre = true;
	public End e;
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		
		
		el = new EquipeList(this); //création d'une nouvelle instance de liste d'équipe au lancement du pl 
		ar = new Arene(this);
		sbm = new ScoreBoardManager(this);
		timer = new Timer(this);
		e = new End(this);
		
		
		
		this.getCommand("mcarene").setExecutor(new AreneCommande(this));
		this.getCommand("mczone").setExecutor(new ZoneCommande(this));
		this.getCommand("mcteam").setExecutor(new EquipeCommande(this));
		this.getCommand("start").setExecutor(new StartCommande(this));
		this.getCommand("rules").setExecutor(new RulesCommande(this));
		
		
		this.getServer().getPluginManager().registerEvents(new PlayerWalk(this), this);
		this.getServer().getPluginManager().registerEvents(new CloseChest(this), this);		
		this.getServer().getPluginManager().registerEvents(new RespawnPlayer(this), this);
		this.getServer().getPluginManager().registerEvents(new JoinQuitEvent(this),this);
	}
	
}
