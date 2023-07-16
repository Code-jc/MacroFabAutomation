package org.macrofab.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public static final By DASHBOARD_HEADER_TEXT = By.xpath("//h1[text()='Dashboard']");
	public static final By NO_PCB_ORDERS_TEXT = By.xpath("//div[text()='You have no PCB orders.']");
	public static final By NO_OUTBOUND_SHIPMENTS_TEXT = By.xpath("//div[text()='You have no outbound shipments.']");
	public static final By NO_INBOUND_SHIPMENTS_TEXT = By.xpath("//div[text()='You have no inbound shipments. ']");
	public static final By NO_INVENTORY_TEXT = By.xpath("//div[text()='You have no inventory. ]");
	public static final By NO_FULFILLMENTS_TEXT = By.xpath("//div[text()='You have no fulfillment items. ']");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(70));
	}

	public String checkDashboardPage() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DASHBOARD_HEADER_TEXT));
		String pageTitle = driver.getTitle();

		return pageTitle;
	}

	public boolean hasPcbOrders(boolean hasItems) {
		if (!hasItems) {
			try {
				WebElement noPcbOrdersText = driver.findElement(NO_PCB_ORDERS_TEXT);
				hasItems = !noPcbOrdersText.isDisplayed();
			} catch (Exception e) {
				System.err.println("Error while finding the element: No PCB Orders.");
			}
		}

		return hasItems;
	}

	public boolean hasOutboundShipments(boolean hasItems) {
		if (!hasItems) {
			try {
				WebElement noOutboundShipmentsText = driver.findElement(NO_OUTBOUND_SHIPMENTS_TEXT);
				hasItems = !noOutboundShipmentsText.isDisplayed();
			} catch (Exception e) {
				System.err.println("Error while finding the element: No Outbound Shipments.");
			}
		}

		return hasItems;
	}

	public boolean hasInboundShipments(boolean hasItems) {
		if (!hasItems) {
			try {
				WebElement noInboundShipmentsText = driver.findElement(NO_INBOUND_SHIPMENTS_TEXT);
				hasItems = !noInboundShipmentsText.isDisplayed();
			} catch (Exception e) {
				System.err.println("Error while finding the element: No Inbound Shipments.");
			}
		}

		return hasItems;
	}

	public boolean hasInventory(boolean hasItems) {
		if (!hasItems) {
			try {
				WebElement noInventoryText = driver.findElement(NO_INVENTORY_TEXT);
				hasItems = !noInventoryText.isDisplayed();
			} catch (Exception e) {
				System.err.println("Error while finding the element: No Inventory.");
			}
		}

		return hasItems;
	}
}
