package bluetooth;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import lejos.hardware.Bluetooth;
import lejos.hardware.lcd.LCD;
import lejos.remote.nxt.BTConnection;
import lejos.remote.nxt.BTConnector;
import lejos.remote.nxt.NXTConnection;
import logique.Carte;
import logique.Case;
import logique.IParams;
import logique.Main_logique;

public class Main_bluetooth {
	// classe du robot emetteur
		
	//M�thode pour traiter l'envoi du message en bluetooth

	public static void main(String[] args) throws IOException{
		//recherche du robot correspondant � l'adresse pour la connexion
		BTConnector bt = new BTConnector();
		//remplacer par le nom/ip du robot r�cepteur
		BTConnection nxt = bt.connect("Cersei9",NXTConnection.PACKET);
		System.out.println("ouinxt");
		
		/*
		Case[][] map = new Case[IParams.dimensionCol][IParams.dimensionLigne];
		Carte carte = new Carte(map, IParams.depart, IParams.arrive);
		*/


		if (nxt != null) {
			//cr�ation de la carte
			Main_logique vals_theo = new Main_logique ();
			int [][] chemin= vals_theo.getChemin1();
			float[][] cheminCouleurs= vals_theo.getCheminColors();
			
			//Cr�ation du bluetooth pour l'envoi
			System.out.println("Connexion �tablie !");
			DataOutputStream data = nxt.openDataOutputStream();
			//R�cup�ration de la carte � envoyer
			String message = Main_logique.returnCarte();
			System.out.println(message);
			//Envoi du message
			try {
				data.writeUTF(message);
				data.flush();
				System.out.println("Message envoy� !");
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
			System.out.println("La connexion a �chou�...");
		}
		
	}
	
	//M�thode qui permet d'envoyer la carte sous forme de string
	
	//Faire la m�thode qui transforme la carte en String et une autre m�thode de String � carte
	
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
