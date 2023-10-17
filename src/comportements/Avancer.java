package comportements;

import lejos.hardware.Button;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class Avancer implements Behavior{

	MovePilot pilot;
	
	public Avancer(MovePilot p) {
		this.pilot = p;
	}
	
	@Override
	public boolean takeControl() {
		//prends le controle le moteur logique lui dit
		boolean v = Button.UP.isDown();
		if(v) System.out.println("avancer");
		return v;
	}

	@Override
	public void action() {
		this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void suppress() {
		
		
	}
	
}
