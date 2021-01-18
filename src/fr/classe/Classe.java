package fr.classe;

import java.util.ArrayList;
import java.util.List;

import fr.personnage.IAttaque;
import fr.world.Monde;

public class Classe {
	
	public String nom;
	public List<IAttaque> attaques = new ArrayList<>();

	public Classe(String nom, List<IAttaque> attaques) {
       this.nom = nom;
       this.attaques = attaques;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<IAttaque> getAttaques() {
		return attaques;
	}

	public void setAttaques(List<IAttaque> attaques) {
		this.attaques = attaques;
	}

	@Override
	public String toString() {
		return "Classe [nom=" + nom + ", attaques=" + attaques + "]";
	}
	
	public IAttaque getAttaque() {
		return this.attaques.get(Monde.randomFunction(this.attaques.size()));
	}
}
