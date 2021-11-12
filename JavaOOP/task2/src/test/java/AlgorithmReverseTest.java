import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AlgorithmReverseTest {
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
        List<Double> result = new ArrayList<>(Collections.nCopies(f.size(), 0.0));
        Algorithm al = new Algorithm(a, b, c, f, result, result.size() / 2, result.size());
        AlgorithmReverse al2 = new AlgorithmReverse(a, b, c, f, result, 0, result.size() / 2);

        al.start();
        al2.start();

        try {
            al.join();
            al2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(expRes.size(), result.size());
        for (int i = 0; i < expRes.size(); i++) {
            assertEquals(expRes.get(i), result.get(i), 0.001);
        }
    }
}