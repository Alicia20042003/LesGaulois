package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		System.out.println(asterix);
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
	
	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoie un coup dans la m�choire de " + nomRomain);
		int forceCoup = force / 3;
		romain.recevoirCoup(forceCoup);
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
}
