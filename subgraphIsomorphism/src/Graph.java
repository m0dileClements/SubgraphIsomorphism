
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Graph {
	
	int[][] adjMatrix;
	int[][] finaladjMatrix;
	ArrayList<Vertex> vertices;
	int size;
	ArrayList<Vertex> verticesSorted;
	Comparator<Vertex> comp;
	int highest;
	//private Comparator<? super Vertex> vxComparator;
	ArrayList<Vertex> completevertices;
	
	public Graph(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
		this.size = adjMatrix.length;
		this.completevertices = new ArrayList<Vertex>();
		this.vertices = makeVertices();
		this.comp = new vxComparator();
		this.verticesSorted = sortByDegree();
		this.highest = this.verticesSorted.get(0).degree;
		this.finaladjMatrix = finalmatrix();
		for(Vertex i : this.vertices)
		{
			i.setSortedneighbor(i.sortVertices());
		}
		
	}
	
	public int[][] finalmatrix()
	{
		int length = this.vertices.size();
		int[][] graphMatrix = new int[length][length];
		if( length == this.adjMatrix.length)
		{
			graphMatrix = this.adjMatrix;
			
		}
		else
		{
			for(int i = 0; i < this.vertices.size(); i++)
			{
				for(int j = i;  j< this.vertices.size(); j++)
				{
					if (i == j)
					{
						graphMatrix [i][j] = 0;
					}
					else
					{
						int ver1 = this.vertices.get(i).index;
						int ver2 = this.vertices.get(j).index;
						graphMatrix [i][j] =  this.adjMatrix[ver1][ver2];
						graphMatrix [j][i] =  this.adjMatrix[ver1][ver2];
					}
				}
			}
			
		}
		
		
		
		
		return graphMatrix;
	}
	
	public ArrayList<Vertex> makeVertices() {
		
		ArrayList<Vertex> vers = new ArrayList<Vertex>();
		for (int i = 0; i < adjMatrix.length; i++)
		{
			int degree = 0;
			ArrayList<Integer> neighbor = new ArrayList<Integer> ();
			for (int j = 0; j < adjMatrix.length; j++)
			{
				if(this.adjMatrix[i][j] == 1)
				{
					degree = degree+1;
					neighbor.add(j);
				}				
				
			}
			Vertex add = new Vertex(this,i,degree,neighbor);
			if (degree != 0) {				
				vers.add(add);}	
			this.completevertices.add(add);
			
		}
		return vers;
	}
	   public static class vxComparator implements Comparator<Vertex>
	   {
	      public int compare(Vertex c1, Vertex c2)
	      {
	    	  if (c1.degree < c2.degree )
	    	  {
	    		  return 1;
	    	  }
	    	  else if (c1.degree > c2.degree)
	    	  {
	    		  return -1;
	    	  }
	    	  else
	    	  {
	    	  return 0;
	    	  }
	      }
	   }
	// TODO
	@SuppressWarnings("unchecked")
	public ArrayList<Vertex> sortByDegree() {
		ArrayList<Vertex> vers = (ArrayList<Vertex>) this.vertices.clone();
		vers.sort(comp);
		return vers;
	}
	
   
    public Boolean isBiggerThan(Graph that){
       return this.size >= that.size;
    }
    // TODO
    @SuppressWarnings("unchecked")
	public boolean canFit(Graph that) {
   	 //that is the subgraph
   	 if (this.highest < that.highest) {return false;}
		ArrayList<Vertex> revercopybig = new ArrayList<Vertex>();
		revercopybig = (ArrayList<Vertex>) this.verticesSorted.clone();
		Collections.reverse(revercopybig);
		ArrayList<Vertex> revercopysub = new ArrayList<Vertex>();
		revercopysub = (ArrayList<Vertex>) that.verticesSorted.clone(); 		
		Collections.reverse(revercopysub);
		//System.out.println(revercopysub.size()+"check reverse size");
   /*	 for (int i = 0; i < that.vertices.size();i++ )
   	 {
   	//	System.out.println(i);
   		int big = revercopybig.get(i).degree;
   		int sub = revercopysub.get(i).degree;
   		if (big < sub) {return false;}
   	 }*/
   	
   	 for(int i = 0; i < this.vertices.size();i++)
   	{
   		int big = revercopybig.get(i).degree;
   		if (!revercopysub.isEmpty())
   		{
   			
   			int sub = revercopysub.get(0).degree;
   			if (big >= sub)
   			{
   				revercopysub.remove(0);
   			}
   		}
   		
			
   	}
   	 if(!revercopysub.isEmpty())
   	 {
   		 //still have some unmatched points in subgraph
   		 return false;
   	 }
   	
   	 else
   	 {
   		 return true;
   	} // change
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
