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
		int[][] chemin = new int[IParams.longChemin1][2]; 
		int j = 0;
		int[] copieDep = Arrays.copyOf(depart, depart.length);
		
		for(int i = this.depart[0] ; i >= 0; i--) {
			copieDep[0] = i;
			int[] coord = new int[2];
			coord[0] = copieDep[1];
			coord[1] = copieDep[0];
			chemin[j] = coord;
			j++;
		}
		for(int i = 1 ; i < map.length; i++) {
			copieDep[1] = i;
			int[] coord = new int[2];
			coord[0] = copieDep[1];
			coord[1] = copieDep[0];
			chemin[j] = coord;
			j++;
		}
		return chemin;
	}
	
}
