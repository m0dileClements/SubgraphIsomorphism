public class Vertex {
    int index = 0;
    Integer[] neighbors = {};
    int degree = 0;

    public Vertex(int index, int degree, int[] neighbors){
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
