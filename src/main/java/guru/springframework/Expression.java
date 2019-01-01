package guru.springframework;

public interface Expression {
    Money reduce(Bank bank, String toCurrency);

    Expression plus(Expression expression);
}
