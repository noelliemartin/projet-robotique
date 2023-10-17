package comportements;

import lejos.hardware.Button;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class TournerGauche implements Behavior{
	
	MovePilot pilot;
	
	public TournerGauche(MovePilot p) {
		this.pilot = p;
	}
	
	@Override
	public boolean takeControl() {
		boolean v = Button.LEFT.isDown();
		if(v) System.out.println("gauche");
		return v;
	}

	@Override
	public void action() {
		this.pilot.rotate(90);
		
		//TODO verif gyroscope
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
