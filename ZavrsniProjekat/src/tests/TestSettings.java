package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import zavrsni_projekat.Home;
import zavrsni_projekat.LogIn;
import zavrsni_projekat.Settings;

public class TestSettings {
	private static WebDriver driver;
	private static WebDriverWait wait;

	@BeforeMethod
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
	}

	@AfterMethod
	public void closeDriverAfterMethod() {
		driver.close();
	}

	@Test
	public void testLanguage() {
		driver.get(Home.URL_HOME_PAGE);
		Home.closeAnnouncement(driver);
		Home.openLogIn(driver);
		LogIn.enterEmail(driver, "proba@mt2015.com");
		LogIn.enterPassword(driver, "Test123");
		LogIn.clickLogin(driver);
		String language = "s";
		Settings.chooseLanguage(wait, language);
		driver.get("https://test935.humanity.com/app/admin/settings/");
		driver.navigate().refresh();

		String word = "Командна табла";
		Assert.assertEquals(Settings.findWord(wait), word);

	}

	@Test
	public void testNotifications() {
		driver.get(Home.URL_HOME_PAGE);
		Home.closeAnnouncement(driver);
		Home.openLogIn(driver);
		LogIn.enterEmail(driver, "proba@mt2015.com");
		LogIn.enterPassword(driver, "Test123");
		LogIn.clickLogin(driver);
		Settings.disableNotifications(wait);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(Settings.isEmailBoxSelected(wait), true);
		sa.assertEquals(Settings.isSmsBoxSelected(wait), true);
		sa.assertEquals(Settings.isMobileBoxSelected(wait), true);

	}

	@Test
	public void testFacebookLogin() {
		driver.get(Home.URL_HOME_PAGE);
		Home.closeAnnouncement(driver);
		Home.openLogIn(driver);
		LogIn.enterEmail(driver, "proba@mt2015.com");
		LogIn.enterPassword(driver, "Test123");
		LogIn.clickLogin(driver);
		Settings.facebookLogin(wait);
		Assert.assertEquals(Settings.isFacebookLoginSelected(wait), true);
	}

	@Test
	public void testMassageWall() {
		driver.get(Home.URL_HOME_PAGE);
		Home.closeAnnouncement(driver);
		Home.openLogIn(driver);
		LogIn.enterEmail(driver, "proba@mt2015.com");
		LogIn.enterPassword(driver, "Test123");
		LogIn.clickLogin(driver);
		Settings.massageWall(wait);
		Assert.assertEquals(Settings.isMassageWallSelected(wait), false);
	}

}
