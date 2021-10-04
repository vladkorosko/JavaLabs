import java.util.ArrayList;
import java.util.List;

public class Main {
    public  static void main(String[] args) {
        List<Double> a = new ArrayList<>();
        a.add(1.0);
        List<Double> b = new ArrayList<>();
        b.add(1.0);
        List<Double> c = new ArrayList<>();
        c.add(1.0);
        c.add(-1.0);
        List<Double> f = new ArrayList<>();
        f.add(-2.0);
        f.add(0.0);
        Algorithm al = new Algorithm(a,b,c,f);
        al.solve();
        System.out.println(al.getResult());
    }
}
