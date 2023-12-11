package logique;

public class Case {
	
	private float[] couleur;
	private int cout;
	
	private int x;
	private int y;
	
	public Case(float[]col, int ct, int x, int y) {
		this.couleur = col;
		this.cout = ct;
		this.x = x;
		this.y = y;
	}
	
	public float[] getCouleur() {
		return this.couleur;
	}
	
	public int getCout() {
		return this.cout;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
