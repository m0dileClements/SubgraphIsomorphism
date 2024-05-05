import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Arrays;

public class Approximate {
	Graph G; // larger
	Graph H; // smaller
	int[][] adjMatrix;
	ArrayList<List<Vertex>> pairs;
	ArrayList<Vertex> verticesLeftG;
	ArrayList<Vertex> verticesLeftH;
	
	public Approximate(Graph G, Graph H) {
		this.G = G;
		this.H = H;
		this.adjMatrix = new int[H.adjMatrix.length][H.adjMatrix.length];
		this.pairs = new ArrayList<List<Vertex>>();
		this.verticesLeftG = G.vertices;
		this.verticesLeftH = H.vertices;
	}
	
	// TODO
	public boolean guessAndCheck() {
		//lists of the possible neighbors for the two vertices being analyzed (vG and vH)
		ArrayList<Vertex> hPossNeigh = new ArrayList<Vertex>();
		ArrayList<Vertex> gPossNeigh = new ArrayList<Vertex>();
		Vertex vG = G.verticesSorted.get(0);
		Vertex vH = H.verticesSorted.get(0);
		ArrayList<Vertex> newPair = new ArrayList<>(Arrays.asList(vG, vH));
		pairs.add(newPair);
		verticesLeftG.remove(vG);
		verticesLeftH.remove(vH);

		
		Random random = new Random();
		//checks to make sure all of the vertices are mapped
		while (verticesLeftH.size() != 0) {
			hPossNeigh = avaNeighbor(vH);
			gPossNeigh = avaNeighbor(vG);

			//if there are available neighbors in H and G, match the highest vertex in H to a random vertex in G
			if (hPossNeigh.size() > 0 && gPossNeigh.size() > 0){
				newPair.clear();
				int gRandomVert = random.nextInt(gPossNeigh.size());
				vG = gPossNeigh.get(gRandomVert);
				newPair.add(vG);
				vH = hPossNeigh.get(0);
				newPair.add(vH);
				pairs.add(newPair);
				verticesLeftG.remove(vG);
				verticesLeftH.remove(vH);
			} else {
				if (hPossNeigh.size() == 0) {
					int hNewRandVert = random.nextInt(verticesLeftH.size());
					if (isAdjacent(verticesLeftH.get(hNewRandVert))) {

						// Vertex newH = verticesLeftH.get(hNewRandVert);
						List<Vertex> adjPair = findAdjacency(vH);
						vH = adjPair.get(1);
						vG = adjPair.get(0);
						// ArrayList<Vertex> possGPair = new ArrayList<Vertex>();
						// possGPair = avaNeighbor(adjPair.get(1));

					}
				}
			}
		}


		//make matrix

		return checkSubgraph(adjMatrix);
	}
	
	// TODO
public boolean checkSubgraph(int[][] matrix) {
	for (int i = 0; i < H.adjMatrix.length; i++){
		for (int j = 0; j < H.adjMatrix.length; j++){
			if (H.adjMatrix[i][j] != matrix[i][j]){
				return false;
			}
		}
	}
		return true; 
}

public List<Vertex> findAdjacency(Vertex vertex){
	ArrayList<Vertex> neighbors = vertex.sortedneighbor;
	for (int i = 0; i < neighbors.size(); i++){
		for (int j = 0; j < pairs.size(); j++) {
			if (pairs.get(j).get(1) == neighbors.get(i)) {
				return pairs.get(i);
			}
		}
	}
	//should never reach this case, as it will always find one bc of the method below
	return pairs.get(0);
}

public boolean isAdjacent(Vertex vertex) {
	ArrayList<Vertex> neighbors = vertex.sortedneighbor;
	for (int i = 0; i < neighbors.size(); i++){
		for (int j = 0; j < pairs.size(); j++) {
			if (pairs.get(j).get(0) == neighbors.get(i) || pairs.get(j).get(1) == neighbors.get(i)) {
				return true;
			}
		}
	}
	return false; 
}


public ArrayList<Vertex> avaNeighbor(Vertex vertex){
	ArrayList<Vertex> neighbors = vertex.sortedneighbor;
	ArrayList<Vertex> available = new ArrayList<Vertex>();

	for (int i = 0; i < neighbors.size(); i++){
		Boolean isAvail = true;
		for (int j = 0; j < pairs.size(); j++){
			if (pairs.get(j).get(0) == neighbors.get(i) || pairs.get(j).get(1) == neighbors.get(i)) {
				isAvail = false;
			}
		}
		if (isAvail) {
			available.add(neighbors.get(i));
		}

	}
	return available;

}

}
