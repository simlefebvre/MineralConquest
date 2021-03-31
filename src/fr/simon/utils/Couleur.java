package fr.simon.utils;

import org.bukkit.Color;

public class Couleur {

	public static Color getColor(String s) {
		if(s.equalsIgnoreCase("bleu") || s.equalsIgnoreCase("blue")) {
			return Color.BLUE;

		}else if(s.equalsIgnoreCase("rouge") || s.equalsIgnoreCase("red")) {
			return Color.RED;
		}else if(s.equalsIgnoreCase("jaune") || s.equalsIgnoreCase("yellow")) {
			return Color.YELLOW;
		}else if(s.equalsIgnoreCase("vert") || s.equalsIgnoreCase("green")) {
			return Color.GREEN;
		}else {
			return null;
		}
		
	}
	
}
