package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import zavrsni_projekat.Dashboard;
import zavrsni_projekat.Home;
import zavrsni_projekat.LogIn;

public class TestDashboard {
	private static WebDriver driver;
	private static WebDriverWait wait;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}

	@Test(priority = 1)
	public void testDashboardButton() {
		driver.get(Home.URL_HOME_PAGE);
		Home.closeAnnouncement(driver);
		Home.openLogIn(driver);
		LogIn.enterEmail(driver, "proba@mt2015.com");
		LogIn.enterPassword(driver, "Test123");
		LogIn.clickLogin(driver);
		Dashboard.getDashboard(driver);

		String actualURL1 = driver.getCurrentUrl();
		String expectedURL1 = "https://test935.humanity.com/app/dashboard/";

		Dashboard.getShiftPlanning(driver);

		String actualURL2 = driver.getCurrentUrl().substring(0, 42);
		String expectedURL2 = "https://test935.humanity.com/app/schedule/";

		Dashboard.getTimeClock(driver);

		String actualURL3 = driver.getCurrentUrl();
		String expectedURL3 = "https://test935.humanity.com/app/timeclock/";

		Dashboard.getLeave(driver);

		String actualURL4 = driver.getCurrentUrl();
		String expectedURL4 = "https://test935.humanity.com/app/requests/vacation/";

		Dashboard.getTraining(driver);

		String actualURL5 = driver.getCurrentUrl();
		String expectedURL5 = "https://test935.humanity.com/app/training/";

		Dashboard.getStaffButton(wait);

		String actualTEXT = Dashboard.getStaffText(wait);
		String expectedTEXT = "Staff";

		Dashboard.getAvailability(wait);

		String actualURL7 = driver.getCurrentUrl().substring(0, 45);
		String expectedURL7 = "https://test935.humanity.com/fe/availability/";

		Dashboard.getPayroll(wait);

		String actualURL8 = driver.getCurrentUrl();
		String expectedURL8 = "https://test935.humanity.com/app/payroll/scheduled-hours/";

		Dashboard.getReports(driver);

		String actualURL9 = driver.getCurrentUrl();
		String expectedURL9 = "https://test935.humanity.com/app/reports/dashboard/";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualURL1, expectedURL1);
		sa.assertEquals(actualURL2, expectedURL2);
		sa.assertEquals(actualURL3, expectedURL3);
		sa.assertEquals(actualURL4, expectedURL4);
		sa.assertEquals(actualURL5, expectedURL5);
		sa.assertEquals(actualTEXT, expectedTEXT);
		sa.assertEquals(actualURL7, expectedURL7);
		sa.assertEquals(actualURL8, expectedURL8);
		sa.assertEquals(actualURL9, expectedURL9);
		sa.assertAll();

	}

}
