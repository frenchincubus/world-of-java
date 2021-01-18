package fr.personnage;

public class Monstre extends Personnage {
	
	public Monstre(int pointDeVie, int degat, String nom) {
		super(pointDeVie, degat, nom);
	}
	
	public int getPointDeVie() {
		return super.getPointDeVie();
	}

	public void setPointDeVie(int pointDeVie) {
		super.setPointDeVie(pointDeVie);
	}

	public int getDegat() {
		return super.getDegat();
	}

	public void setDegat(int degat) {
		super.setDegat(degat);
	}

	public String getNom() {
		return super.getNom();
	}

	public void setNom(String nom) {
		super.setNom(nom);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
