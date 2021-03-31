package fr.simon.event;

import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.simon.main.MainClass;
import fr.simon.team.Equipe;
import net.md_5.bungee.api.ChatColor;

public class JoinQuitEvent implements Listener{
	
	private MainClass mc;
	public JoinQuitEvent(MainClass mc) {
		this.mc = mc;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		mc.sbm.PrintSb();
		
		UUID id = p.getUniqueId();
		Equipe e2 = mc.el.getTeam(id);
		e2.addPlayer(p);
		
		if(e2.getColor().equals(Color.RED)) {
			p.setPlayerListName(ChatColor.RED + p.getName()) ;
			p.setDisplayName(ChatColor.RED + p.getName() + ChatColor.WHITE);
		}else if(e2.getColor().equals(Color.BLUE)) {
			p.setPlayerListName(ChatColor.BLUE + p.getName()) ;
			p.setDisplayName(ChatColor.BLUE + p.getName() + ChatColor.WHITE);
		}else if(e2.getColor().equals(Color.YELLOW)) {
			p.setPlayerListName(ChatColor.YELLOW + p.getName()) ;
			p.setDisplayName(ChatColor.YELLOW + p.getName() + ChatColor.WHITE);
		}
	}

}
