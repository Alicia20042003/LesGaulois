package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		System.out.println(asterix);
	}
	
	public void setVillage(Village village) {
		this.village = village;
	}

	//Permet de transformer l'affichage d'une adresse : personnages.Gaulois@XXXXXXXX
	//En l'affiche du nom de l'objet : Nom
	//Mais si je veux absolument le nom sans ajouter toString je doit faire :
	// System.out.println(asterix.getNom()); 
	public String toString() {
		return nom;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return ("Le gaulois " + nom + " : ");
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
	public void sePresenter(Gaulois gaulois) {
		if(gaulois == village.getChef()){
			parler("Bonjour, je m'appelle "+getNom()+". Je suis le chef du village "+village.getNom());
		}
	}
	
	public void frapper(Romain romain) {
		if(effetPotion == 1) {
			String nomRomain = romain.getNom();
			System.out.println(nom + " envoie un coup dans la machoire de " + nomRomain);
			int forceCoup = force / 3;
			romain.recevoirCoup(forceCoup);
		}
		else {
			String nomRomain = romain.getNom();
			System.out.println(nom + " envoie un coup dans la machoire de " + nomRomain);
			int forceCoup = (force * effetPotion) / 3;
			romain.recevoirCoup(forceCoup);
			effetPotion --;
		}
	}
	
}
