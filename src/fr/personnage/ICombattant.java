package fr.personnage;

public interface ICombattant {
	/**
	 * Le combattant attaque un adversaire
	 * @param ICombattant adversaire : un adversaire de type ICombattant
	 */
	public void attaquer(ICombattant adversaire);
	
	/**
	 * Le combattant absorbe des dégats reçus
	 * @param int degats : les dégats infligés au combattant
	 */
    public void defendre(int degats);

    // Getters et Setters
    public String getNom();
    public int getDegats();
    public int getPointDeVie();
    public void setNom(String nom);
    public void setDegats(int degats);
    public void setPointDeVie(int pointDeVie);
    
    /**
 	 * retourne si le combattant est en vie ou non
 	 * @return boolean en vie ou non 
 	 */
 	public boolean estVivant();
}
