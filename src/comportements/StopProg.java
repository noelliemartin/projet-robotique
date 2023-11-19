package comportements;

import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * 
 * Classe qui stoppe le programme de mani�re propre. 
 * Cela peut arriver lorsque le robot ne d�tecte plus la bonne couleur, ou s'il a
 * fini de parcourir le chemin.
 *
 */
public class StopProg implements Behavior {
	private Arbitrator arby;
	private EV3ColorSensor cs;
	private MovePilot pilot;
	
	/**
	 * M�thode qui initialise le moyen de stopper le robot.
	 * @param cs
	 * @param pilot
	 */
	public StopProg( EV3ColorSensor cs,MovePilot pilot) {
		this.cs=cs;
		this.pilot=pilot;
	}

	@Override
	/**
	 * M�thode qui permet de prendre le contr�le pour stopper le robot. 
	 */
	public boolean takeControl() {
		return GereChemin.mouvt==-2;
	}

	@Override
	/**
	 * M�thode qui permet de stopper le robot. 
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
	 * M�thode pour obtenir l'arbitrator. 
	 * @param a
	 */
	public void setArbitrator(Arbitrator a) {this.arby = a;}
	
	@Override
	public void suppress() {
	}

}
