import java.util.ArrayList;



public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> hello = new ArrayList<>();
        hello.add(5);
        ArrayList<Integer> quality = new ArrayList<>();
        quality.add(7);

        hello = quality;
        System.out.println(hello);
    }
}
