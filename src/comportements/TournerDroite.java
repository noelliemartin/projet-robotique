package comportements;


import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

/**
 * 
 * Classe qui permet au robot de tourner � droite.
 *
 */
public class TournerDroite implements Behavior{

	private MovePilot pilot;
	
	/**
	 * M�thode qui initialise l'action.
	 * @param p
	 */
	public TournerDroite(MovePilot p) {
		this.pilot = p; 
	}
	
	@Override
	/**
	 * M�thode qui permet de prendre le contr�le pour tourner � droite. 
	 */
	public boolean takeControl() {
		return GereChemin.mouvt==3;
	}

	@Override
	/**
	 * M�thode qui fait tourner le robot � droite. 
	 */
	public void action() {
		if(GereChemin.mouvt!=5) {
			this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
			this.pilot.rotate(75);
			this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
			pilot.stop();
			System.out.println("Je tourne a droite...");
			//On indique qu'on passe � la case suivante
			GereChemin.indice+=1;
			//On r�ajuste ces param�tres pour faire la v�rification de couleur
			GereChemin.mouvt=5;
			GereChemin.colorGood=false;
		}
		
	}

	@Override
	/**
	 * M�thode qui permet de passer � une autre action. x
	 */
	public void suppress() {
		Motor.B.stop(true);
        Motor.C.stop(true);
		pilot.stop();
		
	}

}
