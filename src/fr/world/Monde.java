package fr.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import fr.classe.Classe;
import fr.classe.Guerrier;
import fr.classe.Mage;
import fr.classe.Voleur;
import fr.personnage.AbstractCombattant;
import fr.personnage.Groupe;
import fr.personnage.Monstre;
import fr.personnage.Personnage;

public class Monde {
	
	public static String[] debutNom = new String[] {"chat", "chien", "écureuil", "cobra", "péon", "putois", "loup", "chihuahua", "lapin"};
	public static String[] finNom = new String[] {"méchant", "de feu", "de la mort", "qui tue", "relou", "ninja", "guerrier", "kawaï"};
	public static Map<String, Classe> dictionnaire = new HashMap<>();
	public static List<Monstre> listeMonstres = new ArrayList<>();

	/**
	* Créer un personnage avec tous ses attributs. 
	* Demande a l'utilisateur d'entrer le nom du personnage.
	* retour: une instance de la classe Personnage correctement instancié.
	**/
	public static Personnage personnageFactory() {
		// Demander a l'utilisateur un nom de personnage
	    // Creer un nouveau personnage en utilisant le constructeur avec tous ses params (dont le nom qui vient d'être choisi par l'utilisateur)
	    // Retourner l'instance du personnage
		dictionnaire.put("guerrier", new Guerrier());
		dictionnaire.put("mage", new Mage());
		dictionnaire.put("voleur", new Voleur());
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer le nom de votre personnage: ");
		String nom = sc.nextLine();		
		
		System.out.println("Choisissez votre classe de combattant (guerrier, mage, voleur)");
		String classe = sc.nextLine();
		sc.close();
		
		Classe classePersonnage = getClasse(classe);
		
		return new Personnage(50, 15, nom, classePersonnage);
	}
	
	/**
	 * Affiche les informations du monde
	 * @param p
	 */
	public static void afficherInformations(AbstractCombattant p) {
		
		System.out.println(p);
	}
	
	/**
	* Créer un monstre avec tous ses attributs. 
	* Le nom du monstre est randomisé.
	* retour: une instance de la classe Monstre correctement instancié.
	**/
	public static Monstre monstreFactory() {
		String nom = debutNom[randomFunction(debutNom.length)] + " " + finNom[randomFunction(finNom.length)];		
		
		return new Monstre(50, 10, nom);
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
	
	/**
	 * Retourne un int random en fonction d'une borne maximale
	 * @param int borneMax : le maximal de l'interval a randomiser
	 * @return int le résultat
	 */
	public static int randomFunction(int borneMax) {
		return new Random().nextInt(borneMax);
	}
	
	/**
	 * Retourne la classe associée du dictionnaire
	 * @param String nom : nom de la classe à retourner 
	 * @return la classe ou null si pas de résultat
	 */
	public static Classe getClasse(String nom) {
		return dictionnaire.get(nom);
	}
	
	/**
	 * Crée une liste de 30 monstres 
	 */
	public static void initialiseListeMonstres() {
		for (int i=0; i<=30; i++) {
			listeMonstres.add(monstreFactory());
		}
	}
	
	/**
	 * Crée un groupe de monstres prêts à attaquer parmi la liste de monstres
	 * @param int nombreMonstres
	 * @return Groupe un groupe de monstres
	 */
	public static Groupe creationGroupeMonstre(int nombreMonstres) {
		if (listeMonstres.isEmpty()) {
			initialiseListeMonstres();
		}
		
		Groupe groupeMonstres = new Groupe();
		for(int i=0; i<nombreMonstres; i++) {
			groupeMonstres.addCombattant(listeMonstres.get(randomFunction(listeMonstres.size())));
		}
		
		return groupeMonstres;
	}
}
