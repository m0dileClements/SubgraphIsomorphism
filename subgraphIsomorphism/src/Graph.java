class Graph {
     public void biggerGraph(){

     }
     public void biggestDegree( ){

     }
     public void printGraph(int[][] graph) {
        int length = graph.length;
        for (int m = 0; m < length; m ++) {
	        for (int n = 0; n < length; n++) {
                if (n == 0) {
                    System.out.print("[" + graph[m][n]);
                } else {
	        	    System.out.print(", " + graph[m][n]);
                }
	        }
	        System.out.println("]");
	    }
	}
     
}
