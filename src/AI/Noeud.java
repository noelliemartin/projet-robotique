package AI;

import java.util.ArrayList;

public class Noeud implements Comparable<Noeud>{
	private int x;
	private int y;
	private int gCost;
	private int hCost;
	private Noeud parent;
	private ArrayList<Noeud> voisins;

	public Noeud(int x, int y, int gCost) {
		this.x = x;
		this.y = y;
		this.gCost = gCost;
	}
	
	@Override
	public int compareTo(Noeud noeud) {
		if (this.gethCost() + this.getgCost() > noeud.gethCost() + noeud.getgCost())
			return 1;
		else if (this.gethCost() + this.getgCost() < noeud.gethCost() + noeud.getgCost())
			return -1;
		return 0;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Noeud)) return false; 
		Noeud autre = (Noeud) obj;
		return autre.x == x && autre.y == y && autre.gCost == gCost;
	}
	
	@Override
	public String toString() {
		return "x:"+this.x+"/y:"+this.y;
	}
	
	public void setgCost(int gCost) {
		this.gCost = gCost;
	}
	
	public int getgCost() {
		return gCost;
	}
	
	public void sethCost(int hCost) {
		this.hCost = hCost;
	}
	
	public int gethCost() {
		return hCost;
	}
	
	public void setParent(Noeud parent) {
		this.parent = parent;
	}
	
	public Noeud getParent() {
		return parent;
	}
	
	public ArrayList<Noeud> getVoisins() {
		return voisins;
	}
	
	public void setVoisins(ArrayList<Noeud> voisins) {
		this.voisins = voisins;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
