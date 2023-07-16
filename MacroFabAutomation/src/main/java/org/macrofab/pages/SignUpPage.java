package org.macrofab.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Locators
	public static final By CREATE_AN_ACCOUNT_HEADER = By.xpath("//h1[contains(text(),'Create an Account')]");
	public static final By FIRST_NAME_INPUT = By.id("first_name");
	public static final By LAST_NAME_INPUT = By.id("last_name");
	public static final By BUSINESS_EMAIL_INPUT = By.id("user");
	public static final By PHONE_NUMBER_INPUT = By.id("phone");
	public static final By PASSWORD_INPUT = By.id("pass");
	public static final By CREATE_ACCOUNT_BUTTON = By.id("createAccountSubmit");

	// Constructor
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(70));
	}

	// Page Methods
	public String checkSignUpPage() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CREATE_AN_ACCOUNT_HEADER));
		String pageTitle = driver.getTitle();

		return pageTitle;
	}

	public void enterfirstName(String firstName) {
		WebElement firstNameInput = driver.findElement(FIRST_NAME_INPUT);
		firstNameInput.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		WebElement lastNameInput = driver.findElement(LAST_NAME_INPUT);
		lastNameInput.sendKeys(lastName);
	}

	public void enterBusinessEmail(String email) {
		WebElement emailInput = driver.findElement(BUSINESS_EMAIL_INPUT);
		emailInput.sendKeys(email);
	}

	public void enterPhoneNumber(String phoneNumber) {
		WebElement phoneNumberInput = driver.findElement(PHONE_NUMBER_INPUT);
		phoneNumberInput.sendKeys(phoneNumber);
	}

	public void enterPassword(String password) {
		WebElement passwordInput = driver.findElement(PASSWORD_INPUT);
		passwordInput.sendKeys(password);
	}

	public void clickCreateAccountButton() {
		WebElement createAccountButton = driver.findElement(CREATE_ACCOUNT_BUTTON);

		// Check the Captcha is displayed and try to click to verify.
		WebElement iframe = driver.findElement(By.cssSelector("#recaptcha > div > div > iframe"));
		driver.switchTo().frame(iframe); // Switch to Captcha Frame
		if (driver.findElement(By.cssSelector("div.recaptcha-checkbox-border")).isDisplayed()) {
			driver.findElement(By.cssSelector("div.recaptcha-checkbox-border")).click();
			driver.switchTo().defaultContent();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.switchTo().frame(2); // Switch to the frame with the images
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("recaptcha-verify-button")));
			// driver.switchTo().defaultContent();

			wait.until(ExpectedConditions.visibilityOf(createAccountButton));
			createAccountButton.click();
		}
		try {
		} catch (Exception e) {
			System.err.println("Unable to create a New Account. Captcha was not verified.");
		}

	}

	public void createNewAccount(String firstName, String lastName, String businessEmail, String phoneNumber,
			String password) {
		enterfirstName(firstName);
		enterLastName(lastName);
		enterBusinessEmail(businessEmail);
		enterPhoneNumber(phoneNumber);
		enterPassword(password);
		clickCreateAccountButton();
	}

}
