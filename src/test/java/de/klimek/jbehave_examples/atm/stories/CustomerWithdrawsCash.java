package de.klimek.jbehave_examples.atm.stories;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import de.klimek.jbehave_examples.LoggingStory;
import de.klimek.jbehave_examples.atm.Account;
import de.klimek.jbehave_examples.atm.Card;
import de.klimek.jbehave_examples.atm.Dispenser;
import de.klimek.jbehave_examples.atm.Money;

public class CustomerWithdrawsCash extends LoggingStory {
	
	private static final Money INITIAL_DISPENSER_CASH = new Money("10000");
	private static final Money REQUESTED_CASH = new Money("200");

	private Money creditBefore;
	private Money cashBefore;
	private Money cashAfter;
	private Money creditAfter;

	// Actors
	private Dispenser dispenser;
	private Card card;

	@Override
	public InjectableStepsFactory stepsFactory() {
		// This story contains all necessary steps
		return new InstanceStepsFactory(configuration(), this);
	}

	@BeforeScenario
	public void beforeScenarios() throws Exception {
		card = new Card(new Account());
		dispenser = new Dispenser();
	}

	@Given("the account is in credit")
	public void givenTheAccountIsInCredit() {
		Money credit = card.getAccount().getOverDraftLimit().add(new Money("500"));
		card.getAccount().setCredit(credit);
	}

	@Given("the account is overdrawn")
	public void givenTheAccountIsOverdrawn() {
		Money overDraft = card.getAccount().getOverDraftLimit().subtract(new Money("100"));
		card.getAccount().setCredit(overDraft);
	}

	@Given("the dispenser contains cash")
	public void givenTheDispenserContainsCash() {
		dispenser.setCash(INITIAL_DISPENSER_CASH);
	}

	@Given("the card is valid")
	public void givenTheCardIsValid() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, 2); // Expires in the future
		card.setExpirationDate(c.getTime());
	}

	@When("the customer requests cash")
	public void whenTheCustomerRequestsCash() {
		creditBefore = card.getAccount().getCredit();
		cashBefore = dispenser.getCash();

		dispenser.insert(card);
		dispenser.request(REQUESTED_CASH);

		creditAfter = card.getAccount().getCredit();
		cashAfter = dispenser.getCash();
	}

	@Then("ensure cash is not dispensed")
	@Alias("ensure no cash is dispensed")
	public void thenEnsureCashIsNotDispensed() {
		assertThat(cashBefore, is(equalTo(cashAfter)));
	}

	@Then("ensure the account is debited")
	public void thenEnsureTheAccountIsDebited() {
		assertThat(creditAfter, is(creditBefore.subtract(REQUESTED_CASH)));
	}

	@Then("ensure cash is dispensed")
	public void thenEnsureCashIsDispensed() {
		assertThat(cashAfter, is(cashBefore.subtract(REQUESTED_CASH)));
	}

	@Then("ensure the card is returned")
	public void thenEnsureTheCardIsReturned() {
		assertNull(dispenser.getCard());
	}

	@Then("ensure a rejection message is displayed")
	public void thenEnsureARejectionMessageIsDisplayed() {
		assertNotNull(dispenser.getErrorMessage());
	}
	
}