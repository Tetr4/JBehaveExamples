package de.klimek.jbehave_examples.atm;

public class Account {
    public static final Money DEFAULT_OVERDRAFT_LIMIT = new Money("-500");

    private Money credit = new Money("0");
    private Money overdraftLimit = DEFAULT_OVERDRAFT_LIMIT;

    public void setCredit(Money credit) {
        this.credit = credit;
    }

    public Money getCredit() {
        return credit;
    }

    public void setOverDraftLimit(Money overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public Money getOverDraftLimit() {
        return overdraftLimit;
    }
    
}
