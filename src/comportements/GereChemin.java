package comportements;

import lejos.robotics.subsumption.Behavior;
import logique.IParams;
/**
 * 
 * Classe qui permet de gerer le parcours d'un chemin
 *
 */
public class GereChemin implements Behavior{
	//Permet de dire quel behavior doit s'activer.
	//Si 0, c'est VerifCouleurs, si c'est -1 = reculer, -2=finir, 1=avancer,2=tournerLeft,3=TournerRight.
	public static int mouvt=5;
	//Chemin sous forme de coordonnees
	private int [][] chemin;
	//Chemin sous forme de cases de couleurs
	public static float[][] cheminCouleurs;
	//Orientation du robot : 0 pointe vers l'ouest, 1 pointe vers le bas, 2 pointe vers l'est, 3 pointe vers le haut.
	private int orient=0;
	//Booleen qui indique si la couleur est bonne
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
		//Si on arrive au bout du chemin, le programme s'arrete
		if(chemin.length==indice+1) {
			//Behavior qui arrete le programme
			mouvt=-2;
		}
		//Si le mouvement a deja ete fait (a mettre sinon les behaviors se chevauchent et ca plante)
		else if (mouvt!=5) {
			//Si la couleur est bonne
			if (colorGood) {
				//case actuelle
				int [] caseDep=chemin[indice];
				//case suivante
				int [] caseSuiv=chemin[indice+1];
				int x1=caseDep[0]; int y1=caseDep[1];
				int x2=caseSuiv[0]; int y2=caseSuiv[1];
				//cas ou il faut avancer
				if ((y2<y1 && orient==0) || (y2>y1 && orient==2) || (x2>x1 && orient==1) || (x2<x1 && orient==3)){
					mouvt=1;
				}
				//Cas ou il faut tourner a droite
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
				//Cas ou il faut tourner a gauche
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
				//Cas ou il faut faire demi-tour 
				else {
					mouvt=-1;
				}
			}
			else if ((mouvt==6 && !colorGood) || mouvt==-2){
				//Behavior d'arret
				mouvt=-2;
			}
		}
		//Cas ou la verification de couleur n'a toujours pas ete faite : on la fait.
		else {
			mouvt=0;
		}
		
	}


	@Override
	public void suppress() {
	}
}
