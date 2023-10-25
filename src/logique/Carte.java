package logique;

import java.util.Arrays;

// TODO : ne doit pas �tre d�pendant de IParams
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

	
}
