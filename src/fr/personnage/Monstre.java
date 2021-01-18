package fr.personnage;

public class Monstre extends AbstractCombattant {
	
	/**
	 * Instancie un nouveau monstre
	 * @param int pointDeVie : les points de vie du monstre 
	 * @param int degat : les dégats que le monstre inflige
	 * @param String nom : le nom du monstre
	 */
	public Monstre(int pointDeVie, int degat, String nom) {
		super(nom, pointDeVie, degat);
	}
}
