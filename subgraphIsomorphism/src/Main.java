import java.util.Random;
public class Main {
	
	public static void main(String[] args) {
		
		// RANDOMLY GENERATE GRAPHS:
		int[][] graphG = randomMatrixGen(Integer.valueOf(args[0])); // make graph G
		Graph G = new Graph(graphG);
		G.printGraph();																	// DEBUG
		int[][] graphH = randomMatrixGen(Integer.valueOf(args[1])); // make graph H
		Graph H = new Graph(graphH);
		H.printGraph();																	// DEBUG
		
		// DEBUG VERSION:
//		int[][] graphG = {{0, 1, 0, 0, 1},{1, 0, 0, 1, 0},{0, 0, 0, 1, 1},{0, 1, 1, 0, 0},{1, 0, 1, 0, 0}};
//		int[][] graphH = {{0, 1, 1},{1, 0, 0},{1, 0, 0}};
//		Graph G = new Graph(graphG);
//		Graph H = new Graph(graphH);
		
		// We currently have it set so that G is always larger than H.
		// TODO calculate which graph is larger & reconfigure code based on that
		
		long startTime = System.nanoTime();
		
		System.out.println("Running initial compatibility tests...\n");
		
		if (G.highest < H.highest) {
			// NOT A SUBGRAPH!
			// TODO return false somehow
			System.out.println("H is not a subgraph of G (largest degree problem).");
		}
		if (G.canFit(H)) {
			// TODO run algs here!!!!
			//	Run Optimal alg once -- print results + runtime
			//	Run Approx alg however many times -- print results + runtime
		} else {
			// NOT A SUBGRAPH!
			// TODO return false somehow
			System.out.println("H is not a subgraph of G (can't fit).");
		}
		
		long endTime = System.nanoTime();
		long runTime = endTime - startTime;
		
		// TODO print results so we can view & analyze them
  }
	
	public static int[][] randomMatrixGen(int length){
		int[][] matrix = new int[length][length];
		
		int i;
		int j;
		int random;
		
		int [] verts = new int[length]; // tracks degree of each vertex
		
		// Initialize vertices (no edges yet)
		for (i = 0; i < length; i++) {
			for (j = i + 1; j < length && i + 1 < length; j++){
				matrix[i][j] = 0;
				verts[i] = 0;
		}}
		Random rand = new Random();
		int degree;
		int neighbor;
		boolean assigned = false;
		
		// For each vertex:
		for (i = 0; i < length; i++) {
			degree = rand.nextInt(length-2) + 1;	// Randomize degree for this vertex
//			System.out.print("\t"+degree);
//			System.out.print(" - "+verts[i]);
			degree -= verts[i];					// How many new edges to make?
			if (degree < 0) {
				degree = 0;	// prevent degree from being negative lol
			}
//			System.out.print(" = "+degree+"\n");
			for (j = 0; j < degree; j++) {		// For each new neighbor of this vertex:
				while (assigned == false) {		// While this neighbor hasn't been assigned:
					neighbor = rand.nextInt(length-1); // randomly decide which one to connect it to
//					System.out.println("\t> Neighbor: "+neighbor);
					if ((matrix[i][neighbor] == 0) && neighbor != i) {
						matrix[i][neighbor] = 1;	// place edge in matrix
						matrix[neighbor][i] = 1;	// mirrors assignment for neighbor
						verts[i] += 1;			// add to vertex's total degree
						verts[neighbor] += 1;	// ^ same for neighbor
						assigned = true;
					}
				}
				assigned = false;
			}
		}
		return matrix;
	}
}
