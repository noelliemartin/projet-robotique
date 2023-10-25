package comportements;

import lejos.hardware.Sound;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.subsumption.Behavior;
import logique.IParams;

public class VerifCouleurs implements Behavior{

	EV3ColorSensor colorSensor;
	float[] tab;
	
	public VerifCouleurs(EV3ColorSensor color, float[] t) {
		this.colorSensor = color;
		this.tab = t;
	}
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return GereChemin.mouvt==0;
		
	}

	@Override
	public void action() {
		if(GereChemin.mouvt!=6) {
			this.colorSensor.getRGBMode().fetchSample(this.tab, 0);
			
			System.out.println("r: "+this.tab[0]+"g: "+this.tab[1]+"b: "+this.tab[2]);

			float[] couleurRef = GereChemin.cheminCouleurs[GereChemin.indice];  
			
			double seuil = 0.20;
			
			boolean isColorGood = true;
			
			for (int i = 0; i < 3; i++) {
				float currentColor = this.tab[i]*1000;
				
				if(currentColor > 255)currentColor = 255;
				
				if(!(currentColor >= couleurRef[i] - 255*seuil && currentColor <= couleurRef[i] + 255*seuil)){
					isColorGood = false;
					break;
				}
			}
			//TODO : remettre ce code en place
			
			GereChemin.colorGood= isColorGood;
			//GereChemin.colorGood=true;
			System.out.println("Je verifie la couleur...");
			//System.out.println(isColorGood);
			GereChemin.mouvt=6;
		}
		
	}

	@Override
	public void suppress() {
		
		
	}
	
}
