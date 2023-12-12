package bluetooth;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import AI.AStar;
import lejos.hardware.Bluetooth;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.remote.nxt.BTConnection;
import lejos.remote.nxt.BTConnector;
import lejos.remote.nxt.NXTConnection;
import logique.Carte;
import logique.Case;
import logique.IParams;
import logique.Main_logique;
import logique.IParams.ExerciceSelection;

public class Main_bluetooth {
	// classe du robot emetteur
		
	//Méthode pour traiter l'envoi du message en bluetooth

	public static void main(String[] args) throws IOException{
		boolean exercice2 = true;
		
		System.out.println("Bouton gauche: exercice3 / bouton droit: exercice2");
		switch (Button.waitForAnyPress()) {
			case Button.ID_LEFT:
				System.out.println("Exercice 3");
				exercice2 = false;
				break;
			case Button.ID_RIGHT:
				System.out.println("Exercice 2");
				exercice2 = true;
				break;
		}
		
		//recherche du robot correspondant à l'adresse pour la connexion
		BTConnector bt = new BTConnector();
		//remplacer par le nom/ip du robot récepteur
		BTConnection nxt = bt.connect("Cersei9",NXTConnection.PACKET);
		System.out.println("ouinxt");
		
		/*
		Case[][] map = new Case[IParams.dimensionCol][IParams.dimensionLigne];
		Carte carte = new Carte(map, IParams.depart, IParams.arrive);
		*/


		if (nxt != null) {
			//création de la carte
			Main_logique vals_theo = new Main_logique ();
			
			//Création du bluetooth pour l'envoi
			System.out.println("Connexion établie !");
			DataOutputStream data = nxt.openDataOutputStream();
			//Récupération de la carte à envoyer
			String message = "Message vide";
			if(exercice2) {
				message = Main_logique.returnCarte();				
			}else {
				message = Arrays.deepToString(AStar.trouverChemin(vals_theo.getCarte()));
			}
			System.out.println("J'envoie ce message :");
			System.out.println(message);
			//Envoi du message
			try {
				data.writeUTF(message);
				data.flush();
				System.out.println("Message envoyé !");
			} catch (Exception e) {
				System.out.println("Erreur lors de l'envoi...");
			} finally {
				try {
					//fermeture des flux
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
	
	//Methode qui permet d'envoyer la carte sous forme de string
	
	/*
	private static String returnCarte() {
		String resultat="";
		for (int i=0;i<IParams.dimensionCol;i++) {
			resultat = resultat + "[";
			for (int j=0;j<IParams.dimensionLigne;j++) {
				resultat += " " + detectColor(tabColor[i][j]) + " ";
			}
			resultat += "]";
		}
		return resultat;
	}*/
	

}
