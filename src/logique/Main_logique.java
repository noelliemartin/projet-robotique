package logique;

import java.util.Arrays;

public class Main_logique implements IParams {
	
	private Carte carte;
	private float [][] tabColor;
	
	
	public Main_logique (){
		Case[][] map = new Case[dimensionCol][dimensionLigne];
		float [][] tabColor1 = {RED, BLUE, GREEN, GREEN, WHITE, GREEN, BLUE, GREEN, GREEN, GREEN, GREEN, BLUE, BLUE, 
				GREEN, ORANGE, GREEN, GREEN, BLUE, GREEN, GREEN, GREEN, ORANGE, ORANGE, ORANGE, GREEN, GREEN, 
				GREEN, GREEN, RED, BLUE, WHITE, GREEN, GREEN, GREEN, BLUE};
		tabColor=tabColor1;
		int cpt = 0;
		for(int i = 0; i < dimensionCol; i++) {
			for(int y = 0; y < dimensionLigne; y++) {
				map[i][y] = new Case(tabColor[cpt],0);
				cpt++;
			}
		}
		carte = new Carte(map, depart, arrive);
		//System.out.println(Arrays.deepToString(carte.getChemin1()));
	}
	
	public int[][] getChemin1() {
		return carte.getChemin1();
	}
	
	public float [][] getCheminColors(){
		return tabColor;
	}
	

}
