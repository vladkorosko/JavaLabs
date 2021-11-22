import java.util.Collections;
import java.util.List;

public class CalculateCoefficientsEnd extends Thread{
    private final List<Double> a;
    private final List<Double> b;
    private final List<Double> c;
    private final List<Double> f;
    private final List<Double> alpha;
    private final List<Double> beta;

    CalculateCoefficientsEnd(List<Double> a, List<Double> b, List<Double> c,
                               List<Double> f, List<Double> alpha, List<Double> beta){
        this.a = a;
        this.b = b;
        this.c = c;
        this.f = f;
        this.alpha = alpha;
        this.beta = beta;
    }

    public void run(){
        alpha.add(a.get(a.size() - 1) * (-1) / c.get(c.size() - 1));
        beta.add(f.get(f.size() - 1) / c.get(c.size() - 1));
        for (int i = b.size() - 1; i > c.size() / 2; i--){
            beta.add((f.get(i) - b.get(i) * beta.get(beta.size()-1)) / (b.get(i) * alpha.get(alpha.size()-1) + c.get(i)));
            alpha.add((-1) * a.get(i-1) / (b.get(i) * alpha.get(alpha.size()-1) + c.get(i)));

        }

        Collections.reverse(alpha);
        Collections.reverse(beta);
    }
}
