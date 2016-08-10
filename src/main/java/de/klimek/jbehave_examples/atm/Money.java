package de.klimek.jbehave_examples.atm;

import java.math.BigDecimal;

public class Money implements Comparable<Money> {
    private final BigDecimal value;

    public Money(String money) {
        value = new BigDecimal(money);
    }

    public Money(BigDecimal money) {
        value = money;
    }

    public Money subtract(Money money) {
        return new Money(value.subtract(money.value));
    }

    public Money add(Money money) {
        return new Money(value.add(money.value));
    }

    public boolean isPositive() {
        return value.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public int compareTo(Money other) {
        return value.compareTo(other.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Money))
            return false;
        Money otherMoney = (Money) obj;
        return value.equals(otherMoney.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
    
    @Override
    public String toString() {
        return value.toString();
    }

}
