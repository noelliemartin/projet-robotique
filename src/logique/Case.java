package logique;

public class Case {
	
	private int couleur;
	private int cout;
	
	public Case(int col, int ct) {
		this.couleur = col;
		this.cout = ct;
	}
	
	public int getCouleur() {
		return this.couleur;
	}
	
	public int getCout() {
		return this.cout;
	}
}
