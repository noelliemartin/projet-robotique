package main;

import comportements.Avancer;
import comportements.DemiTour;
import comportements.EmergencyStop;
import comportements.GereChemin;
import comportements.StopProg;
import comportements.TournerDroite;
import comportements.TournerGauche;
import comportements.VerifCouleurs;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import logique.Main_logique;

public class Main {
	
	public static void main(String[] args) {
		//Récupérer le chemin avec les coordonnées et les couleurs
		Main_logique vals_theo = new Main_logique ();
		int [][] chemin= vals_theo.getChemin1();
		float[][] cheminCouleurs= vals_theo.getCheminColors();
		System.out.println(cheminCouleurs);
		
		System.out.println("Pressez un bouton.");
		//Attente de l'intialisation
		Button.waitForAnyPress();
		
		//Initialisation du movepilot
		Wheel wheel1 = WheeledChassis.modelWheel(Motor.B, 56.).offset(-60);
		Wheel wheel2 = WheeledChassis.modelWheel(Motor.C, 56.).offset(60);
		Chassis chassis = new WheeledChassis(new Wheel[] {wheel1, wheel2}, 2);
		MovePilot pilot = new MovePilot(chassis);
		pilot.setLinearSpeed(60.);
		pilot.setAngularSpeed(60.);
		
		//EV3TouchSensor ts = new EV3TouchSensor(SensorPort.S1);
		//EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S3);
		//EV3GyroSensor gs = new EV3GyroSensor(SensorPort.S2);
		
		EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S3);
		//012 => colors ; 3 => gyro
		float[] s = new float[3];
		
		//Création des behaviors
		EmergencyStop emergencyStop = new EmergencyStop(cs,pilot);
		Behavior avancer = new Avancer(pilot);
		Behavior tournerGauche = new TournerGauche(pilot);
		Behavior tournerDroite = new TournerDroite(pilot);
		Behavior verifCouleurs = new VerifCouleurs(cs, s);
		Behavior demiTour= new DemiTour(pilot);
		StopProg stopProg= new StopProg(cs, pilot);
		Behavior gereChemin= new GereChemin(cheminCouleurs, chemin);
		
		
		Behavior[] behaviors = {gereChemin, avancer, tournerGauche, tournerDroite, demiTour, verifCouleurs, stopProg, emergencyStop};
		
		
		Arbitrator arbitrator = new Arbitrator(behaviors);
		emergencyStop.setArbitrator(arbitrator);
		stopProg.setArbitrator(arbitrator);
		arbitrator.go();
		
	}
	
}
