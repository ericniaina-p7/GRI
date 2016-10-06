import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Graph {
	HashMap<String, Sommet> sommets;

	String nom;
	String type;

	int nombreArc = 0;

	private final static Charset ENCODING = StandardCharsets.UTF_8;

	public Graph() {
		sommets = new HashMap<String, Sommet>();
	}

	public static Graph CreateGraphFromFile(String filename) {
		Graph g = new Graph();

		try (Scanner scanner = new Scanner(new FileInputStream(filename), ENCODING.name())) {
			// Extracting First Line
			if (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String graphName[] = line.split(" ");
				g.type = graphName[0];
				g.nom = graphName[1];
			}

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				line = line.replace(';', ' ').trim();
				if (line.trim().compareTo("}") == 0) {
					break;
				}
				String edgeData[] = line.split("->");
				if (edgeData.length > 1) {
					Sommet start = g.ajouterSommet(edgeData[0].trim());
					Sommet end = g.ajouterSommet(edgeData[1].trim());
					start.ajouterSortie(end);
					g.nombreArc++;
				} else {
					g.ajouterSommet(edgeData[0].trim());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return g;
	}

	public Sommet ajouterSommet(String nodeName) {
		if (sommets.containsKey(nodeName)) {
			return sommets.get(nodeName);
		}
		Sommet newNode = new Sommet(nodeName);
		sommets.put(nodeName, newNode);
		return newNode;
	}

	public Sommet getSommet(String numSommet) {
		return sommets.get(numSommet);
	}

	public int getNbArc() {
		// TODO Auto-generated method stub
		return nombreArc;
	}

	public int getDegreMaxEntrant() {
		int max = 0;
		for (Entry<String, Sommet> entry : sommets.entrySet()) {
			Sommet value = entry.getValue();
			if (value.degEntrant() > max) {
				max = value.degEntrant();
			}
		}
		return max;
	}

	public int getNbSommet() {
		// TODO Auto-generated method stub
		return sommets.size();
	}

	public int getDegreMaxSortant() {
		// TODO Auto-generated method stub
		int max = 0;
		for (Entry<String, Sommet> entry : sommets.entrySet()) {
			Sommet value = entry.getValue();
			if (value.degSortant() > max) {
				max = value.degSortant();
			}
		}
		return max;
	}

	public int getMaxNbNode() {
		// TODO Auto-generated method stub
		int max = 0;
		for (Entry<String, Sommet> entry : sommets.entrySet()) {
			String key = entry.getKey();
			int sommet = Integer.parseInt(key);
			if (sommet > max) {
				max = sommet;
			}
		}
		return max;
	}
}
