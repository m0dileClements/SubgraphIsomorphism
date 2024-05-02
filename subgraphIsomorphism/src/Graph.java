
public class Graph {
     public int biggestDegree(int[][] graph){
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
    //  public Boolean isBiggerThan(Graph that){
    //     return this.size >= that.size
    //  }

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
