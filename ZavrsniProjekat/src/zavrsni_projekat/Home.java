package zavrsni_projekat;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Home {
	public static final String URL_HOME_PAGE = "https://www.humanity.com/";
	public static final String ABOUT_BUTTON = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a";
	public static final String ANNOUNCEMENT_BTN_TXPATH = "//*[@id=\"tcp-modal\"]/div/div/div[1]/button";
	public static final String DROPDOWNMENU_ABOUTUS = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[1]/a/p[1]";
	public static final String LOGIN_BUTTON = "//*[@id=\"navbarSupportedContent\"]/div/a[2]/p";

	public static void openLogIn(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(LOGIN_BUTTON)).click();
	}

	public static void clickOnAboutUS(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(ABOUT_BUTTON)).click();

	}

	public static void closeAnnouncement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ANNOUNCEMENT_BTN_TXPATH)).click();

	}

	public static void clickOnDropDownMenu_AboutUs(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(DROPDOWNMENU_ABOUTUS)).click();
	}

	public static void makeScreenShot(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(s, new File("Screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
