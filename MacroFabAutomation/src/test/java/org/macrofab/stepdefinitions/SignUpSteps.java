package org.macrofab.stepdefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.macrofab.pages.DashboardPage;
import org.macrofab.pages.LoginPage;
import org.macrofab.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import utils.WebDriverManager;

public class SignUpSteps {

	private WebDriver driver = WebDriverManager.getDriver();
	private SignUpPage signUpPage;
	private DashboardPage dashboardPage;

	private String baseUrl = "https://demo.eco.dev.macrofab.com";
	private String firstName = "John";
	private String lastName = "Smith";
	private String businessEmail = "john.smith20@macrofab.com";
	private String phoneNumber = "1234567898";
	private String password = "test01";

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));

	@Given("I don’t have a MacroFab account and I am on the MacroFab website")
	public void i_don_t_have_a_macro_fab_account_and_i_am_on_the_macro_fab_website() {
		WebDriverManager.navigateToURL(baseUrl + "/signup");
		signUpPage = new SignUpPage(driver);
		dashboardPage = new DashboardPage(driver);
	}

	@When("I sign up as a new user")
	public void i_sign_up_as_a_new_user() {
		signUpPage.createNewAccount(firstName, lastName, businessEmail, phoneNumber, password);

	}

	@Then("I am directed to the MacroFab dashboard page")
	public void i_am_directed_to_the_macro_fab_dashboard_page() {
		Assert.assertEquals("User is on the Dashboard page.", "Dashboard", dashboardPage.checkDashboardPage());

	}

	@Then("I verify that I have no PCB orders")
	public void i_verify_that_i_have_no_pcb_orders() {
		assertFalse("User does not have any PCB orders.", dashboardPage.hasPcbOrders(false));

	}

	@Then("I verify I have no outbound shipments")
	public void i_verify_i_have_no_outbound_shipments() {
		assertFalse("User does not have any Outbound Shipments.", dashboardPage.hasOutboundShipments(false));

	}

	@Then("I verify I have no inbound shipments")
	public void i_verify_i_have_no_inbound_shipments() {
		assertFalse("User does not have any Inbound Shipments.", dashboardPage.hasInboundShipments(false));
	}

	@Then("I verify I have no inventory")
	public void i_verify_i_have_no_inventory() {
		assertFalse("User does not have any Inventory.", dashboardPage.hasInventory(false));

	}

}
