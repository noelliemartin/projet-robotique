package comportements;

import lejos.hardware.Sound;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.subsumption.Behavior;
import logique.IParams;

/**
 * 
 * Classe qui permet au robot de v�rifier s'il est sur la bonne couleur. 
 *
 */
public class VerifCouleurs implements Behavior{

	private EV3ColorSensor colorSensor;
	private float[] currentColor;
	/**
	 * m�thode qui initialise l'action. 
	 * @param color
	 * @param t
	 */
	public VerifCouleurs(EV3ColorSensor color, float[] t) {
		this.colorSensor = color;
		this.currentColor = t;
	}
	
	@Override
	/**
	 * M�thode qui permet de prendre le contr�le pour v�rifier les couleurs. 
	 */
	public boolean takeControl() {
		return GereChemin.mouvt==0;
		
	}

	@Override
	/**
	 * M�thode qui permet de v�rifier la couleur de la case. 
	 */
	public void action() {
		if(GereChemin.mouvt!=6) {
			//On prend la couleur que le robot d�tecte
			this.colorSensor.getRGBMode().fetchSample(this.currentColor, 0);
			
			//System.out.println("r: "+this.tab[0]+"g: "+this.tab[1]+"b: "+this.tab[2]);
			//On prend la couleur que l'on est sens� avoir � cette case l�
			float[] couleurRef = GereChemin.cheminCouleurs[GereChemin.indice];  
			//On met en place un seuil d'acceptation de la couleur. 
			double seuil = 0.20;
			
			boolean isColorGood = true;
			//On v�rifie si la couleur est la bonne. 
			for (int i = 0; i < 3; i++) {
				float currentColor = this.currentColor[i]*1000;
				if(currentColor > 255)currentColor = 255;
				
				if(!(currentColor >= couleurRef[i]*1000 - 255*seuil && currentColor <= couleurRef[i]*1000 + 255*seuil)){
					isColorGood = false;
					break;
				}
			}
			
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
