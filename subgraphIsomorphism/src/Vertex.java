
import java.util.ArrayList;
import java.util.Collections;
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
       //this.sortedneighbor = sortVertices();
   }
	   /**
	 * @return the sortedneighbor
	 */
	public ArrayList<Vertex> getSortedneighbor()
	{
		return sortedneighbor;
	}
	/**
	 * @param sortedneighbor the sortedneighbor to set
	 */
	public void setSortedneighbor(ArrayList<Vertex> sortedneighbor)
	{
		this.sortedneighbor = sortedneighbor;
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
   public Boolean greaterDegree(Vertex other){
       if (other.degree > this.degree) {
           return false;
       }
       return true;
   }
  
	public ArrayList<Vertex> sortVertices() {
		
		ArrayList<Vertex> vers = new ArrayList<Vertex>();
		for (int i = 0; i < this.neighborsind.size(); i++)
		{
			//get the first index
			Vertex a = this.g.completevertices.get(this.neighborsind.get(i));		
			vers.add(a);
			
		}
		vers.sort(comp);
		
		return vers;
	}
	@SuppressWarnings("unchecked")
	public boolean isPromising(Vertex that)
	{
		//need reverse
		if(that.degree > this.degree) {return false;}
  	 /*	for (int i = 0; i < that.neighborsind.size();i++ )
  	 	{
  	 		
  	 		int big = revercopybig.get(i).degree;
  	 		int sub = revercopysub.get(i).degree;
  	 		if (big < sub)
  	 		{
  	 			return false;
  	 		}	
  	 	}
  	 	return true;*/
		if(that.sortedneighbor == null) {return true;}
		if(this.sortedneighbor == null && that.sortedneighbor != null) {return false;}
		else {
			ArrayList<Vertex> revercopybig = new ArrayList<Vertex>();
			revercopybig = (ArrayList<Vertex>) this.sortedneighbor.clone();
			Collections.reverse(revercopybig);
			ArrayList<Vertex> revercopysub = new ArrayList<Vertex>();
			revercopysub = (ArrayList<Vertex>) that.sortedneighbor.clone();
			Collections.reverse(revercopysub);	
			for(int i = 0; i < this.neighborsind.size();i++)
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
            }
        }
        }
        @Override
        public String toString()
        {
            return "Vertex [index=" + index + ", neighborsind=" + neighborsind +
                     ", degree=" + degree;
        }
    }
    