package personnages;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron = new Chaudron();
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return ("Le Druide " + nom + " : ");
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocte " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
	}
	
	public void booster(Gaulois gaulois) {
		if(chaudron.resterPotion()==true) {
			if(gaulois.getNom() == "Obelix") {
				parler("Non, " + gaulois.getNom() + " Non !... et tu le sais tres bien !");
			}
			else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens " + gaulois.getNom() + " un peu de potion magique.");
			}
		}
		else {
			parler("Desole " + gaulois.getNom() + " il n'y a plus une seule gotte de potion.");
		}
	}
	
}
