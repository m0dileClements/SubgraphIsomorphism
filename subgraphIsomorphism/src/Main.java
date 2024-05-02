
public class Main {
	
	public static void main(String[] args){
		// generates a random adjacency matrix given an input int for the number of vertices.
		int length1 = Integer.valueOf(args[0]);
		int length2 = Integer.valueOf(args[1]);
        	
		// randomly generate graph G and print
		int[][] graphG = randomMatrixGen(length1);
		Graph graphObj = new Graph(graphG);
		graphObj.printGraph();

		// randomly generate graph G and print
		int[][] graphH = randomMatrixGen(length2);
		Graph graph2 = new Graph(graphH);
		graph2.printGraph();
    }
	
	public static int[][] randomMatrixGen(int length){
		int[][] graphMatrix = new int[length][length];

		for (int i = 0; i< length; i++) {
			for (int j = i + 1; j < length && i + 1 < length; j++){
				if (i != j) {
					int random = (int)(Math.random()* (1 - 0 + 1));						if (random == 1) {
					graphMatrix[i][j] = 1;
					graphMatrix[j][i] = 1;
					} else {
						graphMatrix[i][j] = 0;
						graphMatrix[j][i] = 0;
					}
				}
			}
		}
		return graphMatrix;
	}
}
