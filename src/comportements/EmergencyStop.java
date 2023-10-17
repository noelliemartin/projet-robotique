package comportements;

import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class EmergencyStop implements Behavior{
	EV3TouchSensor ts; Arbitrator arby;
	EV3ColorSensor cs;
    
    public EmergencyStop(EV3TouchSensor t, EV3ColorSensor cs) {this.ts = t; this.cs = cs;}
    
    @Override
    public boolean takeControl() {
        return Button.DOWN.isDown();
    }
    
    @Override
    public void action() {
        Motor.B.stop(true);
        Motor.C.stop(true);
        ts.close();
        cs.close();
        arby.stop();
        System.exit(0);
    }
    
    @Override
	public void suppress() {
		
	}
    
    public void setArbitrator(Arbitrator a) {this.arby = a;}
}
