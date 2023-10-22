package comportements;

import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class TournerGauche implements Behavior{
	
	MovePilot pilot;
	
	public TournerGauche(MovePilot p) {
		this.pilot = p;
	}
	
	@Override
	public boolean takeControl() {
		return GereChemin.mouvt==2;
	}

	@Override
	public void action() {
		if (GereChemin.mouvt!=5) {
			this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
			this.pilot.rotate(-100);
			this.pilot.travel(120 + 15); //TODO magic number (avance de X mm)
			pilot.stop();
			
			//On passe � la case actuelle
			GereChemin.indice+=1;
			//On r�ajuste les param�tres pour faire la v�rification de couleur
			GereChemin.colorGood=false;
			GereChemin.mouvt=5;
			System.out.println("Je tourne a gauche...");
		}
		
		//TODO verif gyroscope
	}

	@Override
	public void suppress() {
		Motor.B.stop(true);
        Motor.C.stop(true);
		pilot.stop();
		
	}

}
