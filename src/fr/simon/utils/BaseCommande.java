package fr.simon.utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simon.main.MainClass;

public class BaseCommande implements CommandExecutor {

	private MainClass mc;
	public BaseCommande(MainClass mc) {
		this.mc = mc;
	}
	
	@Override
	public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {

		if(snd instanceof Player) {
			Player p  = (Player) snd;
			p.sendMessage(mc.el.getTeam(p).getZone().getCofre().toString());
		}
		
		return false;
	}

}
