package comportements;

import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

/**
 * 
 * Classe qui permet au robot d'avancer d'une case.
 *
 */

public class Avancer implements Behavior{

	private MovePilot pilot;
	
	/**
	 * Méthode qui initialise l'avancement
	 * @param p
	 */
	public Avancer(MovePilot p) {
		this.pilot = p;
	}
	
	@Override
	/**
	 * Méthode qui permet de prendre le contrôle pour avancer
	 */
	public boolean takeControl() {
		return GereChemin.mouvt==1;
	}

	@Override
	/**
	 * Méthode qui fait avancer le robot.
	 */
	public void action() {
		if(GereChemin.mouvt!=5) {
			pilot.setLinearSpeed(60.);
			this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
			pilot.stop();
			System.out.println("J'avance...");
			//On passe à la case actuelle
			GereChemin.indice+=1;
			//On réajuste les paramètres pour faire la vérification de couleurs.
			GereChemin.mouvt=5;
			GereChemin.colorGood=false;
		}
		
	}

	@Override
	/**
	 * Méthode qui permet de changer d'action. 
	 */
	public void suppress() {
		Motor.B.stop(true);
        Motor.C.stop(true);
		pilot.stop();	
	}
	
}
