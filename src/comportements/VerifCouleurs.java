package comportements;

import lejos.hardware.Sound;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.subsumption.Behavior;
import logique.IParams;

public class VerifCouleurs implements Behavior, IParams{

	EV3ColorSensor colorSensor;
	float[] tab;
	
	public VerifCouleurs(EV3ColorSensor color, float[] t) {
		this.colorSensor = color;
		this.tab = t;
	}
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		
		return true;
	}

	@Override
	public void action() {
		this.colorSensor.getRGBMode().fetchSample(this.tab, 0);
		
		System.out.println("r: "+this.tab[0]+"g: "+this.tab[1]+"b: "+this.tab[2]);

		float[] couleurRef = WHITE;  
		
		double seuil = 0.30;
		
		boolean isColorGood = true;
		
		for (int i = 0; i < 3; i++) {
			float currentColor = this.tab[i]*1000;
			
			if(currentColor > 255)currentColor = 255;
			
			if(!(currentColor >= couleurRef[i] - couleurRef[i]*seuil && currentColor <= couleurRef[i] + couleurRef[i]*seuil)){
				isColorGood = false;
				break;
			}
		}
		
		System.out.println(isColorGood);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
}
