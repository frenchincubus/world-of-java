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
import fr.personnage.BasicAttaque;
import fr.personnage.Groupe;
import fr.personnage.IAttaque;
import fr.personnage.Monstre;
import fr.personnage.Personnage;

public class Monde {
	
	public static String[] debutNom = new String[] {"chat", "chien", "écureuil", "cobra", "péon", "putois", "loup", "chihuahua", "lapin"};
	public static String[] finNom = new String[] {"méchant", "de feu", "de la mort", "qui tue", "relou", "ninja", "guerrier", "kawaï"};
	public static Map<String, Classe> dictionnaire = new HashMap<>();
	public static List<Monstre> listeMonstres = new ArrayList<>();
	public static List<IAttaque> listeAttaques = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);

	/**
	* Créer un personnage avec tous ses attributs. 
	* Demande a l'utilisateur d'entrer le nom du personnage.
	* retour: une instance de la classe Personnage correctement instancié.
	**/
	public static Personnage personnageFactory() {
		getDictionnaire();
		System.out.println("Veuillez entrer le nom de votre personnage: ");
		String nom = sc.nextLine();		
		
		System.out.println("Choisissez votre classe de combattant");
		String classe = sc.nextLine();
		
		Classe classePersonnage = getClasse(classe);
		
		return new Personnage(50, nom, classePersonnage);
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
	 * Retourne la liste de monstres
	 * @return
	 */
	public static List<Monstre> getListeMonstres() {
		if (listeMonstres.isEmpty()) {
			initialiseListeMonstres();
		}
		return listeMonstres;
	}
	
	/**
	 * Retourne la liste de classes
	 * @return le dictionnaire de classes
	 */
	public static Map<String, Classe> getDictionnaire() {
		if (dictionnaire.isEmpty()) {
			dictionnaire.put("guerrier", new Guerrier());
			dictionnaire.put("mage", new Mage());
			dictionnaire.put("voleur", new Voleur());
		}
		return dictionnaire;
	}
	
	/**
	 * Crée un groupe de monstres prêts à attaquer parmi la liste de monstres
	 * @param int nombreMonstres
	 * @return Groupe un groupe de monstres
	 */
	public static Groupe creationGroupeMonstre(int nombreMonstres) {
		initialiseListeMonstres();
		
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
	 * sélection du choix entre 1 et 4
	 */
	public static void genese() {
		System.out.print("---***--- Bonjour ---***---\nChoisir une option:\n1: Lancer un combat 1v1\n2: Lancer un tournoi de groupe\n3: lancer un combat de groupe\n4: One vs World Hardcore Edition\n5: Informations\n6: Créer classe\n7: quitter\n---------------------------\n>>>");
		int choix = sc.nextInt();
		while (choix < 1 || choix > 7) {
			System.out.println("mauvais choix, recommencez: ");
			choix = sc.nextInt();
			sc.nextLine();
		}
		switch(choix) {
			case 1:
				combat1v1();
				break;
			case 2:
				combatTournoi();
				break;
			case 3:
				combatGroupe();
				break;
			case 4:
				combatSolo();
				break;
			case 5:
				informations();
				break;
			case 6: 
				creationClasse();
				break;
			case 7:
				return;
			default:
				genese();
				break;
		}		
	}
	
	/**
	 * Lance un combat 1v1 
	 */
	public static void combat1v1() {
		sc.nextLine();
		Personnage p = personnageFactory();
		Monstre m = monstreFactory();
		
		combat(p, m);
		sc.nextLine();
		genese();
	}
	
	/**
	 * Lance un combat entre un groupe de personnages et un groupe de monstres
	 */
	public static void combatTournoi() {
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
		sc.nextLine();
		genese();
	}
	
	/**
	 * lance un combat de mélée entre 1 groupe de personnages et un groupe de monstres
	 */
	public static void combatGroupe() {
		System.out.println("Saisissez le nombre de monstres à attaquer");
		int nbMonstres = sc.nextInt();
		Groupe groupeMonstres = creationGroupeMonstre(nbMonstres);
		System.out.println("Saisissez le nombre de héros");
		int nbPersos = sc.nextInt();
		sc.nextLine();
		Groupe groupePersos = creationGroupePersonnage(nbPersos);
		boolean turn;
		while(!groupeMonstres.estMort() && !groupePersos.estMort()) {
			turn = new Random().nextBoolean();
			if (turn) {
				groupePersos.attaquerGroupe(groupeMonstres);
			} else {
				groupeMonstres.attaquerGroupe(groupePersos);
			}
		}
		System.out.println("Vainqueur: " + (groupeMonstres.estMort() ? "Groupe de Héros" : "Groupe de monstres"));
		System.out.println(groupeMonstres + "\n" + groupePersos);
		sc.nextLine();
		genese();
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
		sc.nextLine();
		genese();
	}
	
	/**
	 * affiche les informations : 
	 * 	- des monstres de la liste
	 *  - des classes disponibles 
	 */
	public static void informations() {
		System.out.println(getListeMonstres());
		System.out.println(getDictionnaire());
		sc.nextLine();
		genese();
	}
	
	/**
	 * Crée une classe
	 * @return une nouvelle classe
	 */
	public static void creationClasse() {
		initialiseListeAttaque();
		sc.nextLine();
		System.out.println("Choisissez un nom de classe");
		String nomClasse = sc.nextLine();
		
		List<IAttaque> attaquesClasse = new ArrayList<>();
		while (attaquesClasse.size() < 4) {
			IAttaque attaque = selectionAttaque(attaquesAleatoires());
			attaquesClasse.add(attaque);
		}
		
		dictionnaire.put(nomClasse, new Classe(nomClasse, attaquesClasse));
		genese();
	}
	
	/**
	 * initialise la liste d'attaques
	 */
	public static void initialiseListeAttaque() {
		// liste temporaire avant externalisation xml
		if (listeAttaques.isEmpty()) {
			listeAttaques.add(new BasicAttaque("épée", "un coup d'épée dans l'eau", 8, 60.0));
			listeAttaques.add(new BasicAttaque("coup de boule", "coup de boule dans les naseaux !", 12, 70.0));
			listeAttaques.add(new BasicAttaque("coup de botte", "coup de bottes en peau de troll dans les valseuses", 20, 30.0));
			listeAttaques.add(new BasicAttaque("coup de poing", "patate de forain breeeuuuh", 20, 70.0));
			listeAttaques.add(new BasicAttaque("bâton", "un coup de bâton sur la caboche", 6, 60.0));
			listeAttaques.add(new BasicAttaque("boule de feu", "une boule de feu puiss... puissiez-vous réussir à la lancer !", 25, 45.0));
			listeAttaques.add(new BasicAttaque("boule de glace", "utile l'été pour garnir un cornet, l'ogre en raffole", 20, 55.0));
			listeAttaques.add(new BasicAttaque("boule électrique", "redresse les cheveux, gare au coup de foudre", 15, 90.0));
			listeAttaques.add(new BasicAttaque("dague", "un coup de dague dans le flanc", 8, 80.0));
			listeAttaques.add(new BasicAttaque("piège", "un piège pour berner l'ennemi !", 20, 60.0));
			listeAttaques.add(new BasicAttaque("corde", "Etranglement de l'ennemi, attention, les fantômes n'ont pas de cou", 30, 30.0));
			listeAttaques.add(new BasicAttaque("assomoir", "un coup de matraque sur la caboche !", 18, 60.0));
			listeAttaques.add(new BasicAttaque("bouclier", "assène un coup de bouclier !", 30, 50.0));
			listeAttaques.add(new BasicAttaque("arcane", "une attaque des ténèbres, sans lampe torche !", 25, 80.0));
			listeAttaques.add(new BasicAttaque("vampirisme", "Le sang ennemi est impur, ne le buvez pas !", 17, 99.0));
		}
	}
	
	/**
	 * extrait 2 attaques de la liste et le retourne dans un tableau 
	 * @return tableau de 2 attaques
	 */
	public static IAttaque[] attaquesAleatoires() {
		int rand1 = randomFunction(listeAttaques.size());
		int rand2 = randomFunction(listeAttaques.size());
		return new IAttaque[] {listeAttaques.get(rand1), listeAttaques.get(rand2)};
	}
	
	/**
	 * retourne une des 2 attaques sur le choix de l'utilisateur
	 * @param tableau de deuxAttaques
	 * @return une attaque
	 */
	public static IAttaque selectionAttaque(IAttaque[] deuxAttaques) {
		System.out.println("Selectionnez une des 2 attaques");
		System.out.println("Attaque 1: " + deuxAttaques[0].getNom() + ", " + deuxAttaques[0].getDescription());
		System.out.println("Attaque 2: " + deuxAttaques[1].getNom() + ", " + deuxAttaques[1].getDescription());
		int choix = sc.nextInt();
		while (choix < 1 || choix > 2) {
			System.out.println("mauvaise saisie, choisissez une attaque");
			choix = sc.nextInt();			
		}
		return deuxAttaques[choix - 1];
	}
}
