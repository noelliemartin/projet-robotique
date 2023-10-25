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
		//System.out.println(Arrays.deepToString(carte.getChemin1()));
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
	

}
