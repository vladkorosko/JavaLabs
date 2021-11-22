import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgorithmThreeDiagonalMatrix {
    List<Double> a;
    List<Double> b;
    List<Double> c;
    List<Double> f;

    AlgorithmThreeDiagonalMatrix(List<Double> a, List<Double> b, List<Double> c, List<Double> f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.f = f;
    }


    List<Double> solveMatrix() throws InterruptedException {
        List<Double> alphaStart = new ArrayList<>();
        List<Double> betaStart = new ArrayList<>();
        List<Double> alphaEnd = new ArrayList<>();
        List<Double> betaEnd = new ArrayList<>();

        CalculateCoefficientsBegin start = new CalculateCoefficientsBegin(a,b,c,f, alphaStart, betaStart);
        CalculateCoefficientsEnd end = new CalculateCoefficientsEnd(a,b,c,f, alphaEnd, betaEnd);

        start.start();
        end.start();

        start.join();
        end.join();

        System.out.println();
        List<Double> result = new ArrayList<>(Collections.nCopies(f.size(), 0.0));
        Double x = (f.get(f.size() / 2)
                - a.get((a.size() - 1) / 2) * betaStart.get(betaStart.size() - 1)
                - b.get((b.size() + 1) / 2) * betaEnd.get(0))
                / (c.get(c.size() / 2)
                + a.get((a.size() - 1) / 2) * alphaStart.get(alphaStart.size() - 1)
                + b.get((b.size() + 1) / 2) * alphaEnd.get(0));


        int middle = f.size() / 2;
        result.set(middle, x);
        AlgorithmStart as = new AlgorithmStart(alphaStart, betaStart, result, middle);
        AlgorithmEnd ae = new AlgorithmEnd(alphaEnd, betaEnd, result, middle);

        as.start();
        ae.start();
        ae.join();
        as.join();

        return result;
    }
}
