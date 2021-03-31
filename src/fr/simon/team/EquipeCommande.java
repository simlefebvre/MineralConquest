package fr.simon.team;

import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simon.main.MainClass;
import fr.simon.utils.Couleur;
import net.md_5.bungee.api.ChatColor;

public class EquipeCommande implements CommandExecutor{

	private MainClass mc;
	public EquipeCommande(MainClass mc) {
		this.mc = mc;
	}
	
	
	//on arrive ici en faisant un /mcteam
	@Override
	public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {
		
		// /mcteam add [couleur] : création de l'équipe
		// /mcteam list : affiche une liste des équipes et de leur joueurs
		// /mcteam join [couleur] {joueur} : ajoute le joueur a l'équipe si aucun psoeudo ajoute le sender

		
		if(snd instanceof Player) {
			Player p = (Player) snd;
			if(p.isOp()) {
				//ajout d'une nouvelle équipe (4 possibilité pour l'instant)
				if(args[0].equalsIgnoreCase("add")) {
					Color c = Couleur.getColor(args[1]);
					if(c != null) {
						if(mc.el.getTeam(c) == null) {
							mc.el.addTeam(new Equipe(c));
							p.sendMessage("L'équipe " + c + " a bien été créée");
						}
						else {
							p.sendMessage("L'équipe " + c + " existe déjà");
						}
					}else {
						p.sendMessage("Erreur lors de la création de l'équipe : couleur impossible");
					}

					//affiche la liste des différentes équipes
				}else if(args[0].equalsIgnoreCase("list")) { 
					for(Equipe e : mc.el.getList()) {
						p.sendMessage("Equipe " + e.getColor() + " est composée de : " );
						for(Player pl : e.getPlayers()) {
							p.sendMessage(pl.getName());
						}
					}
					//permet de faire rejoindre un joueur dans une équipe
				}else if(args[0].equalsIgnoreCase("join")) {
					Player pl = mc.getServer().getPlayer(args[2]);
					if(pl != null) {
						Color c = Couleur.getColor(args[1]);
						Equipe e = mc.el.getTeam(c);
						if(e != null) {
							
							for(Equipe eq : mc.el.getList()) {
								if(eq.containPlayer(pl)) {
									eq.removePlayer(pl);
								}
							}
							
							
							pl.sendMessage("Tu as été rajouté à l'équipe " + args[1]);
							if(args[1].equalsIgnoreCase("rouge")) {
								pl.setPlayerListName(ChatColor.RED + pl.getName()) ;
								pl.setDisplayName(ChatColor.RED + pl.getName() + ChatColor.WHITE);
								e.addPlayer(pl);
							}else if(args[1].equalsIgnoreCase("bleu")) {
								pl.setPlayerListName(ChatColor.BLUE + pl.getName()) ;
								pl.setDisplayName(ChatColor.BLUE + pl.getName() + ChatColor.WHITE);
								e.addPlayer(pl);
							}else if(args[1].equalsIgnoreCase("jaune")) {
								pl.setPlayerListName(ChatColor.YELLOW + pl.getName()) ;
								pl.setDisplayName(ChatColor.YELLOW + pl.getName() + ChatColor.WHITE);
								e.addPlayer(pl);
							}
							
						}else {
							p.sendMessage("Erreur sur l'ajout du joueur (équipe non trouvée)");
						}
					}else {
						p.sendMessage("Erreur sur l'ajout du joueur (pl = null)");
					}
				}
			}
		}
		
		return false;
	}

}
