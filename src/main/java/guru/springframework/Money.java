package guru.springframework;

public abstract class Money {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public abstract Money times(int multiplier);

    protected String currency() {
        return this.currency;
    }

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount
                && this.getClass().equals(obj.getClass());
    }
}
