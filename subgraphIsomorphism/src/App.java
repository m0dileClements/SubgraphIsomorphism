public class App {
        public static void main(String[] args){
        int length = Integer.parseInt(args[0]);
		 System.out.println(length);
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

	        for (int m = 0; m < length; m ++) {
	        	System.out.print("[");
	        	for (int n = 0; n< length; n++) {
	        		System.out.print(graphMatrix[m][n] + ", ");
	        	}
	            System.out.println("]");
	        }
    }
}
