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
	public static Scanner sc = new Scanner(System.in);

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
//		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer le nom de votre personnage: ");
		String nom = sc.nextLine();		
		
		System.out.println("Choisissez votre classe de combattant (guerrier, mage, voleur)");
		String classe = sc.nextLine();
//		sc.close();
		
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
		
		return new Monstre(40, 8, nom);
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
	
	/**
	 * Crée un groupe de personnages prêts à attaquer
	 * @param int nombrePersonnages
	 * @return Groupe un groupe de personnages
	 */
	public static Groupe creationGroupePersonnage(int nombrePersonnages) {
		
		Groupe groupePersonnages = new Groupe();
		for(int i=0; i<nombrePersonnages; i++) {
			Personnage p = personnageFactory();
			groupePersonnages.addCombattant(p);
		}
		
		return groupePersonnages;
	}
	
	/**
	 * Menu de démarrage
	 */
	public static void genese() {
		System.out.print("---***--- Bonjour ---***---\nChoisir une option:\n1: Lancer un combat 1v1\n2: Lancer un combat de groupe\n3: One vs World Hardcore Edition\n4: Informations\n---------------------------\n>>>");
	}
	
	/**
	 * Lance un combat 1v1 
	 */
	public static void combat1v1() {
		Personnage p = personnageFactory();
		Monstre m = monstreFactory();
		
		combat(p, m);
	}
	
	/**
	 * Lance un combat entre un groupe de personnages et un groupe de monstres
	 */
	public static void combatGroupe() {
		System.out.println("Saisissez le nombre de monstres à attaquer");
		int nbMonstres = sc.nextInt();
		Groupe groupeMonstres = creationGroupeMonstre(nbMonstres);
		System.out.println("Saisissez le nombre de héros");
		int nbPersos = sc.nextInt();
		sc.nextLine();
		Groupe groupePersos = creationGroupePersonnage(nbPersos);
		
		while(!groupeMonstres.estMort() && !groupePersos.estMort()) {
			Personnage p = (Personnage) groupePersos.attaquer();
			Monstre m = (Monstre) groupeMonstres.attaquer();
			if (p.estVivant() && m.estVivant()) {
				System.out.println("\n" + p.getNom() + " vs " + m.getNom() + "\n");
				combat(p, m);
			}
		}
		System.out.println("Vainqueur: " + (groupeMonstres.estMort() ? "Groupe de Héros" : "Groupe de monstres"));
	}
	
	/**
	 * lance un combat solo contre un groupe de monstre
	 */
	public static void combatSolo() {
		System.out.println("Saisissez le nombre de monstres à attaquer");
		int nbMonstres = sc.nextInt();
		Groupe groupeMonstres = creationGroupeMonstre(nbMonstres);
		sc.nextLine();
		Personnage p = personnageFactory();
		int vieTotale = p.getPointDeVie() + 30*nbMonstres;
		System.out.println("la bataille sera rude, la déesse du combat vous octroie un bonus, vos PV sont de " + vieTotale);
		p.setPointDeVie(vieTotale);
		
		while(p.estVivant() && !groupeMonstres.estMort()) {
			Monstre m = (Monstre) groupeMonstres.attaquer();
			if(m.estVivant()) {
				System.out.println("\n" + p.getNom() + " vs " + m.getNom() + "\n");
				combat(p, m);
			}
		}
		System.out.println("Vainqueur: " + (groupeMonstres.estMort() ? p.getNom() : "groupe de monstres"));
	}
	
	
}
