package fr.personnage;

import java.util.ArrayList;
import java.util.List;

import fr.world.Monde;

public class Groupe implements ICombattant {
	
	private List<ICombattant> listeCombattants = new ArrayList<>();

	/**
	 * Choisit un combattant aléatoire et attaque l'adversaire
	 * @param ICombattant adversaire
	 */
	public void attaquer(ICombattant adversaire) {
		ICombattant combattant = listeCombattants.get(Monde.randomFunction(listeCombattants.size()));
		combattant.attaquer(adversaire);
	}

	/**
	 * Sélectionne un combattant aléatoire de la listeCombattants pour défendre
	 * @param int degats  
	 */
	public void defendre(int degats) {
		ICombattant combattant = listeCombattants.get(Monde.randomFunction(listeCombattants.size()));
		combattant.defendre(degats);
	}

	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getDegats() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getPointDeVie() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setNom(String nom) {
		// TODO Auto-generated method stub

	}

	public void setDegats(int degats) {
		// TODO Auto-generated method stub

	}

	public void setPointDeVie(int pointDeVie) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Ajoute un combattant à la listeCombattants
	 * @param combattant
	 */
	public void addCombattant(ICombattant combattant) {
		listeCombattants.add(combattant);
	}
	
	/**
	 * Retourne true si tous les combattants de la liste sont morts
	 * @return
	 */
	public boolean estMort() {
		boolean mort = true;
		for (ICombattant combattant : listeCombattants) {
			if (combattant.getPointDeVie() > 0) {
				mort = false;
			}
		}
		return mort;
	}
	
	
	

}
