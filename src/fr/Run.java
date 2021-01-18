package fr;

import java.util.Scanner;

import fr.personnage.Personnage;

public class Run {

	public static void main(String[] args) {
		
		System.out.println("Bonjour aventurier, bienvenue. 1�re �tape, il faut cr�er ton personnage! ");
		Personnage p1 = personnageFactory();
		
		System.out.println(p1);
	}

	/**
	* Cr�er un personnage avec touss ses attributs. 
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
}
