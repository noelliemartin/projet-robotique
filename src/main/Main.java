package main;

import comportements.Avancer;
import comportements.EmergencyStop;
import comportements.TournerDroite;
import comportements.TournerGauche;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("attente...");
		//Attente de l'intialisation
		Button.waitForAnyPress();
		
		//Initialisation du movepilot
		Wheel wheel1 = WheeledChassis.modelWheel(Motor.B, 56.).offset(-60);
		Wheel wheel2 = WheeledChassis.modelWheel(Motor.C, 56.).offset(60);
		Chassis chassis = new WheeledChassis(new Wheel[] {wheel1, wheel2}, 2);
		MovePilot pilot = new MovePilot(chassis);
		pilot.setLinearSpeed(30.);
		pilot.setAngularSpeed(30.);
		
		EV3TouchSensor ts = new EV3TouchSensor(SensorPort.S1);
		EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S3);
		float[] s = new float[3];
		
		EmergencyStop emergencyStop = new EmergencyStop(ts, cs);
		Behavior avancer = new Avancer(pilot);
		Behavior tournerGauche = new TournerGauche(pilot);
		Behavior tournerDroite = new TournerDroite(pilot);
		
		Behavior[] behaviors = {avancer, tournerGauche, tournerDroite, emergencyStop};
		
		
		Arbitrator arbitrator = new Arbitrator(behaviors);
		emergencyStop.setArbitrator(arbitrator);
		arbitrator.go();
		
	}
	
}
