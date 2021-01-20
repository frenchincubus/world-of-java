package fr.personnage;

import fr.world.Monde;

public class ParadeDefense implements IDefense {
	
	private String nom;
	private String definition;
	private double parade;
	
	
	/**
	 * crée une instance de ParadeDefense
	 * @param nom
	 * @param definition
	 * @param parade
	 */
	public ParadeDefense(String nom, String definition, double parade) {
		super();
		this.nom = nom;
		this.definition = definition;
		this.parade = parade;
	}

	public String getNom() {
		return this.nom;
	}

	public String getDefinition() {
		return this.definition;
	}

	public String information() {
		return null;
	}

	/**
	 * évalue les chances de parade de l'attaque reçue
	 * @param int degats de l'attaque
	 * @return 0 si parade valide sinon les degats
	 */
	public int defense(int degats) {
		int chanceParade = Monde.randomFunction(100);
		return this.parade*100 > chanceParade ? 0 : degats;
	}

	public double getParade() {
		return parade;
	}

	public void setParade(double parade) {
		this.parade = parade;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	

}
