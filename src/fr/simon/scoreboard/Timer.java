package fr.simon.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import fr.simon.main.MainClass;

public class Timer {

	private MainClass mc;
	private int seconde, minute;
	
	public int minuteCoffre, secondeCoffre;
	
	public Timer(MainClass mc) {
		this.mc = mc;
		this.minuteCoffre = (int) ((Math.random()*4) +8);
		this.secondeCoffre = (int) ((Math.random()*49)+10);
		clock();
	}
	
	public void clock() {
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(mc, new Runnable() {
            @Override
            public void run() {
            	if(mc.play) {
            		mc.sbm.removeLine(minute + " : " + seconde);
            		seconde++;
                    if(seconde == 60) {
                    	seconde = 0;
                    	minute++;
                    }
                    mc.sbm.addLine(minute + " : " + seconde,0);
                    

                    if(minute == minuteCoffre && seconde == secondeCoffre-10) {
                    	
                    	for(Player p : Bukkit.getOnlinePlayers()) {
                    		p.sendTitle("Le coffre va apparaitre", "Vous avez 10 secondes pour vous tp avec /mcarene tp", 10, 80, 10);
                    	}
                    	
                    	mc.ar.teleport = true;
                    }
                    if(minute == minuteCoffre && seconde ==secondeCoffre) {
                    	mc.ar.setCoffre(mc.ar.getCoffre().getWorld());
                		minuteCoffre = (int) ((Math.random()*4) +8) + minute;
                		secondeCoffre = (int) ((Math.random()*49)+10);
                    }
                    
                    
                    if(minute == 40) {
                    	mc.e.end();
                    }
            	}
            }
        }, 20,20);
	}
}
