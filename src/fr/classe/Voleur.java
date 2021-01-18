package fr.classe;

import java.util.ArrayList;
import java.util.List;

import fr.personnage.BasicAttaque;
import fr.personnage.IAttaque;

public class Voleur extends Classe {

	public Voleur() {
		super("voleur", attaques());
	}
	
	private static List<IAttaque> attaques() {
		List<IAttaque> listeAttaques = new ArrayList<>();
		BasicAttaque dague = new BasicAttaque("dague", "un coup de dague dans le flanc", 8, 80.0);
		BasicAttaque piege = new BasicAttaque("piège", "un piège pour berner l'ennemi !", 20, 60.0);
		BasicAttaque corde = new BasicAttaque("corde", "Etranglement de l'ennemi, attention, les fantômes n'ont pas de cou", 30, 30.0);
		
		listeAttaques.add(dague);
		listeAttaques.add(piege);
		listeAttaques.add(corde);
		
		return listeAttaques;
	}
}
