package guru.springframework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        Assertions.assertEquals(Money.dollar(10), five.times(2));
        Assertions.assertEquals(Money.dollar(15), five.times(3));

        Money fiveF = Money.franc(5);
        Assertions.assertEquals(Money.franc(10), fiveF.times(2));
        Assertions.assertEquals(Money.franc(15), fiveF.times(3));
    }

    @Test
    void testEquality() {
        Assertions.assertEquals(Money.dollar(5), Money.dollar(5));
        Assertions.assertNotEquals(Money.dollar(5), Money.dollar(8));
        Assertions.assertNotEquals(Money.franc(5), Money.franc(8));
        Assertions.assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    void testCurrency() {
        Assertions.assertEquals("USD", Money.dollar(5).currency());
        Assertions.assertEquals("CHF", Money.franc(5).currency());
    }

    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        Assertions.assertEquals(Money.dollar(10), reduced);
    }

    @Test
    void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        Assertions.assertEquals(five, sum.augmend);
        Assertions.assertEquals(five, sum.addmend);
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        Assertions.assertEquals(Money.dollar(7), result);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        Assertions.assertEquals(Money.dollar(1), result);
    }

    @Test
    void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        Assertions.assertEquals(Money.dollar(1), result);
    }

    @Test
    void testIdentityRate() {
        Bank bank = new Bank();
        Assertions.assertEquals(1, bank.rate("USD", "USD"));
        Assertions.assertEquals(1, bank.rate("CHF", "CHF"));
    }
}
