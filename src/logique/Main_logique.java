package logique;

import java.util.Arrays;
import logique.IParams;

public class Main_logique {
	
	private Carte carte;
	private float [][][] tabColor;
	
	
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
		System.out.println(Arrays.deepToString(carte.getChemin1()));
	}
	
	public int[][] getChemin1() {
		return carte.getChemin1();
	}
	
	public float [][] getCheminColors(){
		int [][] tab_coord=carte.getChemin1();
		float[][] cheminCouleurs=new float[IParams.longChemin1][3];
		for (int i=0;i<tab_coord.length;i++) {
			cheminCouleurs[i]=tabColor[tab_coord[i][0]][tab_coord[i][1]];
		}
		return cheminCouleurs;
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
	
	//Permet de reconnaître la couleur et de lui attribuer un nom.
	public String detectColor(float[] couleur) {
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
