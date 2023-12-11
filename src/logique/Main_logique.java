package logique;

import java.util.Arrays;
import logique.IParams;

public class Main_logique {
	
	private Carte carte;
	private static float [][][] tabColor;
	
	public Carte getCarte() {
		return carte;
	}
	
	public Main_logique (){
		Case[][] map = new Case[IParams.dimensionCol][IParams.dimensionLigne];
		tabColor = IParams.tabColor;
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
		//printCarte();
		System.out.println(Arrays.deepToString(carte.getChemin1()));
	}
	
	public int[][] getChemin1() {
		return carte.getChemin1();
	}
	
	
	//Permet de print la carte.
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
	
	//Permet de reconnaï¿½tre la couleur et de lui attribuer un nom.
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
