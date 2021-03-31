package fr.simon.start;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.simon.main.MainClass;

public class RulesCommande implements CommandExecutor {
	
private MainClass mc;
	
	public RulesCommande(MainClass mc) {
		this.mc = mc;
	}
	
	@Override
	public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {
		
		snd.sendMessage(StartCommande.regle);
		
		return false;
	}

	

}
