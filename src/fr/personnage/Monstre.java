package fr.personnage;

public class Monstre extends AbstractCombattant {
	
	public Monstre(int pointDeVie, int degat, String nom) {
		super(nom, pointDeVie, degat);
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
