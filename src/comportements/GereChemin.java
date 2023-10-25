package comportements;

import lejos.robotics.subsumption.Behavior;
import logique.IParams;
/**
 * 
 * Classe qui permet de gérer le parcours d'un chemin
 *
 */
public class GereChemin implements Behavior, IParams{
	//Permet de dire quel behavior doit s'activer.
	//Si 0, c'est VerifCouleurs, si c'est -1 = reculer, -2=finir, 1=avancer,2=tournerLeft,3=TournerRight.
	public static int mouvt=5;
	//Chemin sous forme de coordonnées
	private int [][] chemin;
	//Chemin sous forme de cases de couleurs
	public static float[][] cheminCouleurs;
	//Orientation du robot : 0 pointe vers l'ouest, 1 pointe vers le bas, 2 pointe vers l'est, 3 pointe vers le haut.
	private int orient=0;
	//Booléen qui indique si la couleur est bonne
	public static boolean colorGood=false;
	//position actuelle du robot
	public static int indice=0;
	
	
	public GereChemin(float[][] cheminCouleurs, int[][] chemin) {
		this.cheminCouleurs=cheminCouleurs;
		this.chemin=chemin;
	}


	@Override
	public boolean takeControl() {
		return true;
	}


	@Override
	public void action() {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Si on arrive au bout du chemin, le programme s'arrête
		if(chemin.length==indice+1) {
			//Behavior qui arrête le programme
			mouvt=-2;
		}
		//Si le mouvement a déjà été fait (à mettre sinon les behaviors se chevauchent et ça plante)
		else if (mouvt!=5) {
			//Si la couleur est bonne
			if (colorGood) {
				//case actuelle
				int [] caseDep=chemin[indice];
				//case où il faut aller
				int [] caseSuiv=chemin[indice+1];
				int x1=caseDep[0]; int y1=caseDep[1];
				int x2=caseSuiv[0]; int y2=caseSuiv[1];
				//cas où il faut avancer
				if ((y2<y1 && orient==0) || (y2>y1 && orient==2) || (x2>x1 && orient==1) || (x2<x1 && orient==3)){
					mouvt=1;
				}
				//Cas où il faut tourner à droite
				else if((y2<y1 && orient==1) || (y2>y1 && orient==3) || (x2>x1 && orient==2) || (x2<x1 && orient==0)) {
					mouvt=3;
					//On change l'orientation du robot
					if(orient!=0) {
						orient-=1;
					}
					else {
						orient=3;
					}
				}
				//Cas où il faut tourner à gauche
				else if((y2<y1 && orient==3) || (y2>y1 && orient==1) || (x2>x1 && orient==0) || (x2<x1 && orient==2)) {
					mouvt=2;
					//On change l'orientation du robot
					if(orient!=3) {
						orient+=1;
					}
					else {
						orient=0;
					}
				}
				//Cas où il faut faire demi-tour 
				else {
					mouvt=-1;
				}
			}
			else if ((mouvt==6 && !colorGood) || mouvt==-2){
				//Behavior d'arrêt
				mouvt=-2;
			}
		}
		//Cas où la vérification de couleur n'a toujours pas été faite : on la fait.
		else {
			mouvt=0;
		}
		
	}


	@Override
	public void suppress() {
	}
}
