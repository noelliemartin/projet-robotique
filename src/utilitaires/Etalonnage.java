package utilitaires;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;
import logique.IParams;

public class Etalonnage {
	public static void etalonner(EV3ColorSensor colorSensor) {
		float [] colorsIn = new float[3];
		
		System.out.println("Mettez le robot sur du :\nBLANC");
		Button.waitForAnyPress();
		colorSensor.getRGBMode().fetchSample(colorsIn, 0);
		IParams.WHITE = colorsIn;
		LCD.clear();
		
		System.out.println("Mettez le robot sur du :\nROUGE");
		Button.waitForAnyPress();
		colorSensor.getRGBMode().fetchSample(colorsIn, 0);
		IParams.RED = colorsIn;
		LCD.clear();
		
		System.out.println("Mettez le robot sur du :\nVERT");
		Button.waitForAnyPress();
		colorSensor.getRGBMode().fetchSample(colorsIn, 0);
		IParams.GREEN = colorsIn;
		LCD.clear();
		
		System.out.println("Mettez le robot sur du :\nBLEU");
		Button.waitForAnyPress();
		colorSensor.getRGBMode().fetchSample(colorsIn, 0);
		IParams.BLUE = colorsIn;
		LCD.clear();
		
		System.out.println("Mettez le robot sur du :\nORANGE");
		Button.waitForAnyPress();
		colorSensor.getRGBMode().fetchSample(colorsIn, 0);
		IParams.ORANGE = colorsIn;
		LCD.clear();
		
		System.out.println("Etalonnage terminé");
		
	}
}
