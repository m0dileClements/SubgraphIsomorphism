
import java.util.ArrayList;
public class Checknode
{
	Vertex vG;
	Vertex vH;
	ArrayList<Integer> trasub;
	ArrayList<Integer> trabig;
	boolean answer;
	@SuppressWarnings("unchecked")
	public Checknode(Vertex vG, Vertex vH,ArrayList<Integer> trasub,ArrayList<Integer> trabig)
	{
		this.vG = vG;
		this.vH = vH;
		ArrayList<Integer> copybig = (ArrayList<Integer>) trabig.clone();
		ArrayList<Integer> copysub = (ArrayList<Integer>) trasub.clone();;
		copysub.add(vH.index);
		copybig.add(vG.index);
		this.trabig = copybig;
		this.trasub = copysub;
	}
	
	/**
	 * @return the answer
	 */
	public boolean isAnswer()
	{
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(boolean answer)
	{
		this.answer = answer;
	}
	@Override
	public String toString()
	{
		return "Checknode [vG=" + vG + ", vH=" + vH + ", trasub=" + trasub + ", trabig=" + trabig + ", answer=" + answer
				+ "]";
	}
}


