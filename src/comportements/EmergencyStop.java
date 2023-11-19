package comportements;

import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * 
 * Classe qui permet de stopper le robot en cas de probl�me majeur.
 * Il suffit d'appuyer sur le bouton gauche du robot.
 *
 */
public class EmergencyStop implements Behavior{
	private Arbitrator arby;
	private EV3ColorSensor cs;
	private MovePilot pilot;
    /**
     * M�thode qui permet d'initialiser l'action
     * @param cs
     * @param pilot
     */
    public EmergencyStop(EV3ColorSensor cs, MovePilot pilot) {
    	this.cs = cs;this.pilot=pilot;}
    
    @Override
    /**
     * M�thode qui permet de prendre le contr�le pour arr�ter le robot.
     */
    public boolean takeControl() {
        return Button.LEFT.isDown();
    }
    
    @Override
    /**
     * M�thode qui permet de stopper le robot. 
     */
    public void action() {
    	pilot.stop();
        Motor.B.stop(true);
        Motor.C.stop(true);
        cs.close();
        arby.stop();
        System.exit(0);
    }
    
    @Override
	public void suppress() {
		
	}
    
    /**
     * M�thode qui permet d'obtenir l'arbitrator.
     * @param a
     */
    public void setArbitrator(Arbitrator a) {this.arby = a;}
}
