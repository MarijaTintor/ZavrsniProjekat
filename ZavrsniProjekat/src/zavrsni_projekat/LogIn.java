package zavrsni_projekat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {

	public static final String EMAIL = "email";
	public static final String PASS = "password";
	public static final String LOGIN = "login";

	public static void enterEmail(WebDriver driver, String email) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id(EMAIL)).sendKeys(email);
	}

	public static void enterPassword(WebDriver driver, String password) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id(PASS)).sendKeys(password);
	}

	public static void clickLogin(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name(LOGIN)).click();
	}

}
