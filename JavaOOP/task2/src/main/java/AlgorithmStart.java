import java.util.List;

public class AlgorithmStart extends Thread{
    private final List<Double> alpha;
    private final List<Double> beta;

    private final List<Double> x;
    int start;

    public AlgorithmStart(List<Double> alpha, List<Double> beta,
                        List<Double> x, int start){
        this.x = x;
        this.alpha = alpha;
        this.beta = beta;
        this.start = start;
    }
    public void run()
    {
        for (int i = start-1; i >= 0; i--) {
            x.set(i, alpha.get(i) * x.get(i + 1) + beta.get(i));
        }
    }
}
