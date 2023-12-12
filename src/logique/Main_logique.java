package logique;

import java.util.Arrays;
import logique.IParams;

public class Main_logique {
	
	private Carte carte;
	private static float [][][] tabColor;
	private int[][] cheminExo1;
	
	
	public Carte getCarte() {
		return carte;
	}
	
	public Main_logique (){
		Case[][] map = new Case[IParams.dimensionCol][IParams.dimensionLigne];
		tabColor = IParams.getCarteColors();
		for(int i = 0; i < IParams.dimensionCol; i++) {
			for(int y = 0; y < IParams.dimensionLigne; y++) {
				if(tabColor[i][y] == IParams.BLUE)
					map[i][y] = new Case(tabColor[i][y], 10, i, y);
				else if(tabColor[i][y] == IParams.ORANGE)
					map[i][y] = new Case(tabColor[i][y], 5, i, y);
				else
					map[i][y] = new Case(tabColor[i][y], 1, i, y);
			}
		}
		carte = new Carte(map, IParams.depart, IParams.arrive);
		this.cheminExo1=carte.getChemin1();
		//printCarte();
		//System.out.println(Arrays.deepToString(carte.getChemin1()));
	}
	
	public int[][] getChemin1() {
		return cheminExo1;
	}
	

	
	/**
	 * Méthode qui donne la carte sous forme de String.
	 * @return une liste de couleurs, chacune correspondant à une case du chemin.
	 */
	public static String returnCarte() {
		String resultat = "";
		for (int i=0;i<IParams.dimensionCol;i++) {
			resultat = resultat + "[";
			for (int j=0;j<IParams.dimensionLigne;j++) {
				System.out.println("oui");
				System.out.println(IParams.detectColor(tabColor[i][j]));
				resultat += " " + IParams.detectColor(tabColor[i][j]) + " ";
			}
			resultat += "]";
		}
		System.out.println(resultat);
		return resultat;
	}
	
	/**
	 * Méthode qui permet d'obtenir les couleurs associées au chemin à parcourir par le
	 * robot.
	 * @return une liste de couleurs, chacune correspondant à une case du chemin.
	 */
	public float [][] getChemin1Colors(){
		int [][] tab_coord=cheminExo1;
		float[][] cheminCouleurs=new float[IParams.longChemin1][3];
		for (int i=0;i<tab_coord.length;i++) {
			//System.out.println("i"+i+"x"+tab_coord[i][0]+"y"+tab_coord[i][1]+IParams.detectColor(this.carteColors[tab_coord[i][0]][tab_coord[i][1]]));
			cheminCouleurs[i]=tabColor[tab_coord[i][0]][tab_coord[i][1]];
		}
		return cheminCouleurs;
	}

}
