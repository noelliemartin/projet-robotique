package comportements;

import lejos.hardware.Sound;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.subsumption.Behavior;
import logique.IParams;

/**
 * 
 * Classe qui permet au robot de vérifier s'il est sur la bonne couleur. 
 *
 */
public class VerifCouleurs implements Behavior{

	private EV3ColorSensor colorSensor;
	private float[] currentColor;
	/**
	 * méthode qui initialise l'action. 
	 * @param color
	 * @param t
	 */
	public VerifCouleurs(EV3ColorSensor color, float[] t) {
		this.colorSensor = color;
		this.currentColor = t;
	}
	
	@Override
	/**
	 * Méthode qui permet de prendre le contrôle pour vérifier les couleurs. 
	 */
	public boolean takeControl() {
		return GereChemin.mouvt==0;
		
	}

	@Override
	/**
	 * Méthode qui permet de vérifier la couleur de la case. 
	 */
	public void action() {
		if(GereChemin.mouvt!=6) {
			//On prend la couleur que le robot détecte
			this.colorSensor.getRGBMode().fetchSample(this.currentColor, 0);
			
			//System.out.println("r: "+this.tab[0]+"g: "+this.tab[1]+"b: "+this.tab[2]);
			//On prend la couleur que l'on est sensé avoir à cette case là
			float[] couleurRef = GereChemin.cheminCouleurs[GereChemin.indice];  
			//On met en place un seuil d'acceptation de la couleur. 
			double seuil = 0.20;
			
			boolean isColorGood = true;
			//On vérifie si la couleur est la bonne. 
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
