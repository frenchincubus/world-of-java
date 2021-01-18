package fr.personnage;

public abstract class AbstractCombattant implements ICombattant {
	 public String nom;
     public int pointDeVie;
     public int degats;

     public AbstractCombattant() {}
     
     public AbstractCombattant(String nom, int pointDeVie, int degat){
         this.nom = nom;
         this.pointDeVie = pointDeVie;
         this.degats = degat;
     }

     public String toString()
     {
         return "nom: " + nom + ", pdv: " + pointDeVie + ", degats: " + degats;
     }
     
     public void attaquer(ICombattant adversaire)
     {
         // Appeler la methode Defence de l'adversaire en passant en Params.
         // Afficher un message pour notifier de l'attaque
    	 adversaire.defendre(this.degats);
    	 System.out.println(this.nom + " a attaqué " + adversaire.getNom() + " et lui a infligé " + this.degats + " dégats.");
     }

     public void defendre(int degats)
     {
         // Soustraire aux points de vie les degats passé en params
    	 this.pointDeVie -= degats;
     }
     
     public int getPointDeVie() {
 		return pointDeVie;
 	}

 	public void setPointDeVie(int pointDeVie) {
 		this.pointDeVie = pointDeVie;
 	}

 	public int getDegats() {
 		return degats;
 	}

 	public void setDegats(int degat) {
 		this.degats = degat;
 	}

 	public String getNom() {
 		return nom;
 	}

 	public void setNom(String nom) {
 		this.nom = nom;
 	}
}
