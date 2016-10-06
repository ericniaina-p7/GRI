
public class StatsDeBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = Graph.CreateGraphFromFile(args[0]);

		System.out.format("%d %d %d %d %d%n", g.getNbSommet(), g.getNbArc(), g.getDegreMaxSortant(),
				g.getDegreMaxEntrant(), g.getMaxNbNode());
	}

}
