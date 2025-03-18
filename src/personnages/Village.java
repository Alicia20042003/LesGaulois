package personnages;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private Gaulois chef;
	
	public Village(String nom, final int NB_VILLAGEOIS_MAX) {
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}
	
	public void setChef(Gaulois chef) {
		this.chef = chef;
		chef.setVillage(this);
	}

	public Gaulois getChef() {
		return chef;
	}

	public Gaulois trouverVillageois(int numVillageois){
		if (villageois[numVillageois - 1] != null) {
			return villageois[numVillageois - 1];
		}
		else {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
	}
	
	public void afficherVillageois(){
		System.out.println("Dans le village \"" + getNom() + "\" du chef " + getChef() + " vivent les l�gendaires gaulois :");
		
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i]);
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles",30);
		
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		village.setChef(abraracourcix);
		
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterVillageois(asterix);
		
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		
		village.afficherVillageois();
		
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterVillageois(obelix);
		
		village.afficherVillageois();
		
		Gaulois doublePolemix = new Gaulois("DoublePolemix", 4);
		
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
	}
	
}
