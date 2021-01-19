package fr.personnage;

import fr.world.Monde;

public class BasicAttaque implements IAttaque {
	
	public int degats;
	public double chanceToucher;
	public String nom;
	public String description;
	
	/**
	 * Instancie une nouvelle attaque basique
	 * @param String nom
	 * @param String description
	 * @param int degats
	 * @param double chanceToucher
	 */
	public BasicAttaque(String nom, String description, int degats, double chanceToucher) {
	       this.degats = degats;
	       this.chanceToucher = chanceToucher;
	       this.nom = nom;
	       this.description = description;
	   }

	public int lancerAttaque(ICombattant lanceur, ICombattant cible) {
		int random = Monde.randomFunction(100);
		int degatsRetournes = 0;
		if(random < this.chanceToucher) {
			degatsRetournes = this.degats;
			System.out.println("L'attaque " + this.nom + " de " + lanceur.getNom() + " a fait mouche et assène " + this.degats + " !!");
		} else {
			System.out.println("L'attaque " + this.nom + " de " + lanceur.getNom() +  " a échoué !!");
		}
		return degatsRetournes;
	}

	public String getNom() {
		return this.nom;
	}

	public String getDescription() {
		return this.description;
	}

	public double getChanceToucher() {
		return this.chanceToucher;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setChanceToucher(double chanceToucher) {
		this.chanceToucher = chanceToucher;
	}

	@Override
	public String toString() {
		return nom + ", " + description + " [degats=" + degats + ", chanceToucher=" + chanceToucher + "]\n";
	}
	
	

}
