package personnages;

public class Romain {
	private String nom;
	private int force;
	
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
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.parler("Bonjour !");
	}
}
