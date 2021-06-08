package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zavrsni_projekat.Home;

public class TestAboutUs {
	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}

	@Test
	public void openAboutUS() {
		driver.get(Home.URL_HOME_PAGE);
		Home.closeAnnouncement(driver);
		Home.clickOnAboutUS(driver);
		Home.clickOnDropDownMenu_AboutUs(driver);
		Home.makeScreenShot(driver);
	}
}
