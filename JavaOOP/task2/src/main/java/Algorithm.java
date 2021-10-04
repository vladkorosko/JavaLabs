import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    private List<Double> _a = new ArrayList<>();
    private List<Double> _b = new ArrayList<>();
    private List<Double> _c = new ArrayList<>();
    private List<Double> _f = new ArrayList<>();

    private List<Double> _alpha = new ArrayList<>();
    private List<Double> _beta = new ArrayList<>();
    private List<Double> _z = new ArrayList<>();

    private List<Double> _x = new ArrayList<>();

    public Algorithm(List<Double> a, List<Double> b, List<Double> c, List<Double> f){
        _a = a;
        _b = b;
        _c = c;
        _f = f;
        for (int i = 0; i < _f.size(); i++) {
            _x.add(0.0);
        }
    }

    private void calculateCoefficients() {
        _alpha.add(_b.get(0) / _c.get(0) * (-1));
        _beta.add(_f.get(0) / _c.get(0));
        for (int i = 1; i < _b.size(); i++){
            _z.add(_c.get(i) + _alpha.get(_alpha.size() - 1) * _a.get(i - 1));
            _alpha.add((-1) * _b.get(i) / _z.get(_z.size() - 1));
            Double temp = _f.get(i) - _a.get(i - 1) * _beta.get(_beta.size() - 1);
            _beta.add(temp / _z.get(_z.size() - 1));
        }
    }

    public void solve()
    {
        calculateCoefficients();
        Double temp1 = (_f.get(_f.size() - 1) - _a.get(_a.size() - 1) * _beta.get(_beta.size() - 1));
        Double temp2 = _c.get(_c.size() - 1) + _alpha.get(_alpha.size() - 1) * _a.get(_a.size() - 1);
        _x.set(_x.size() - 1, temp1/temp2);
        for (int i = _x.size()-2; i >= 0; i--) {
            _x.set(i, _alpha.get(i) * _x.get(i + 1) + _beta.get(i));
        }
    }

    public List<Double> getResult(){
        return _x;
    }
}
