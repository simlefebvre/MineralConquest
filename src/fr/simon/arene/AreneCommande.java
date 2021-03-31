package fr.simon.arene;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simon.main.MainClass;
import fr.simon.team.Equipe;
import net.md_5.bungee.api.ChatColor;

public class AreneCommande implements CommandExecutor {

	private MainClass mc;
	
	public AreneCommande(MainClass mc) {
		this.mc = mc;
	}

	@Override
	public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {
		// /mcarene setcoffre [x y z]
		// /mcarene random
		// /mcarene tp
		// /mcarene on
		if(snd instanceof Player) {
			Player p = (Player) snd;
			
			if(args[0].equalsIgnoreCase("setcoffre")) {
				Location coffre = new Location(p.getWorld(), Integer.valueOf(args[1]), Integer.valueOf(args[2]), Integer.valueOf(args[3]));
				
				mc.ar.setCoffreLocation(coffre);
				
			}else if(args[0].equalsIgnoreCase("random")) {
				mc.ar.setCoffre(p.getWorld());
			}else if(args[0].equalsIgnoreCase("on")) {
				mc.ar.teleport = true;
			}else if(args[0].equalsIgnoreCase("tp")) {
				Equipe eq = mc.el.getTeam(p);
				if(eq == null) {
					p.sendMessage("Tu n'as pas d'équipe");
				}
				else {
					if(mc.ar.teleport) {
						for(Player pe : eq.getPlayers()) {
							pe.teleport(eq.getZone().getArene());
						}
					}else {
						p.sendMessage(ChatColor.RED + "Vous ne pouvez pas vous téléporter maintenant !");
					}
				}
			}else if(args[0].equalsIgnoreCase("chrono")) {
				p.sendMessage(mc.timer.minuteCoffre + " : " + mc.timer.secondeCoffre);
			}
		}
		return false;
	}
}
