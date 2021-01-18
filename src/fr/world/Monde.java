package fr.world;

import java.util.Scanner;

import fr.personnage.Personnage;

public class Monde {
	
	static Personnage p1;

	/**
	* Créer un personnage avec tous ses attributs. 
	* Demande a l'utilisateur d'entrer le nom du personnage.
	* retour: une instance de la classe Personnage correctement instancié.
	**/
	public static Personnage personnageFactory() {
		// Demander a l'utilisateur un nom de personnage
	    // Creer un nouveau personnage en utilisant le constructeur avec tous ses params (dont le nom qui vient d'être choisi par l'utilisateur)
	    // Retourner l'instance du personnage
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer le nom de votre personnage: ");
		String nom = sc.nextLine();		
		sc.close();
		
		return new Personnage(50, 15, nom);
	}
	
	public static void afficherInformations(Personnage p) {
		
		System.out.println(p);
	}
}
