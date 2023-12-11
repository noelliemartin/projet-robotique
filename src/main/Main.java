package main;

import java.io.DataInputStream;
import java.util.Arrays;

import AI.AStar;
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
import lejos.remote.nxt.BTConnector;
import lejos.remote.nxt.NXTConnection;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import logique.Carte;
import logique.Case;
import logique.IParams;
import logique.IParams.ExerciceSelection;
import logique.Main_logique;
import utilitaires.Etalonnage;

public class Main {
	
	private static ExerciceSelection selectExercice() {
		System.out.println("Bouton de gauche -> Exercice 1 \n Bouton du haut -> Exercice 2 \n Bouton de droite -> Exercice 3");
		switch (Button.waitForAnyPress()) {
			case Button.ID_LEFT:
				return ExerciceSelection.EXERCICE1;
			case Button.ID_UP:
				return ExerciceSelection.EXERCICE2;
			case Button.ID_RIGHT: 
				return ExerciceSelection.EXERCICE3;
			default:
				return ExerciceSelection.EXERCICE1;
		}
	}
	
	public static void main(String[] args) {
		Carte carte = null;
		int[][] chemin = null;
		
		switch(selectExercice()) {
			case EXERCICE1:
				//Initialisation des objets mÃ©tiers
				System.out.println("Exercice 1");
				Main_logique main_logique = new Main_logique();
				carte = main_logique.getCarte();
				chemin = main_logique.getChemin1();
				break;
			case EXERCICE2:
				System.out.println("Exercice 2");
				//Thread pour le bluetooth
		        reception();
				break;
			case EXERCICE3:
				System.out.println("Exercice 3");
				//Thread pour le bluetooth
		        reception();
				break;
		}
		
		//Construction du chemin avec A*
		float[][] cheminCouleurs = carte.getCheminColors(chemin, IParams.tabColor);
		System.out.println(Arrays.deepToString(cheminCouleurs));
		
		EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S3);
		//Etalonnage
		Etalonnage.etalonner(cs);
		
		//Dï¿½but du parcours
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
		
		//EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S3);
		//EV3GyroSensor gs = new EV3GyroSensor(SensorPort.S2);
        
		float[] s = new float[3];
	
		//Creation des behaviors
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
	
	//M�thode pour traiter la r�ception du message en bluetooth
		private static void reception() {
			BTConnector bt = new BTConnector();
			NXTConnection nxt = bt.waitForConnection(100000, NXTConnection.PACKET);

	        if (nxt != null) {
	            System.out.println("Connexion établie");
	            DataInputStream data = nxt.openDataInputStream();
	    		//System.out.println("datainput");
	            try {
	            	String message = null;
	        		//System.out.println("avantwhile");
	        		while (message == null) {
	            		//System.out.println("search");
	                    message = data.readUTF();
	            		//System.out.println("read");
	                    // Traite le message
	                }
	                System.out.println("Message reçu !");
	                System.out.println(message);
	                System.out.println("Appuyez sur un bouton");
	                Button.waitForAnyPress();
	                System.exit(0);
	            } catch (Exception e) {
					System.out.println("Erreur lors de l'envoi...");
	            } finally {
	                try {
	                    data.close();
	                    nxt.close();
	                } catch (Exception e) {
						System.out.println("Erreur lors de la fermeture du bluetooth...");
	            }
	            }
	        } else {
				System.out.println("La connexion a échoué...");
	        }
	        
		}
	
}
