package de.klimek.jbehave_examples.atm;

import java.util.Date;

public class Card {
    private Account account;
    private Date expirationDate = null;

    public Card(Account assignedAccount) {
        this.account = assignedAccount;
    }

    public Account getAccount() {
        return account;
    }
    
    public void setExpirationDate(Date date) {
        expirationDate = date;
    }

    public boolean isValid() {
        if(expirationDate == null) {
            // not valid until an expiration date has been set
            return false;
        }
        Date now = new Date();
        return expirationDate.after(now);
    }

}
