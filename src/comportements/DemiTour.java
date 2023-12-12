package comportements;

import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class DemiTour implements Behavior {
	MovePilot pilot;
	
	public DemiTour(MovePilot p) {
		this.pilot = p; 
	}

	@Override
	public boolean takeControl() {
		return GereChemin.mouvt==-1;
	}

	@Override
	public void action() {
		if(GereChemin.mouvt!=5) {
			pilot.setLinearSpeed(30.);
			pilot.rotate(180);
			this.pilot.travel(120 + 15);
			pilot.stop();
			System.out.println("Je fais demi-tour...");
			GereChemin.indice-=1;
			GereChemin.mouvt=5;
			GereChemin.colorGood=false;
		}
		
		
	}

	@Override
	public void suppress() {
		Motor.B.stop(true);
        Motor.C.stop(true);
		pilot.stop();
		
		
	}

}
