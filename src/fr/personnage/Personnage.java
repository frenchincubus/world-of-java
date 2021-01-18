package fr.personnage;

public class Personnage extends AbstractCombattant {
	
	public Personnage() {
		super();
	}
	
	/**
	 * Instancie un nouveau personnage
	 * @param int pointDeVie : les points de vie du personnage 
	 * @param int degat : les dégats que le personnage inflige
	 * @param String nom : le nom du personnage
	 */
	public Personnage(int pointDeVie, int degat, String nom) {
		super(nom, degat, pointDeVie);
	}

	public int getPointDeVie() {
		return pointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	public int getDegat() {
		return degats;
	}

	public void setDegat(int degat) {
		this.degats = degat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
