package fr.simon.start;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.Player;

import fr.simon.main.MainClass;
import fr.simon.team.Equipe;
import net.md_5.bungee.api.ChatColor;

public class End {

	private int max =0;
	private Color cMax;
	
	private MainClass mc;
	public End(MainClass mc) {
		this.mc = mc;
	}
	
	public void end() {
		
		mc.play = false;
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.teleport(mc.ar.getCoffre());
		}
		Bukkit.broadcastMessage("-=-=-=--=-Fin de la partie-=-=-=-=-");
		
		for(Equipe eq : mc.el.getList()) {
			if(eq.getColor().equals(Color.RED)) {
				Bukkit.broadcastMessage(ChatColor.RED + "L'Equipe rouge a obtenu " + eq.getPoint() + "points");
			}else if(eq.getColor().equals(Color.BLUE)) {
				Bukkit.broadcastMessage(ChatColor.BLUE + "L'Equipe bleu a obtenu " + eq.getPoint() + "points");
			}else if(eq.getColor().equals(Color.YELLOW)) {
				Bukkit.broadcastMessage(ChatColor.YELLOW + "L'Equipe jaune a obtenu " + eq.getPoint() + "points");
			}
			
			if(max < eq.getPoint()) {
				max = eq.getPoint();
				cMax = eq.getColor();
			}
		}	
		
		
		for(Player p:Bukkit.getOnlinePlayers()) {

			if(cMax.equals(Color.RED)) {
				p.sendTitle(ChatColor.RED + "Féliciations aux Rouges",ChatColor.RED +  "ils remportent avec " + mc.el.getTeam(Color.RED).getPoint() + " points !", 10, 70, 10);				
			}else if(cMax.equals(Color.BLUE)) {
				p.sendTitle(ChatColor.BLUE + "Féliciations aux Bleux", ChatColor.BLUE + "ils remportent avec " + mc.el.getTeam(Color.BLUE).getPoint() + " points !", 10, 70, 10);
			}else if(cMax.equals(Color.YELLOW)) {
				p.sendTitle(ChatColor.YELLOW + "Féliciations aux Jaunes", ChatColor.YELLOW + "ils remportent avec " + mc.el.getTeam(Color.YELLOW).getPoint() + " points !", 10, 70, 10);
			}	
		}
	}
	
}
