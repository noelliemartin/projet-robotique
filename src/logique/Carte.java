package logique;

import java.util.Arrays;
import java.util.Iterator;

public class Carte {
	
	private Case[][] map;
	public int[] arrive;
	public int[] depart;
	
	public Carte(Case[][] carte, int[] de, int[] ar) {
		this.map = carte;
		this.arrive = ar;
		this.depart = de;
	}
	
	public Case[][] getMap(){
		return this.map;
	}
	
	public int[][] getChemin1(){
		int[][] chemin_int = new int[map.length*map.length][2]; 
		int[] copieDep = Arrays.copyOf(depart, depart.length);
		chemin_int[0]=copieDep;
		int i=0;
		while ((chemin_int[i][0]!=arrive[0] && chemin_int[i][1]!=arrive[1])) {
			int[] case_g=Arrays.copyOf(chemin_int[i], 2);
			case_g[1]-=1;
			int [] case_b=Arrays.copyOf(chemin_int[i], 2);
			case_b[0]+=1;
			i++;
			
			if(case_b[0]>=6) {
				chemin_int[i]=case_g;
			}
			else if(case_g[1]<=0) {
				chemin_int[i]=case_b;
			}
			else {
				float nb_alea= (float) Math.random();
				chemin_int[i]=nb_alea>0.5?case_g:case_b;
			}
		}
		chemin_int[i+1]=Arrays.copyOf(arrive, 2);
		int[][] cheminReturn= Arrays.copyOf(chemin_int, i+1);
		return cheminReturn;
	}
	
	public float[][] getCheminColors(int[][] tab_coord, float[][][] tabColor){
		float[][] cheminCouleurs=new float[tab_coord.length][3];
		for (int i=0;i<tab_coord.length;i++) {
			cheminCouleurs[i]=tabColor[tab_coord[i][0]][tab_coord[i][1]];
		}
		return cheminCouleurs;
	}
	

	public Case getCaseDepart() throws Exception {
		for(int i = 0; i<IParams.dimensionCol; i++) {
			for(int y = 0; y<IParams.dimensionLigne; y++) {
				if(map[i][y].getX() == this.depart[0] && map[i][y].getY() == this.depart[1])
					return map[i][y];
			}
		}
		throw new Exception("Départ not found");
	}
	
	public Case getCaseArrivee() throws Exception {
		for(int i = 0; i<IParams.dimensionCol; i++) {
			for(int y = 0; y<IParams.dimensionLigne; y++) {
				if(map[i][y].getX() == this.arrive[0] && map[i][y].getY() == this.arrive[1])
					return map[i][y];
			}
		}
		throw new Exception("Arrivée not found");
	}

	
}
