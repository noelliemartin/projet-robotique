package logique;

import java.util.Arrays;

public class Main_logique implements IParams {
	
	private Carte carte;
	private float [][][] tabColor;
	
	
	public Main_logique (){
		Case[][] map = new Case[dimensionCol][dimensionLigne];
		float [][][] tabColor1 = {{RED, BLUE, GREEN, GREEN, WHITE}, {GREEN, BLUE, GREEN, GREEN, GREEN}, {GREEN, BLUE, BLUE, 
				GREEN, ORANGE}, {GREEN, GREEN, BLUE, GREEN, GREEN}, {GREEN, ORANGE, ORANGE, ORANGE, GREEN}, {GREEN, 
				GREEN, GREEN, RED, BLUE}, {WHITE, GREEN, GREEN, GREEN, BLUE}};
		tabColor=tabColor1;
		for(int i = 0; i < dimensionCol; i++) {
			for(int y = 0; y < dimensionLigne; y++) {
				map[i][y] = new Case(tabColor[i][y],0);
			}
		}
		carte = new Carte(map, depart, arrive);
		//System.out.println(Arrays.deepToString(carte.getChemin1()));
	}
	
	public int[][] getChemin1() {
		return carte.getChemin1();
	}
	
	public float [][] getCheminColors(){
		int [][] tab_coord=carte.getChemin1();
		float[][] cheminCouleurs=new float[longChemin1][3];
		for (int i=0;i<tab_coord.length;i++) {
			cheminCouleurs[i]=tabColor[tab_coord[i][0]][tab_coord[i][1]];
		}
		return cheminCouleurs;
	}
	

}
