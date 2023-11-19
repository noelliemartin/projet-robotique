package logique;

/**
 * 
 * Classe qui permet de cr�er une case avec un co�t et une couleur associ�e.
 *
 */
public class Case {
	
	private float[] couleur;
	private int cout;
	/**
	 * M�thode qui initialise la case
	 * @param col
	 * @param ct
	 */
	public Case(float[]col, int ct) {
		this.couleur = col;
		this.cout = ct;
	}
	/**
	 * M�thode qui permet d'obtenir la couleur de la case 
	 * @return un tableau RGB qui repr�sente la couleur
	 */
	public float[] getCouleur() {
		return this.couleur;
	}
	/**
	 * M�thode qui permet d'obtenir le co�t de la case
	 * @return un entier qui repr�sente le co�t.
	 */
	public int getCout() {
		return this.cout;
	}
}
