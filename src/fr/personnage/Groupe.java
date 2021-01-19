package fr.personnage;

import java.util.ArrayList;
import java.util.List;

import fr.world.Monde;

public class Groupe extends AbstractCombattant {
	
	private List<ICombattant> listeCombattants = new ArrayList<>();

	/**
	 * Choisit un combattant aléatoire et attaque l'adversaire
	 * @param ICombattant adversaire
	 */
	public ICombattant attaquer() {
		ICombattant combattant = listeCombattants.get(Monde.randomFunction(listeCombattants.size()));
		return combattant;
	}

	/**
	 * Sélectionne un combattant aléatoire de la listeCombattants pour défendre
	 * @param int degats  
	 */
	public ICombattant defendre() {
		ICombattant combattant = listeCombattants.get(Monde.randomFunction(listeCombattants.size()));
		return combattant;
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
			if (combattant.estVivant()) {
				mort = false;
			}
		}
		return mort;
	}

	@Override
	public String toString() {
		return "Groupe [listeCombattants=" + listeCombattants + "]";
	}
}
