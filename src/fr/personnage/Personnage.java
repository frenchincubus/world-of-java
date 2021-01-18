package fr.personnage;

import fr.classe.Classe;

public class Personnage extends AbstractCombattant {
	
	private Classe classe;
	
	public Personnage() {
		super();
	}
	
	/**
	 * Instancie un nouveau personnage
	 * @param int pointDeVie : les points de vie du personnage 
	 * @param int degat : les d�gats que le personnage inflige
	 * @param String nom : le nom du personnage
	 * @param Classe classe: la classe du personnage
	 */
	public Personnage(int pointDeVie, int degat, String nom, Classe classe) {
		super(nom, pointDeVie, degat);
		this.classe = classe;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	/**
	 * override de la m�thode attaquer pour utiliser les d�gats d'une arme associ�e � la classe du personnage
	 */
	@Override
	public void attaquer(ICombattant adversaire)
    {
        // Appeler la methode Defence de l'adversaire en passant en Params.
        // Afficher un message pour notifier de l'attaque
   	 adversaire.defendre(this.classe.getAttaque().lancerAttaque(this, adversaire));
   	 System.out.println(this.nom + " a attaqu� " + adversaire.getNom() + " et lui a inflig� " + this.degats + " d�gats.");
    }
}
