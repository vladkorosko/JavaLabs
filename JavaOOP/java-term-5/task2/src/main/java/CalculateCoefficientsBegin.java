import java.util.List;

public class CalculateCoefficientsBegin extends Thread{
    private final List<Double> a;
    private final List<Double> b;
    private final List<Double> c;
    private final List<Double> f;
    private final List<Double> alpha;
    private final List<Double> beta;

    CalculateCoefficientsBegin(List<Double> a, List<Double> b, List<Double> c,
                               List<Double> f, List<Double> alpha, List<Double> beta){
        this.a = a;
        this.b = b;
        this.c = c;
        this.f = f;
        this.alpha = alpha;
        this.beta = beta;
    }

    public void run(){
        alpha.add(b.get(0) / c.get(0) * (-1));
        beta.add(f.get(0) / c.get(0));
        for (int i = 1; i < c.size() / 2; i++){
            double z = (c.get(i) + alpha.get(alpha.size() - 1) * a.get(i - 1));
            alpha.add((-1) * b.get(i) / z);
            double temp = f.get(i) - a.get(i - 1) * beta.get(beta.size() - 1);
            beta.add(temp / z);
        }
    }
}
