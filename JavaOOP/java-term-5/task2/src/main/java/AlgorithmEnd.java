import java.util.List;

public class AlgorithmEnd extends Thread{
    private final List<Double> alpha;
    private final List<Double> beta;

    private final List<Double> x;
    int start;

    public AlgorithmEnd(List<Double> alpha, List<Double> beta,
                        List<Double> x, int start){
        this.x = x;
        this.alpha = alpha;
        this.beta = beta;
        this.start = start;
    }

    public void run()
    {
        for (int i = start + 1; i < x.size(); i++) {
            x.set(i, (x.get(i - 1) * alpha.get(i - 1 - start)) + beta.get(i - 1 - start));
        }
    }
}
