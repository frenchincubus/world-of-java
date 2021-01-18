package fr.personnage;

public abstract class AbstractCombattant {
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
}
