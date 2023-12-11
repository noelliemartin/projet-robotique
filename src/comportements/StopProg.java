package comportements;

import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class StopProg implements Behavior {
	Arbitrator arby;
	EV3ColorSensor cs;
	MovePilot pilot;
	
	public StopProg( EV3ColorSensor cs,MovePilot pilot) {
		this.cs=cs;
		this.pilot=pilot;
	}

	@Override
	public boolean takeControl() {
		return GereChemin.mouvt==-2;
	}

	@Override
	public void action() {
		Sound.systemSound(true, 3);
		pilot.stop();
        Motor.B.stop(true);
        Motor.C.stop(true);
        cs.close();
        arby.stop();
        System.exit(0);
	}

	public void setArbitrator(Arbitrator a) {this.arby = a;}
	
	@Override
	public void suppress() {
	}

}
