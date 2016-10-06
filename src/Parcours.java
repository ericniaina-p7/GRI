
public class Parcours {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = Graph.CreateGraphFromFile(args[0]);

		Sommet s = g.getSommet(args[1]);

		System.out.println(s.degSortant() + 1);
	}

}
