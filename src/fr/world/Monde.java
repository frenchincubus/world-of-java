package fr.world;

import java.util.Random;
import java.util.Scanner;

import fr.personnage.Monstre;
import fr.personnage.Personnage;

public class Monde {
	
	public static String[] debutNom = new String[] {"chat", "chien", "écureuil", "cobra", "péon", "putois", "loup", "chihuahua", "lapin"};
	public static String[] finNom = new String[] {"méchant", "de feu", "de la mort", "qui tue", "relou", "ninja", "guerrier", "kawaï"};

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
	
	/**
	 * Affiche les informations du monde
	 * @param p
	 */
	public static void afficherInformations(Personnage p) {
		
		System.out.println(p);
	}
	
	/**
	* Créer un monstre avec tous ses attributs. 
	* Demande a l'utilisateur d'entrer le nom du monstre.
	* retour: une instance de la classe Monstre correctement instancié.
	**/
	public static Monstre MonstreFactory() {
		String nom = debutNom[new Random().nextInt(debutNom.length)] + " " + finNom[new Random().nextInt(finNom.length)];		
		
		return new Monstre(50, 15, nom);
	}
	
	
}
