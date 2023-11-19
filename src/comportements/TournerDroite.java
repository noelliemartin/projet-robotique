package comportements;


import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

/**
 * 
 * Classe qui permet au robot de tourner à droite.
 *
 */
public class TournerDroite implements Behavior{

	private MovePilot pilot;
	
	/**
	 * Méthode qui initialise l'action.
	 * @param p
	 */
	public TournerDroite(MovePilot p) {
		this.pilot = p; 
	}
	
	@Override
	/**
	 * Méthode qui permet de prendre le contrôle pour tourner à droite. 
	 */
	public boolean takeControl() {
		return GereChemin.mouvt==3;
	}

	@Override
	/**
	 * Méthode qui fait tourner le robot à droite. 
	 */
	public void action() {
		if(GereChemin.mouvt!=5) {
			this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
			this.pilot.rotate(75);
			this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
			pilot.stop();
			System.out.println("Je tourne a droite...");
			//On indique qu'on passe à la case suivante
			GereChemin.indice+=1;
			//On réajuste ces paramètres pour faire la vérification de couleur
			GereChemin.mouvt=5;
			GereChemin.colorGood=false;
		}
		
	}

	@Override
	/**
	 * Méthode qui permet de passer à une autre action. x
	 */
	public void suppress() {
		Motor.B.stop(true);
        Motor.C.stop(true);
		pilot.stop();
		
	}

}
