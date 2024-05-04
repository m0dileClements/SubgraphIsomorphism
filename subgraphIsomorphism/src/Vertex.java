import java.util.ArrayList;
import java.util.Comparator;

public class Vertex {
    int index;
    ArrayList<Integer> neighborsind;
    ArrayList<Vertex> sortedneighbor;
    int degree;
    Graph g;
    Comparator<Vertex> comp;

    public Vertex(Graph g,int index,int degree, ArrayList<Integer> neighbors ){
        this.g = g;
    	this.index = index;
        this.degree = degree;
        this.neighborsind = neighbors;
        this.comp = new vxComparator();
        this.sortedneighbor = sortVertices();
    }
	   public static class vxComparator implements Comparator<Vertex> {
	      public int compare(Vertex c1, Vertex c2) {
	    	  if (c1.degree > c2.degree) {
	    		  return 1;
	    	  } else if (c1.degree < c2.degree) {
	    		  return -1;
	    	  } else {
	    		  return 0;
	    	}
	      }
	   }

    public Boolean greaterDegree(Vertex other){
        if (other.degree > this.degree) {
            return false;
        }
        return true;
    }
    
	public ArrayList<Vertex> sortVertices() {
		ArrayList<Vertex> vers = new ArrayList<Vertex>();
		for (int i = 0; i < this.neighborsind.size(); i++){
			Vertex a = this.g.vertices.get(i);
			vers.add(a);
		}
		vers.sort(comp);
		
		return vers;
	}

	public boolean isPromising(Vertex that) {
		if(that.degree > this.degree) {return false;}
   	 		for (int i = 0; i < that.neighborsind.size();i++) {
   	 			int big = this.sortedneighbor.get(i).degree;
   	 			int sub = that.sortedneighbor.get(i).degree;
   	 			if (big < sub) {
   	 				return false;
   	 			}
   	 		}
   	 	return true;
	}
}