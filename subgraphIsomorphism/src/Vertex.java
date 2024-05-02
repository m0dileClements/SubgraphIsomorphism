public class Vertex {
    int index;
    int[] neighbors;
    int degree;

    public Vertex(int index){
        this.index = index;
        this.degree = degree;
        this.neighbors = neighbors;
    }

    public Boolean greaterDegree(Vertex other){
        if (other.degree > this.degree) {
            return false;
        }
        return true;
    }



}
