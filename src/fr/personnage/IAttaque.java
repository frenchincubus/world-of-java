package fr.personnage;

public interface IAttaque {

	/**
	 * lance une attaque en fonction de la chance de toucher
	 * @param ICombattant lanceur
	 * @param ICombattant cible
	 * @return
	 */
	public int LancerAttaque(ICombattant lanceur, ICombattant cible);

    // Getters et Setters
    public String getNom();
    public String getDescription();
    public double getChanceToucher();
    public void setNom(String nom);
    public void setDescription(int description);
    // Chance de toucher doit être compris entre 0 et 100 obligatoirement
    public void setChanceToucher(double chanceToucher); 
}
