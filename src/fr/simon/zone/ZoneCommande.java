package fr.simon.zone;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simon.main.MainClass;
import fr.simon.utils.Couleur;

public class ZoneCommande implements CommandExecutor{

	private MainClass mc;
	
	public ZoneCommande(MainClass mc) {
		this.mc = mc;
	}
	
	@Override
	public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {

		if(snd instanceof Player) {
			Color c = Couleur.getColor(args[1]);
			Player p = (Player) snd;
			// /mczone add [couleur] [x1] [y1] [z1] [x2] [y2] [z2]
			// /mczone addcoffre [couleur]
			// /mczone addporte [couleur]
			// /mczone addarene [couleur]
			
			// coo 1 = bas gauche
			// coo 2 = haut droite
				if(c ==null) {
					p.sendMessage("La couleur n'est pas bonne");
				}else {
				if(args[0].equalsIgnoreCase("add")) {	
					Location bg = new Location(p.getWorld(), Integer.valueOf(args[2]), Integer.valueOf(args[3]), Integer.valueOf(args[4]));
					Location hd = new Location(p.getWorld(), Integer.valueOf(args[5]), Integer.valueOf(args[6]), Integer.valueOf(args[7]));
					Zone z = new Zone(bg, hd);
					mc.el.getTeam(c).setZone(z);;
						
				}else if(args[0].equalsIgnoreCase("addcoffre")) {
					Location coffre = new Location(p.getWorld(), Integer.valueOf(args[2]), Integer.valueOf(args[3]), Integer.valueOf(args[4]));
					mc.el.getTeam(c).getZone().setCofre(coffre);
					p.sendMessage("Le coffre a été set");
				}else if(args[0].equalsIgnoreCase("addarene")) {
					Location arene = new Location(p.getWorld(), Integer.valueOf(args[2]), Integer.valueOf(args[3]), Integer.valueOf(args[4]));
					mc.el.getTeam(c).getZone().setArene(arene);
					p.sendMessage("L'arène a été set");
				}else if(args[0].equalsIgnoreCase("addporte")) {
					Location porte = new Location(p.getWorld(), Integer.valueOf(args[2]), Integer.valueOf(args[3]), Integer.valueOf(args[4]));
					mc.el.getTeam(c).getZone().addPorte(porte);
					p.sendMessage("La porte a été set");
					
				}
			}
		}
			return false;
	}
}
