package fr;

import fr.personnage.Groupe;
import fr.personnage.Monstre;
import fr.personnage.Personnage;
import fr.world.Monde;

public class Run {

	public static void main(String[] args) {
		
		System.out.println("Bonjour aventurier, bienvenue. 1�re �tape, il faut cr�er ton personnage! ");
//		Personnage p1 = Monde.personnageFactory();
//		Monstre m1 = Monde.monstreFactory();
//		
//		Monde.afficherInformations(p1);
//		System.out.println(m1);
		
//		Monde.combat(p1, m1);
//		Groupe monstres = Monde.creationGroupeMonstre(10);
//		Groupe heros = Monde.creationGroupePersonnage(5);
//		System.out.println(monstres);
//		System.out.println(heros);
//		Monde.genese();
		Monde.combatGroupe();
	}

	
}
