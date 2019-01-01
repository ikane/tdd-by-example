package guru.springframework;

public class Sum implements Expression {

    final Expression augmend;
    final Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String toCurrency) {
        int amount = this.augmend.reduce(bank, toCurrency).amount
                        + this.addmend.reduce(bank, toCurrency).amount;
        return new Money(amount, toCurrency);
    }


    @Override
    public Expression plus(Expression expression) {
        return new Sum(this, expression);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(this.augmend.times(multiplier), this.addmend.times(multiplier));
    }
}
