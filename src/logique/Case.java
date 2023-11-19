package logique;

/**
 * 
 * Classe qui permet de créer une case avec un coût et une couleur associée.
 *
 */
public class Case {
	
	private float[] couleur;
	private int cout;
	/**
	 * Méthode qui initialise la case
	 * @param col
	 * @param ct
	 */
	public Case(float[]col, int ct) {
		this.couleur = col;
		this.cout = ct;
	}
	/**
	 * Méthode qui permet d'obtenir la couleur de la case 
	 * @return un tableau RGB qui représente la couleur
	 */
	public float[] getCouleur() {
		return this.couleur;
	}
	/**
	 * Méthode qui permet d'obtenir le coût de la case
	 * @return un entier qui représente le coût.
	 */
	public int getCout() {
		return this.cout;
	}
}
