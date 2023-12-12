package comportements;

import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;
import logique.IParams;

public class TournerDroite implements Behavior{

	MovePilot pilot;
	
	public TournerDroite(MovePilot p) {
		this.pilot = p; 
	}
	
	@Override
	public boolean takeControl() {
		return GereChemin.mouvt==3;
	}

	@Override
	public void action() {
		if(GereChemin.mouvt!=5) {
			this.pilot.travel(IParams.dimensionCase*10);
			this.pilot.rotate(77);
			this.pilot.travel((IParams.dimensionCase*10)-5);
			pilot.stop();
			System.out.println("Je tourne a droite...");
			//On indique qu'on passe à la case suivante
			GereChemin.indice+=1;
			//On réajuste ces paramètres pour faire la vérification de couleur
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
