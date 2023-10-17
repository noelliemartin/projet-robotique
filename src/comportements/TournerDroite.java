package comportements;

import lejos.hardware.Button;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class TournerDroite implements Behavior{

	MovePilot pilot;
	
	public TournerDroite(MovePilot p) {
		this.pilot = p; 
	}
	
	@Override
	public boolean takeControl() {
		boolean v = Button.RIGHT.isDown();
		if(v) System.out.println("droite");
		return v;
	}

	@Override
	public void action() {
		this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
		this.pilot.rotate(-90);
		this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
