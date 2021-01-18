package fr.world;

import java.util.Random;
import java.util.Scanner;

import fr.personnage.AbstractCombattant;
import fr.personnage.Monstre;
import fr.personnage.Personnage;

public class Monde {
	
	public static String[] debutNom = new String[] {"chat", "chien", "�cureuil", "cobra", "p�on", "putois", "loup", "chihuahua", "lapin"};
	public static String[] finNom = new String[] {"m�chant", "de feu", "de la mort", "qui tue", "relou", "ninja", "guerrier", "kawa�"};

	/**
	* Cr�er un personnage avec tous ses attributs. 
	* Demande a l'utilisateur d'entrer le nom du personnage.
	* retour: une instance de la classe Personnage correctement instanci�.
	**/
	public static Personnage personnageFactory() {
		// Demander a l'utilisateur un nom de personnage
	    // Creer un nouveau personnage en utilisant le constructeur avec tous ses params (dont le nom qui vient d'�tre choisi par l'utilisateur)
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
	public static void afficherInformations(AbstractCombattant p) {
		
		System.out.println(p);
	}
	
	/**
	* Cr�er un monstre avec tous ses attributs. 
	* Le nom du monstre est randomis�.
	* retour: une instance de la classe Monstre correctement instanci�.
	**/
	public static Monstre MonstreFactory() {
		String nom = debutNom[new Random().nextInt(debutNom.length)] + " " + finNom[new Random().nextInt(finNom.length)];		
		
		return new Monstre(50, 15, nom);
	}
	
	/**
	 * Lance un combat entre un personnage et un monstre
	 * @param Personnage personnage : un personnage
	 * @param Monstre monstre : un monstre
	 */
	public static void combat(Personnage personnage, Monstre monstre) {
		boolean turn;
		while(personnage.pointDeVie > 0 && monstre.pointDeVie > 0) {
			turn = new Random().nextBoolean();
			if(turn) {
				personnage.attaquer(monstre);
			} else {
				monstre.attaquer(personnage);
			}
			afficherInformations(personnage);
			afficherInformations(monstre);
		}
		System.out.println("vainqueur: " + (personnage.pointDeVie > 0 ? personnage : monstre));
	}
}
