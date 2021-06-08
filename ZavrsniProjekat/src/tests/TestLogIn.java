package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zavrsni_projekat.Dashboard;
import zavrsni_projekat.Home;
import zavrsni_projekat.LogIn;

public class TestLogIn {
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
	public void openLogIn() {
		driver.get(Home.URL_HOME_PAGE);
		Home.closeAnnouncement(driver);
		Home.openLogIn(driver);
		LogIn.enterEmail(driver, "proba@mt2015.com");
		LogIn.enterPassword(driver, "Test123");
		LogIn.clickLogin(driver);

		Assert.assertEquals(Dashboard.findDashboard(driver), true);

	}

}
