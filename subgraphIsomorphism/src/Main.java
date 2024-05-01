
public class Main {
		public static int[][] randomGraphGen(int length){
			int[][] graphMatrix = new int[length][length];

			for (int i = 0; i< length; i++) {
				for (int j = i + 1; j < length && i + 1 < length; j++){
					if (i != j) {
						int random = (int)(Math.random()* (1 - 0 + 1));
						if (random == 1) {
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
        public static void main(String[] args){
		Graph graphObj = new Graph();
		//generates a random adjacency matrix given an input int for the number of vertices.
        int length1 = Integer.parseInt(args[0]);
		int length2 = Integer.parseInt(args[1]);

		if (length1 < length2){
			System.out.println("This is not a subgraph, as Graph G is smaller than Graph F.");
		} else {

	    // randomly generate graph G and print
		int[][] graphG = randomGraphGen(length1);
		graphObj.printGraph(graphG);

		// randomly generate graph G and print
		int[][] graphF = randomGraphGen(length2);
		graphObj.printGraph(graphF);
	}
    }
}
