package comportements;

import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;
import logique.IParams;

public class Avancer implements Behavior{

	MovePilot pilot;
	
	public Avancer(MovePilot p) {
		this.pilot = p;
	}
	
	@Override
	public boolean takeControl() {
		return GereChemin.mouvt==1;
	}

	@Override
	public void action() {
		if(GereChemin.mouvt!=5) {
			pilot.setLinearSpeed(60.);
			this.pilot.travel((IParams.dimensionCase*10) +(IParams.dimensionTraitNoir*10) ); 
			pilot.stop();
			System.out.println("J'avance...");
			//On passe � la case actuelle
			GereChemin.indice+=1;
			//On r�ajuste les param�tres pour faire la v�rification de couleurs.
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
