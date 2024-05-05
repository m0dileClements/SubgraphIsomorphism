
import java.util.ArrayList;
public class Optimal {
	Graph G;
	Graph H;
	//H is subgraph
	
	public Optimal(Graph G, Graph H) {
		this.G = G;
		this.H = H;
	}
	
	// TODO
	public Checknode isSubgraph() {
		if (!G.canFit(H))
		{return null;}
		ArrayList<Vertex> startpoints = new ArrayList<Vertex>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		startpoints = avaneighbor(G.verticesSorted,H.verticesSorted.get(0),temp);
	/*	for(int i = 0; i < H.size ; i++)
		{
			if(G.verticesSorted.get(i).degree > H.highest)
			{
				startpoints.add(G.verticesSorted.get(i));
			}
		}
		while(startpoints.size()!=0)
		{
			if(!startpoints.get(0).isPromising(H.verticesSorted.get(0)))
		{
			startpoints.remove(0);
			}
		}*/
		boolean endchecking = false;
		if(startpoints == null)
		{
			return null;
		}
		
		while(!startpoints.isEmpty()&&endchecking == false)
		{
			
			ArrayList<Integer> trasub = new ArrayList<Integer>();
			
			ArrayList<Integer> trabig = new ArrayList<Integer>();
			Checknode check = new Checknode(startpoints.get(0),H.verticesSorted.get(0),trasub,trabig);
			Checknode result = isSubgraph(check);
			if (result.answer == true)
			{
				while(check.trasub.size() != this.H.vertices.size())
				{
					//if the matched graph is not a complete subgraph
					ArrayList<Vertex> unmatchedsub = new ArrayList<Vertex> ();
					for (Vertex i : this.H.vertices)
					{
						if(!check.trasub.contains(i.index))
						{
							unmatchedsub.add(i);
						}
					}
					ArrayList<Vertex> reststartpoints = avaneighbor(G.verticesSorted,unmatchedsub.get(0),check.trabig);
					Checknode next = new Checknode(reststartpoints.get(0),unmatchedsub.get(0),check.trasub,check.trabig);
					Checknode nex = isSubgraph(next);
					if (nex.answer == false)
					{
						
						return null;
					}
					else
					{
						check = nex;
						
					}
					
				}
				endchecking = true;
				//System.out.println(check.trabig);
				//System.out.println(check.trasub);
				return check;
				
				
			}
			else
			{
				startpoints.remove(0);
			}
		}
		return null;
		
		
		
	}
	
	// TODO
	private Checknode isSubgraph(Checknode check) {
		//update travel list
		if (check.vH.sortedneighbor == null) {
			check.setAnswer(true);
			return check;}
		ArrayList<Vertex> uncheckedsubnei = new ArrayList<Vertex>();
		for (Vertex i : check.vH.sortedneighbor)
		{
			if(!check.trasub.contains(i.index))
			{
				uncheckedsubnei.add(i);
			}
				
		}
		while (uncheckedsubnei.size() != 0)
		{
			ArrayList<Vertex> avaneighbor = avaneighbor(check.vG.sortedneighbor,uncheckedsubnei.get(0),check.trabig);
			if (avaneighbor == null) {
				check.setAnswer(false);
				return check;}
			boolean flag = false;
			while (flag == false) {
				
				Checknode smallc = new Checknode(avaneighbor.get(0),uncheckedsubnei.get(0),check.trasub,check.trabig);
				flag = isSubgraph(smallc).answer;
				if (flag == true)
				{
					//the two vertex is matched, unpate all the things
					check.trabig.add(avaneighbor.get(0).index);
					check.trasub.add(uncheckedsubnei.get(0).index);
					uncheckedsubnei.remove(0);
					
					
				}
				else
				{
					avaneighbor.remove(0);
				}
			}
			
		
		}
		check.setAnswer(true);
		return check;
	}
	
	//@SuppressWarnings("unchecked")
	public ArrayList<Vertex> avaneighbor(ArrayList<Vertex> bignei, Vertex matchsub,ArrayList<Integer> traveled)
	{
		ArrayList<Vertex> avaneighbor = new ArrayList<Vertex>();		
		for (Vertex i : bignei)
		{
			if (i.degree >= matchsub.degree && !traveled.contains(i.index))
			{
				//System.out.println(i.sortedneighbor);
				//degree should be bigger and should not be travelled
				if (i.isPromising(matchsub))
				{
					avaneighbor.add(i);
				}
			}
		
		}
		
		return avaneighbor;
		
		
	}
	public boolean finalcheck()
	{
		Checknode f = isSubgraph();
		if (f == null)
		{
			return false;
		}
		else
		{
			ArrayList<Integer> check = new ArrayList<Integer>();
			for (int i = 0; i < f.trasub.size(); i++)
			{
				//System.out.println(i);
				//System.out.println(f.trasub.size());
				//System.out.println(f.trasub);
				//System.out.println(f.trabig);
				int index = f.trasub.indexOf(i);
				check.add(f.trabig.get(index));
			}
			int[][] adjMatrix = this.G.adjMatrix;
			int[][] travelmap = new int [check.size()][check.size()];
			for (int j = 0;j<check.size();j++)
			{
				for (int k = 0; k< check.size();k++)
				{
					if(j == k)
					{
						travelmap [j][k] = 0;
					}
					else {
						int first = check.get(j);
						int second = check.get(k);
						travelmap[j][k] = adjMatrix[first][second];
						travelmap[k][j] = adjMatrix[first][second];
						
					}
				}
				
			}
	        int length = travelmap.length;
	        for (int m = 0; m < length; m ++) {
		        for (int n = 0; n < length; n++) {
	                if (n == 0) {
	                    //System.out.print("[" + travelmap[m][n]);
	                } else {
		        	   // System.out.print(", " + travelmap[m][n]);
	                }
		        }
		      //  System.out.println("]");
		    }
			if(travelmap == this.H.finaladjMatrix)
			{
				
				return true;
			}
	        for (int m = 0; m < length; m ++) {
		        for (int n = 0; n < length; n++) {
		        	if(travelmap[m][n]< this.H.finaladjMatrix[m][n])
		        	{
		        		return false;
		        	}
		        	
		        }
		    }
	        return true;
			
		}
	}
	
	// TODO
	
	/*public boolean isComplete(Vertex[][] map) {
		// return (map == H.matrix)
		return false; // change
	}
*/
}
