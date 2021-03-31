package fr.simon.start;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.simon.main.MainClass;
import net.md_5.bungee.api.ChatColor;

public class StartCommande implements CommandExecutor{

	private MainClass mc;
	
	public StartCommande(MainClass mc) {
		this.mc = mc;
	}
	
	public static String[] regle = {ChatColor.DARK_PURPLE + "Le but est simple : ramener le maximum de " + ChatColor.RED +"minerais" +ChatColor.DARK_PURPLE + " dans le coffre présent dans votre base en une heure",ChatColor.DARK_PURPLE + "Chaque minerai ramene un certain nombre de points : " + ChatColor.WHITE +" Fer = 10pts," + ChatColor.GOLD +" Or = 50pts," + ChatColor.AQUA + " Diamand=150pts," + ChatColor.GREEN +" Emeraude = 300pts",ChatColor.DARK_PURPLE + "Le PvP est activé, pas le nether !", ChatColor.DARK_PURPLE + "Les bases sont des lieux sécurisés, il est interdit de miner ou de taper dedans",ChatColor.DARK_PURPLE + "Au bout d'un certain temps aléatoire, un coffre spawnera au milieu de l'arène.",ChatColor.DARK_PURPLE + "Vous serez prévenus 10 secondes avant et vous aurez jusqu'à l'apparition du coffre pour vous téléporter",ChatColor.DARK_PURPLE +  "pour ce faire utilisez la commande" +ChatColor.GRAY+ " /mcarene tp"};
	
	@Override
	public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {

		if(snd instanceof Player) {		
			// /start
			
			
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.getInventory().clear();
				
				p.sendTitle(ChatColor.AQUA + "Mineral Conquest !",ChatColor.GREEN + "Que les meilleurs gagnent !",10,70,10);
				
				p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
				p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
				p.setExp(0);
				
				p.teleport(mc.el.getTeam(p).getZone().getCofre());
				p.sendMessage(regle);
				
				p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 10));
				
				p.setGameMode(GameMode.SURVIVAL);
				p.setHealth(20);
				p.setFoodLevel(20);
				p.getWorld().setTime(0);
				
				mc.play = true;
				
			}
			
		}
		
		return false;
	}

}
