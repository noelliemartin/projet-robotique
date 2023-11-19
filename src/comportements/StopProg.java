package comportements;

import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * 
 * Classe qui stoppe le programme de manière propre. 
 * Cela peut arriver lorsque le robot ne détecte plus la bonne couleur, ou s'il a
 * fini de parcourir le chemin.
 *
 */
public class StopProg implements Behavior {
	private Arbitrator arby;
	private EV3ColorSensor cs;
	private MovePilot pilot;
	
	/**
	 * Méthode qui initialise le moyen de stopper le robot.
	 * @param cs
	 * @param pilot
	 */
	public StopProg( EV3ColorSensor cs,MovePilot pilot) {
		this.cs=cs;
		this.pilot=pilot;
	}

	@Override
	/**
	 * Méthode qui permet de prendre le contrôle pour stopper le robot. 
	 */
	public boolean takeControl() {
		return GereChemin.mouvt==-2;
	}

	@Override
	/**
	 * Méthode qui permet de stopper le robot. 
	 */
	public void action() {
		Sound.systemSound(true, 3);
		pilot.stop();
        Motor.B.stop(true);
        Motor.C.stop(true);
        cs.close();
        arby.stop();
        System.exit(0);
	}

	/**
	 * Méthode pour obtenir l'arbitrator. 
	 * @param a
	 */
	public void setArbitrator(Arbitrator a) {this.arby = a;}
	
	@Override
	public void suppress() {
	}

}
