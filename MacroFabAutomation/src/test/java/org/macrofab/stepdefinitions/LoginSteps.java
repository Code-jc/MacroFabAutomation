package org.macrofab.stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.macrofab.pages.DashboardPage;
import org.macrofab.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utils.WebDriverManager;

public class LoginSteps {

	WebDriver driver = WebDriverManager.getDriver();
	LoginPage loginPage;
	DashboardPage dashboardPage;

	private static final String BASE_URL = "https://demo.eco.dev.macrofab.com";
	private static final String BUSINESS_EMAIL = "john.smith5@macrofab.com";
	private static final String PASSWORD = "test01";

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));

	@Given("I have a MacroFab account and I am on the MacroFab website")
	public void i_have_a_macro_fab_account_and_i_am_on_the_macro_fab_website() {
		WebDriverManager.navigateToURL(BASE_URL + "/login");
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);

		loginPage.checkLoginPage();

	}

	@When("I enter the email and password and click the Sign In button")
	public void i_enter_the_email_and_password_and_click_the_sign_in_button() {

		loginPage.login(BUSINESS_EMAIL, PASSWORD);

	}

	@Then("I am directed to the Dashboard page")
	public void i_am_directed_to_the_pc_bs_page() {
		Assert.assertEquals("Dashboard Page Title", "Dashboard", dashboardPage.checkDashboardPage());

	}

}
