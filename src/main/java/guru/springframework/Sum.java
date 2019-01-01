package guru.springframework;

public class Sum implements Expression {

    Expression augmend;
    Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String toCurrency) {
        int amount = this.augmend.reduce(bank, toCurrency).amount
                        + this.addmend.reduce(bank, toCurrency).amount;
        Money result = new Money(amount, toCurrency);
        return result;
    }


    @Override
    public Expression plus(Expression expression) {
        return null;
    }

}
