package comportements;

import lejos.hardware.Sound;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.subsumption.Behavior;
import logique.IParams;

public class VerifCouleurs implements Behavior{

	EV3ColorSensor colorSensor;
	float[] currentColor;
	
	public VerifCouleurs(EV3ColorSensor color, float[] t) {
		this.colorSensor = color;
		this.currentColor = t;
	}
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return GereChemin.mouvt==0;
		
	}

	@Override
	public void action() {
		if(GereChemin.mouvt!=6) {
			this.colorSensor.getRGBMode().fetchSample(this.currentColor, 0);
			
			float[] couleurRef = GereChemin.cheminCouleurs[GereChemin.indice];  
			double seuil = 0.20;
			
			boolean isColorGood = true;
			for (int i = 0; i < 3; i++) {
				float currentColor = this.currentColor[i]*1000;
				if(currentColor > 255)currentColor = 255;
				
				if(!(currentColor >= couleurRef[i]*1000 - 255*seuil && currentColor <= couleurRef[i]*1000 + 255*seuil)){
					isColorGood = false;
					break;
				}
			}
			//Phase de test
			//System.out.println("Couleur ref"+IParams.detectColor(couleurRef));
			//System.out.println("Couleur ref"+couleurRef[0]+" "+couleurRef[1]+ " "+ couleurRef[2]);
			//System.out.println("Couleur current"+IParams.detectColor(this.currentColor));
			//System.out.println("Couleur current"+currentColor[0]+ " "+ currentColor[1]+" "+currentColor[2]);
			
			GereChemin.colorGood= isColorGood;
			System.out.println("Je verifie la couleur...");
			GereChemin.mouvt=6;
		}
		
	}

	@Override
	public void suppress() {
		
		
	}
	
}
