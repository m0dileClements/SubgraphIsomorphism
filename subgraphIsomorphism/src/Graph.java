import java.util.ArrayList;
import java.util.Comparator;

public class Graph {
	
	int[][] adjMatrix;
	ArrayList<Vertex> vertices;
	int size;
	ArrayList<Vertex> verticesSorted;
	Vertex largest;
	Comparator<Vertex> comp;
	
	public Graph(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
		this.size = adjMatrix.length;
		this.vertices = makeVertices();
		this.comp = new vxComparator();
		this.verticesSorted = sortByDegree();
		this.largest = verticesSorted.get(0);
	}
	
	public ArrayList<Vertex> makeVertices() {
		ArrayList<Vertex> verts = new ArrayList<Vertex>();
		for (int i = 0; i < adjMatrix.length; i++) {
			int degree = 0;
			ArrayList<Integer> neighbor = new ArrayList<Integer> ();
			for (int j = i+1; j < adjMatrix.length; j++) {
				if(this.adjMatrix[i][j] == 1) {
					degree = degree+1;
					neighbor.add(j);
				}		
			}
			verts.add(new Vertex(this,i,degree,neighbor));
		}
		return verts;
	}

	public static class vxComparator implements Comparator<Vertex> {
		public int compare(Vertex c1, Vertex c2) {
			if (c1.degree > c2.degree ) {
				return 1;
			} else if (c1.degree < c2.degree) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Vertex> sortByDegree() {
		ArrayList<Vertex> vers = (ArrayList<Vertex>) this.vertices.clone();
		vers.sort(comp);
		return vers;
	}
     
	public Boolean isBiggerThan(Graph that) {
		return this.size >= that.size;
	}

    public boolean canFit(Graph that) { 
    	// that is the subgraph
    	if (this.largest.degree < that.largest.degree) {return false;}
   	 	for (int i = 0; i < that.size;i++ ) {
   	 		int big = this.verticesSorted.get(i).degree;
   	 		int sub = that.verticesSorted.get(i).degree;
   	 		if (big < sub) {return false;}
   	 		}
   	 	return true; // change
   	 }
     
     public void printGraph() {
        int length = adjMatrix.length;
        for (int m = 0; m < length; m ++) {
	        for (int n = 0; n < length; n++) {
                if (n == 0) {
                    System.out.print("[" + adjMatrix[m][n]);
                } else {
	        	    System.out.print(", " + adjMatrix[m][n]);
                }
	        }
	        System.out.println("]");
	    }
	}
     
}
