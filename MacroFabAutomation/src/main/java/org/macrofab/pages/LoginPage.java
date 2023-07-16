package org.macrofab.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Locators
	public static final By SIGNIN_HEADER_TEXT = By.xpath("//h4[text()='Sign in to MacroFab']");
	public static final By BUSINESS_EMAIL_INPUT = By.id("user");
	public static final By PASSWORD_INPUT = By.id("pass");
	public static final By SIGN_IN_BUTTON = By.id("submit");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(70));
	}

	// Page Methods
	public String checkLoginPage() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SIGNIN_HEADER_TEXT));
		String pageTitle = driver.getTitle();

		return pageTitle;

	}

	public void enterBusinessEmail(String email) {
		WebElement emailInput = driver.findElement(BUSINESS_EMAIL_INPUT);
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		WebElement passwordInput = driver.findElement(PASSWORD_INPUT);
		passwordInput.sendKeys(password);
	}

	public void clickSignInButton() {
		WebElement signInButton = driver.findElement(SIGN_IN_BUTTON);
		signInButton.click();
	}

	public void login(String email, String password) {
		enterBusinessEmail(email);
		enterPassword(password);
		clickSignInButton();
	}

}
