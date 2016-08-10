package de.klimek.jbehave_examples.atm;

public class Dispenser {
    private Money cash = new Money("0");
    private Card card;
    private String errorMessage;

    public void setCash(Money cash) {
        this.cash = cash;
    }

    public Money getCash() {
        return cash;
    }
    
    public void insert(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private void ejectCard() {
        this.card = null;
    }
    
    private void clearError() {
        this.errorMessage = null;
    }

    private void showError(String message) {
        this.errorMessage = message;
    }

    public void request(Money requestedCash) {
        if (card == null) {
            showError("No card inserted");
            return;
        } 

        if (!card.isValid()) {
            showError("Card is not valid");
            ejectCard();
            return;
        } 
        
        Account account = card.getAccount();
        Money currentCredit = account.getCredit();
        Money limit = account.getOverDraftLimit();
        Money finalCredit = currentCredit.subtract(requestedCash);
        if (finalCredit.compareTo(limit) < 0) {
            showError("Not enough credit");
            ejectCard();
            return;
        }
        
        Money finalCash = cash.subtract(requestedCash);
        if (!finalCash.isPositive()) {
            showError("Not enough cash in dispenser");
            ejectCard();
            return;
        }
        
        // ready to dispense
        account.setCredit(finalCredit);
        cash = finalCash;
        clearError();
        ejectCard();
    }

}
