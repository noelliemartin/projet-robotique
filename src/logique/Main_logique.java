package logique;

import java.util.Arrays;
/**
 * 
 * Classe qui permet de g�rer tous les aspects th�oriques, soit la cr�ation
 * de carte et la g�n�ration d'un chemin � parcourir pour le robot.
 *
 */
import logique.IParams;

public class Main_logique {
	
	private Carte carte;
	private static float [][][] tabColor;
	
	/**
	 * M�thode qui initialise les �l�ments th�oriques de la carte et des chemins
	 * � parcourir.
	 */
	public Main_logique (){
		Case[][] map = new Case[IParams.dimensionCol][IParams.dimensionLigne];
		float [][][] tabColor1 = {{IParams.RED, IParams.BLUE, IParams.GREEN, IParams.GREEN, IParams.WHITE}, {IParams.GREEN, IParams.BLUE, IParams.GREEN, IParams.GREEN, IParams.GREEN}, {IParams.GREEN, IParams.BLUE, IParams.BLUE,
			IParams.GREEN, IParams.ORANGE}, {IParams.GREEN, IParams.GREEN, IParams.BLUE, IParams.GREEN, IParams.GREEN}, {IParams.GREEN, IParams.ORANGE, IParams.ORANGE, IParams.ORANGE, IParams.GREEN}, {IParams.GREEN, 
				IParams.GREEN, IParams.GREEN, IParams.RED, IParams.BLUE}, {IParams.WHITE, IParams.GREEN, IParams.GREEN, IParams.GREEN, IParams.BLUE}};
		tabColor=tabColor1;
		for(int i = 0; i < IParams.dimensionCol; i++) {
			for(int y = 0; y < IParams.dimensionLigne; y++) {
				map[i][y] = new Case(tabColor[i][y],0);
			}
		}
		carte = new Carte(map, IParams.depart, IParams.arrive);
		//printCarte();
		//System.out.println(Arrays.deepToString(carte.getChemin1()));
	}
	
	/**
	 * M�thode qui permet d'obtenir un chemin � parcourir par le robot (exercice 1)
	 * @return une liste de coordonn�es qui repr�sente le chemin. 
	 */
	public int[][] getChemin1() {
		return carte.getChemin1();
	}
	
	/**
	 * M�thode qui permet d'obtenir les couleurs associ�es au chemin � parcourir par le
	 * robot.
	 * @return une liste de couleurs, chacune correspondant � une case du chemin.
	 */
	public float [][] getCheminColors(){
		int [][] tab_coord=carte.getChemin1();
		float[][] cheminCouleurs=new float[IParams.longChemin1][3];
		for (int i=0;i<tab_coord.length;i++) {
			cheminCouleurs[i]=tabColor[tab_coord[i][0]][tab_coord[i][1]];
		}
		return cheminCouleurs;
	}
	
	/**
	 * M�thode qui permet d'afficher la carte sur le robot.
	 */
	public void printCarte() {
		for (int i=0;i<IParams.dimensionCol;i++) {
			System.out.print("[");
			for (int j=0;j<IParams.dimensionLigne;j++) {
				System.out.print(" "+detectColor(tabColor[i][j])+" ");
			}
			System.out.println("]");
		}
	}
	
	
	//M�thode qui permet d'envoyer la carte sous forme de string
	public static String returnCarte() {
		String resultat = "";
		for (int i=0;i<IParams.dimensionCol;i++) {
			resultat = resultat + "[";
			for (int j=0;j<IParams.dimensionLigne;j++) {
				System.out.println("oui");
				System.out.println(detectColor(tabColor[i][j]));
				resultat += " " + detectColor(tabColor[i][j]) + " ";
			}
			resultat += "]";
		}
		System.out.println(resultat);
		return resultat;
	}
	
	/**
	 * M�thode qui permet de pouvoir afficher une couleur sous un format compr�hensible.
	 * @param couleur 
	 * @return une couleur sous la forme d'une lettre. 
	 */
	public static String detectColor(float[] couleur) {
		if(couleur[0]==IParams.RED[0] && couleur[1]==IParams.RED[1] && couleur[2]==IParams.RED[2]) {
			return "R";
		}
		else if(couleur[0]==IParams.GREEN[0] && couleur[1]==IParams.GREEN[1] && couleur[2]==IParams.GREEN[2]) {
			return "G";
		}
		else if(couleur[0]==IParams.BLUE[0] && couleur[1]==IParams.BLUE[1] && couleur[2]==IParams.BLUE[2]) {
			return "B";
		}
		else if (couleur[0]==IParams.WHITE[0] && couleur[1]==IParams.WHITE[1] && couleur[2]==IParams.WHITE[2]) {
			return "W";
		}
		else {
			return "O";
		}
	}
	

}
