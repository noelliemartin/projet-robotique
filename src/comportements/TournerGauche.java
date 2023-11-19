package comportements;


import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

/**
 * 
 * Classe qui au robot de tourner à gauche.
 *
 */
public class TournerGauche implements Behavior{
	
	private MovePilot pilot;
	/**
	 * Méthode qui initialise le mouvement.
	 * @param p
	 */
	public TournerGauche(MovePilot p) {
		this.pilot = p;
	}
	
	@Override
	/**
	 * Méthode qui permet de prendre le contrôle pour tourner à gauche. 
	 */
	public boolean takeControl() {
		return GereChemin.mouvt==2;
	}

	@Override
	/**
	 * Méthode qui fait tourner le robot à gauche. 
	 */
	public void action() {
		if (GereChemin.mouvt!=5) {
			this.pilot.rotate(-75);
			this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
			pilot.stop();
			
			//On passe à la case actuelle
			GereChemin.indice+=1;
			//On réajuste les paramètres pour faire la vérification de couleur
			GereChemin.colorGood=false;
			GereChemin.mouvt=5;
			System.out.println("Je tourne a gauche...");
		}
		
		//TODO verif gyroscope
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
