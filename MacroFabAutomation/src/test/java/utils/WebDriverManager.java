package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
    	String projectPath = System.getProperty("user.dir");
        
    	if (driver == null) {
    		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void navigateToURL(String url) {
        getDriver().get(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		// driver.manage().window().maximize();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
