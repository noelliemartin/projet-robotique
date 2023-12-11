package comportements;

import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class EmergencyStop implements Behavior{
	Arbitrator arby;
	EV3ColorSensor cs;
	MovePilot pilot;
    
    public EmergencyStop(EV3ColorSensor cs, MovePilot pilot) {
    	this.cs = cs;this.pilot=pilot;}
    
    @Override
    public boolean takeControl() {
        return Button.LEFT.isDown();
    }
    
    @Override
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
    
    public void setArbitrator(Arbitrator a) {this.arby = a;}
}
