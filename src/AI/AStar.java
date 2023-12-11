package AI;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

import logique.Carte;
import logique.Case;
import logique.IParams;

public class AStar {
	
	public static int[][] trouverChemin(Carte c){
		
		Graphe g = new Graphe(c);
		ArrayList<Noeud> resultat = new ArrayList<>();
		try {
			resultat =  trouverChemin(g.trouverNoeud(c.getCaseDepart()), g.trouverNoeud(c.getCaseArrivee()));
			System.out.println(resultat);
		} catch (Exception e) { e.printStackTrace(); return null;}
		
		//convertir l'output en liste de positions
		int[][] chemin = new int[resultat.size()][2];
		int i = 0;
		for (Noeud n : resultat) {
			chemin[i] = new int[] {n.getX(), n.getY()};
			i++;
		}
		return chemin;
	}
	
	private static ArrayList<Noeud> trouverChemin(Noeud depart, Noeud arrivee) throws Exception {
		PriorityQueue<Noeud> openSet = new PriorityQueue<>();
		HashSet<Noeud> closedSet = new HashSet<>();
		ArrayList<Noeud> chemin = new ArrayList<>();
		
		openSet.add(depart);
		while(!openSet.isEmpty()) {
			Noeud courant = openSet.poll();
			closedSet.add(courant);
			
			if(courant.equals(arrivee)){
				while (!courant.equals(depart)) {
					chemin.add(courant);
					courant = courant.getParent();
				}
				return chemin;
			}
			
			for (Noeud voisin : courant.getVoisins()){
				if(closedSet.contains(voisin)) {
					continue;
				}
				
				int cout = courant.getgCost() + heuristic_cost_estimate(courant, voisin);
				if(cout < voisin.getgCost() || !openSet.contains(voisin)) {
					voisin.setgCost(cout);
					voisin.sethCost(heuristic_cost_estimate(voisin, arrivee));
					voisin.setParent(courant);
					
					if(!openSet.contains(voisin))
						openSet.add(voisin);
				}
			}
		}
		throw new Exception("Aucun chemin trouvé");
	}
	
	private static int heuristic_cost_estimate(Noeud noeudA, Noeud noeudB){
		int deltaX = Math.abs(noeudA.getX() - noeudB.getX());
		int deltaY = Math.abs(noeudA.getY() - noeudB.getY());
		
		if (deltaX > deltaY)
			return 14 * deltaY + 10 * (deltaX - deltaY);
		return 14 * deltaX + 10 * (deltaY - deltaX); 
	}
	
}
