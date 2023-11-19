package comportements;

import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

/**
 * 
 * Classe qui permet au robot de faire demi-tour.
 *
 */
public class DemiTour implements Behavior {
	private MovePilot pilot;
	
	/**
	 * Méthode qui initialise le demi-tour.
	 * @param p
	 */
	public DemiTour(MovePilot p) {
		this.pilot = p; 
	}

	@Override
	/**
	 * Méthode qui permet de prendre le contrôle pour faire demi-tour.
	 */
	public boolean takeControl() {
		return GereChemin.mouvt==-1;
	}

	@Override
	/**
	 * Méthode qui fait demi-tour.
	 */
	public void action() {
		if(GereChemin.mouvt!=5) {
			pilot.setLinearSpeed(30.);
			pilot.rotate(180);
			this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
			pilot.stop();
			System.out.println("Je fais demi-tour...");
			GereChemin.indice-=1;
			GereChemin.mouvt=5;
			GereChemin.colorGood=false;
		}
		
		
	}

	@Override
	/**
	 * Méthode qui permet de passer à une autre action. 
	 */
	public void suppress() {
		Motor.B.stop(true);
        Motor.C.stop(true);
		pilot.stop();
		
		
	}

}
