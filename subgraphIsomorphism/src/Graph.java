
public class Graph {
	
	int[][] adjMatrix;
	Vertex[] vertices;
	int size;
	Vertex[] verticesSorted;
	
	public Graph(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
		this.size = adjMatrix.length;
		// TODO CONVERT MATRIX TO LIST OF VERTICES
	}
	
	// TODO
	public void makeVertices() {
		// for each row in given adjacency matrix:
			// this.vertices[i] = new Vertex object
			// for j in matrix[i].length
			//		if matrix[i][j] == 1
			//			vertex.neighbors += j
			//			vertex.degree += 1
			// one row is a vertex
	}
	
	// TODO
	public void sortByDegree() {
		// make a copy of this.vertices
		// sort copy by vertex degree (small->large) using vartex.greaterDegree()
		// once all vertices sorted:
		//	this.largest = largest
		// this.verticesSorted = sorted
	}
	
	/*
     public int biggestDegree(int[][] graph) {
        int length = graph.length;
        int highestDegree = 0;
        for (int i = 0; i < length; i++){
            int degreeCount = 0;
            for (int j = 0; j < length; j++){
                if (graph[i][j] == 1) {
                    degreeCount+= 1;
                }
            }
            if (degreeCount > highestDegree){
                highestDegree = degreeCount;
            }
        }

        return highestDegree;
     }
  */
     
     public Boolean isBiggerThan(Graph that){
        return this.size >= that.size;
     }

     // TODO
     public boolean canFit(Graph that) {
    	 /* call on G: G.canFit(H)
    	  	calculate whether this graph can fit that graph:
    	 		for each Vertex in that:
    	 			if This has a Vertex with degree >= That vertex:
    	 				remove This.vertex from what we can check
    	 				remove That.vertex from what we can check
    	 			else:
    	 				// there is a vertex in That that won't fit in This, so
    	 				return false
    	 */
    	 return false; // change
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
