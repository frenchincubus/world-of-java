package fr;

import fr.personnage.Personnage;
import fr.world.Monde;

public class Run {

	public static void main(String[] args) {
		
		System.out.println("Bonjour aventurier, bienvenue. 1�re �tape, il faut cr�er ton personnage! ");
		Personnage p1 = Monde.personnageFactory();
		
		Monde.afficherInformations(p1);
	}

	
}
