package fr;

import fr.personnage.Monstre;
import fr.personnage.Personnage;
import fr.world.Monde;

public class Run {

	public static void main(String[] args) {
		
		System.out.println("Bonjour aventurier, bienvenue. 1ère étape, il faut créer ton personnage! ");
		Personnage p1 = Monde.personnageFactory();
		Monstre m1 = new Monstre(50,15, "Bleurp");
		
		Monde.afficherInformations(p1);
		System.out.println(m1);
	}

	
}
