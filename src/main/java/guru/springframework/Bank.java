package guru.springframework;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private final Map<Pair, Integer> rates = new HashMap<>();

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }


    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    public int rate(String from, String to) {
        if (from.equals(to)){
            return 1;
        }
        return this.rates.get(new Pair(from, to));
    }
}
