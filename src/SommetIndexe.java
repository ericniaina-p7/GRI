public class SommetIndexe extends Sommet {

	private int index;
	private int decouverte;

	public SommetIndexe(String numSommet) {
		super(numSommet);
		// TODO Auto-generated constructor stub
		index = -1;
		decouverte = -1;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getDecouverte() {
		return decouverte;
	}

	public void setDecouverte(int decouverte) {
		this.decouverte = decouverte;
	}
}
