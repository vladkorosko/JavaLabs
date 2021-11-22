import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public  static void main(String[] args) {
        try {
            List<Double> a = List.of(4.0, 5.0);
            List<Double> b = List.of(4.0, 5.0);
            List<Double> c = List.of(2.0, 1.0, 2.0);
            List<Double> f = List.of(18.0, 33.0, 30.0);

            AlgorithmThreeDiagonalMatrix alg = new AlgorithmThreeDiagonalMatrix(a, b, c, f);

            List<Double> result = alg.solveMatrix();
            System.out.println(result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
