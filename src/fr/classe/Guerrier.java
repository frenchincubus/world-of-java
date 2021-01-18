package fr.classe;

import java.util.ArrayList;
import java.util.List;

import fr.personnage.BasicAttaque;
import fr.personnage.IAttaque;

public class Guerrier extends Classe {
	

	public Guerrier() {
		super("Guerrier", attaquesGuerrier());
	}
	
	private static List<IAttaque> attaquesGuerrier() {
		List<IAttaque> listeAttaques = new ArrayList<>();
		BasicAttaque epee = new BasicAttaque("épée", "un coup d'épée dans l'eau", 8, 60.0);
		BasicAttaque coupDeBoule = new BasicAttaque("coup de boule", "coup de boule dans les naseaux !", 12, 70.0);
		BasicAttaque coupDeBotte = new BasicAttaque("coup de botte", "coup de bottes en peau de troll dans les valseuses", 20, 30.0);
		
		listeAttaques.add(epee);
		listeAttaques.add(coupDeBoule);
		listeAttaques.add(coupDeBotte);
		
		return listeAttaques;
	}
}
