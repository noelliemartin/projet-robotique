package AI;

import java.util.Arrays;

import logique.Carte;
import logique.Main_logique;

public class MainAI {
	
	public static void main(String[] args) {
		Main_logique main_logique2 = new Main_logique();
		Carte carte = main_logique2.getCarte();
		int[][] chemin = AStar.trouverChemin(carte);
		System.out.println(Arrays.deepToString(chemin)); //envoie le chemin sur l'autre écran
	}
	
	
}
