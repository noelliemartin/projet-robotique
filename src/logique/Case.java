package logique;

public class Case {
	
	private float[] couleur;
	private int cout;
	
	public Case(float[]col, int ct) {
		this.couleur = col;
		this.cout = ct;
	}
	
	public float[] getCouleur() {
		return this.couleur;
	}
	
	public int getCout() {
		return this.cout;
	}
}
