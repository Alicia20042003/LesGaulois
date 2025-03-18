package personnages;

import java.util.Iterator;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	
	private Boolean isInvariantVerified() {
		return this.force>=0;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert isInvariantVerified();
		assert forceCoup>=0;
		int lastForce = force;
		force = force - forceCoup;
		if(force<1) {
			parler("J'abandonne !");
		}
		else {
			parler("Aie");
		}
		assert lastForce>force;
		assert isInvariantVerified();
	}
	
	public void sEquiper(Equipement equipement) {
		if(nbEquipement == 2) {
			System.out.println("Le soldat "+getNom()+" est deja bien protege !");
		}
		else if(nbEquipement != 0 && nbEquipement != 2) {
			if (equipements[nbEquipement] != equipement) {
				equipements[nbEquipement] = equipement;
				nbEquipement ++;
				System.out.println("Le soldat "+getNom()+" s'equipe avec un "+equipement.toString()+".");
			}
			else {
				System.out.println("Le soldat "+getNom()+" possede deja un "+equipement.toString()+".");
			}
		}
		else {
			nbEquipement ++;
			equipements[nbEquipement] = equipement;
			System.out.println("Le soldat "+getNom()+" s'equipe avec un "+equipement.toString()+".");
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.parler("Bonjour !");
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
	}
}
