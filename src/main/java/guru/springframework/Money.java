package guru.springframework;

public class Money implements Expression {

    final int amount;
    private final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    String currency() {
        return this.currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount
                && this.currency==money.currency;
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier,  currency);
    }

    @Override
    public Expression plus (Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String currency) {
        int rate = bank.rate(this.currency, currency);
        int amount =  this.amount / rate;

        return new Money(amount, currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
