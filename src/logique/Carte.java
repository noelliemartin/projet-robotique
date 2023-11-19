package logique;

import java.util.Arrays;

/**
 * 
 * Classe qui cree une carte avec les couleurs associ�es � chaque case
 *
 */
public class Carte {
	
	private Case[][] map;
	public int[] arrive;
	public int[] depart;
	/**
	 * M�thode qui initialise la carte
	 * @param carte
	 * @param de
	 * @param ar
	 */
	public Carte(Case[][] carte, int[] de, int[] ar) {
		this.map = carte;
		this.arrive = ar;
		this.depart = de;
	}
	/**
	 * m�thode qui permet d'obtenir la carte
	 * @return la carte sous forme de matrice � 2 dimension de cases
	 */
	public Case[][] getMap(){
		return this.map;
	}
	/**
	 * M�thode qui cr�e un chemin pour le 1er exercice.
	 * @return une liste de coordonn�es
	 */
	public int[][] getChemin1(){
		//Initialisation du chemin
		int[][] chemin_int = new int[map.length*map.length][2]; 
		int[] copieDep = Arrays.copyOf(depart, depart.length);
		chemin_int[0]=copieDep;
		int i=0;
		//Tant que l'on arrive pas � la case d'arriv�e, on rajoute des cases au chemin.
		while ((chemin_int[i][0]!=arrive[0] && chemin_int[i][1]!=arrive[1])) {
			//On a deux choix qui s'offrent � nous pour aller � l'arriv�e : soit
			//aller � gauche, soit aller en bas. On prend les deux cases correspondantes.
			int[] case_g=Arrays.copyOf(chemin_int[i], 2);
			case_g[1]-=1;
			int [] case_b=Arrays.copyOf(chemin_int[i], 2);
			case_b[0]+=1;
			i++;
			//Si la case du bas est en dehors de la carte, on prend celle de gauche.
			if(case_b[0]>=6) {
				chemin_int[i]=case_g;
			}
			//Si la case de gauche est en dehors de la carte, on prend celle du bas.
			else if(case_g[1]<=0) {
				chemin_int[i]=case_b;
			}
			//Sinon, on prend une des deux cases de mani�re al�atoire. 
			else {
				float nb_alea= (float) Math.random();
				chemin_int[i]=nb_alea>0.5?case_g:case_b;
			}
			
			
		}
		//On met la case d'arriv�e, et on renvoie le chemin. 
		chemin_int[i+1]=Arrays.copyOf(arrive, 2);
		int[][] cheminReturn= Arrays.copyOf(chemin_int, i+1);
		return cheminReturn;
	}

	
}
