package fr.classe;

import java.util.ArrayList;
import java.util.List;

import fr.personnage.BasicAttaque;
import fr.personnage.IAttaque;

public class Mage extends Classe {

	public Mage() {
		super("Mage", attaques());
	}
	
	private static List<IAttaque> attaques() {
		List<IAttaque> listeAttaques = new ArrayList<>();
		BasicAttaque baton = new BasicAttaque("bâton", "un coup de bâton sur la caboche", 6, 60.0);
		BasicAttaque bouleDeFeu = new BasicAttaque("boule de feu", "une boule de feu puiss... puissiez-vous réussir à la lancer !", 25, 45.0);
		BasicAttaque bouleDeGlace = new BasicAttaque("boule de glace", "utile l'été pour garnir un cornet, l'ogre en raffole", 20, 55.0);
		
		listeAttaques.add(baton);
		listeAttaques.add(bouleDeFeu);
		listeAttaques.add(bouleDeGlace);
		
		return listeAttaques;
	}
}
