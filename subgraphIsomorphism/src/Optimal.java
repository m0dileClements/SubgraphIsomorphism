import java.util.ArrayList;

public class Optimal {

	Graph G;
	Graph H; // H is subgraph

	public Optimal(Graph G, Graph H) {
		this.G = G;
		this.H = H;
	}
	
	// TODO
	public boolean isSubgraph() {
		if (!G.canFit(H)) {return false;}
		ArrayList<Vertex> startpoints = new ArrayList<Vertex>();
		for(int i = 0; i < H.size ; i++) {
			if(G.verticesSorted.get(i).degree > H.largest.degree) {
				startpoints.add(G.verticesSorted.get(i));
			}
		}
		if(!startpoints.get(0).isPromising(H.verticesSorted.get(0))) {
			startpoints.remove(0);
		}
		
		while(!startpoints.isEmpty()) {
			
			ArrayList<Integer> trasub = new ArrayList<Integer>();
			
			ArrayList<Integer> trabig = new ArrayList<Integer>();
			trasub.add(H.verticesSorted.get(0).index);
			trabig.add(startpoints.get(0).index);

			Checknode check = new Checknode(startpoints.get(0),H.verticesSorted.get(0),trasub,trabig);
			if (isSubgraph(check) == true) {
				return true;
			} else {
				startpoints.remove(0);
			}
		}
		return false;
	}
	
	// TODO
	private boolean isSubgraph(Checknode check) {
		// update travel list
		if (check.vH.sortedneighbor == null) {return true;}
		ArrayList<Vertex> uncheckedsubnei = new ArrayList<Vertex>();
		for (Vertex i : check.vH.sortedneighbor) {
			if(!check.trasub.contains(i.index)) {
				uncheckedsubnei.add(i);
			}	
		}
		ArrayList<Vertex> avaneighbor = new ArrayList<Vertex>();
		return false;
	}
	
	public ArrayList<Vertex> avaneighbor(ArrayList<Vertex> bignei, Vertex matchsub){
		ArrayList<Vertex> avaneighbor = new ArrayList<Vertex>();
		for ()
		
		return avaneighbor;
	}
	
	public boolean checkonebranch() {
		return false;
	}
	
	// TODO
	/*public boolean isComplete(Vertex[][] map) {
		// return (map == H.matrix)
		return false; // change
	}
*/
}