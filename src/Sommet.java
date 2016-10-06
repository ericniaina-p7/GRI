import java.util.ArrayList;
import java.util.List;

public class Sommet {
	private String numSommet;
	private List<Sommet> sortants;
	private List<Sommet> entrants;

	public Sommet(String numSommet) {
		this.numSommet = numSommet;
		sortants = new ArrayList<Sommet>();
		entrants = new ArrayList<Sommet>();
	}

	public String getNumSommet() {
		return numSommet;
	}

	public void setNumSommet(String numSommet) {
		this.numSommet = numSommet;
	}

	public void ajouterSortie(Sommet s) {
		sortants.add(s);
		s.entrants.add(this);
	}

	public int degEntrant() {
		return entrants.size();
	}

	public int degSortant() {
		return sortants.size();
	}
}
