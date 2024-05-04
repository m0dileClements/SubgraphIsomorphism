import java.util.ArrayList;

public class Checknode {
    Vertex vG;
	Vertex vH;
	ArrayList<Integer> trasub;
	ArrayList<Integer> trabig;
	public Checknode(Vertex vG, Vertex vH,ArrayList<Integer> trasub,ArrayList<Integer> trabig) 
	{
		this.vG = vG;
		this.vH = vH;
        trasub.add(vH.index);
        trabig.add(vH.index);
		this.trabig = trabig;
        this.trasub = trasub;
	}

}
