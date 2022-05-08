import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AlgorithmThreeDiagonalMatrixTest {
    @Test
    void test() {
        assertResult(
                List.of(2.0, 1.0),
                List.of(2.0, 1.0),
                List.of(3.0, 4.0, 5.0),
                List.of(9.0, 19.0, 28.0),
                List.of(1.0, 3.0, 5.0));
        assertResult(
                List.of(1.0, 1.0),
                List.of(1.0, 2.0),
                List.of(1.0, 3.0, 2.0),
                List.of(1.0, 1.0, 1.0),
                List.of(2.0, -1.0, 1.0));
        assertResult(
                List.of(4.0, 5.0),
                List.of(4.0, 5.0),
                List.of(2.0, 1.0, 2.0),
                List.of(18.0, 33.0, 30.0),
                List.of(1.0, 4.0, 5.0));
        assertResult(
                List.of(2.0, 4.0),
                List.of(2.0, 4.0),
                List.of(1.0, 2.0, 3.0),
                List.of(11.0, 34.0, 31.0),
                List.of(3.0, 4.0, 5.0));
    }

    private void assertResult(List<Double> a, List<Double> b, List<Double> c, List<Double> f, List<Double> expRes) {
        AlgorithmThreeDiagonalMatrix al = new AlgorithmThreeDiagonalMatrix(a, b, c, f);
        try {
            List<Double> result = al.solveMatrix();
            assertEquals(expRes.size(), result.size());
            for (int i = 0; i < expRes.size(); i++) {
                assertEquals(expRes.get(i), result.get(i), 0.001);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
