import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;


public class Tarjan {
	private Stack<Sommet> tarjanStack;
	int i;
	
	public Tarjan() {
		Graph g = new Graph();
		for(Entry<String, Sommet> entry : g.sommets.entrySet()) {
		    String key = entry.getKey();
		    Sommet value = entry.getValue();
		    
		    // do what you have to do here
		    // In your case, an other loop.
		}
	}
}
