package logique;

public class IParams {
	
	public static final double dimensionTraitNoir = 1.5;
	public static final int dimensionCase = 12;
	
	public static final int dimensionLigne = 5;
	public static final int dimensionCol = 7;
	
	public static final int[] depart = {0, 4};
	public static final int[] arrive = {6, 0};
	public static final int longChemin1 = 11;
	
	public static float[] WHITE = {255, 255, 153};
	public static float[] RED = {210, 25, 12};
	public static float[] BLUE = {40, 45, 51};
	public static float[] GREEN = {72, 147, 27};
	public static float[] ORANGE = {210, 62, 15};
	
	
	public static float[][][] tabColor = {{IParams.RED, IParams.BLUE, IParams.GREEN, IParams.GREEN, IParams.WHITE}, {IParams.GREEN, IParams.BLUE, IParams.GREEN, IParams.GREEN, IParams.GREEN}, {IParams.GREEN, IParams.BLUE, IParams.BLUE,
		IParams.GREEN, IParams.ORANGE}, {IParams.GREEN, IParams.GREEN, IParams.BLUE, IParams.GREEN, IParams.GREEN}, {IParams.GREEN, IParams.ORANGE, IParams.ORANGE, IParams.ORANGE, IParams.GREEN}, {IParams.GREEN, 
			IParams.GREEN, IParams.GREEN, IParams.RED, IParams.BLUE}, {IParams.WHITE, IParams.GREEN, IParams.GREEN, IParams.GREEN, IParams.BLUE}};
	
	public static enum ExerciceSelection{ EXERCICE1, EXERCICE2, EXERCICE3 }
	
	/**
	 * Méthode qui permet de pouvoir afficher une couleur sous un format compréhensible.
	 * @param couleur 
	 * @return une couleur sous la forme d'une lettre. 
	 */
	public static String detectColor(float[] couleur) {
		if(couleur[0]==IParams.RED[0] && couleur[1]==IParams.RED[1] && couleur[2]==IParams.RED[2]) {
			return "R";
		}
		else if(couleur[0]==IParams.GREEN[0] && couleur[1]==IParams.GREEN[1] && couleur[2]==IParams.GREEN[2]) {
			return "G";
		}
		else if(couleur[0]==IParams.BLUE[0] && couleur[1]==IParams.BLUE[1] && couleur[2]==IParams.BLUE[2]) {
			return "B";
		}
		else if (couleur[0]==IParams.WHITE[0] && couleur[1]==IParams.WHITE[1] && couleur[2]==IParams.WHITE[2]) {
			return "W";
		}
		else {
			return "O";
		}
		
	}

	public static float [][][] getCarteColors() {
		float [][][] carteColors = {{IParams.RED, IParams.BLUE, IParams.GREEN, IParams.GREEN, IParams.WHITE}, {IParams.GREEN, IParams.BLUE, IParams.GREEN, IParams.GREEN, IParams.GREEN}, {IParams.GREEN, IParams.BLUE, IParams.BLUE,
			IParams.GREEN, IParams.ORANGE}, {IParams.GREEN, IParams.GREEN, IParams.BLUE, IParams.GREEN, IParams.GREEN}, {IParams.GREEN, IParams.ORANGE, IParams.ORANGE, IParams.ORANGE, IParams.GREEN}, {IParams.GREEN, 
				IParams.GREEN, IParams.GREEN, IParams.RED, IParams.BLUE}, {IParams.WHITE, IParams.GREEN, IParams.GREEN, IParams.GREEN, IParams.BLUE}};
		return carteColors;
	}
}
