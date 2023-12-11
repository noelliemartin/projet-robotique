package AI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import logique.Carte;
import logique.Case;
import logique.IParams;

public class Graphe {

	private HashSet<Noeud> noeuds = new HashSet<>();
	
	
	public Graphe(Carte c) {
		//construit un graphe à partir d'une carte
		Case[][] map = c.getMap();
		
		//générer tous les noeuds
		//Case[][] map = new Case[IParams.dimensionCol][IParams.dimensionLigne];
		for(int i = 0; i < IParams.dimensionCol; i++) { // x: 7
			for(int y = 0; y < IParams.dimensionLigne; y++) {  //y: 5
				this.noeuds.add(new Noeud(i, y, map[i][y].getCout()));
			}
		}
		
		//associes les voisins aux noeuds correspondants en fonction des déplacements possibles
		for(Noeud n : this.noeuds) {
			ArrayList<Noeud> voisinTemp = new ArrayList<>();
			try {
			if (n.getX()-1 >= 0) //gauche
				voisinTemp.add(trouverNoeud(n.getX()-1, n.getY()));
				
			if (n.getY()+1 < IParams.dimensionLigne) //haut
				voisinTemp.add(trouverNoeud(n.getX(), n.getY()+1));
			
			if (n.getY()-1 >= 0) //bas
				voisinTemp.add(trouverNoeud(n.getX(), n.getY()-1));
			
			if (n.getX()+1 < IParams.dimensionCol) //droite
				voisinTemp.add(trouverNoeud(n.getX()+1, n.getY()));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			n.setVoisins(voisinTemp);
		}
	}
	
	
	private void compterVoisins() {
		int res = 0;
		for(Noeud n : this.noeuds) {
			res += n.getVoisins().size();
		}
		System.out.println("Nombre de voisins "+res);
	}
	
	
	private Noeud trouverNoeud(int x, int y) throws Exception {
		for (Noeud n : this.noeuds) {
			if(n.getX() == x && n.getY() == y) return n;
		}
		throw new Exception("Positions invalides, noeud non trouvé : x:"+x+"/y:"+y);
	}
	
	
	public Noeud trouverNoeud(Case c) throws Exception {
		return trouverNoeud(c.getX(), c.getY());
	}
}
