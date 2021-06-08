package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zavrsni_projekat.Dashboard;
import zavrsni_projekat.Employee;
import zavrsni_projekat.Home;
import zavrsni_projekat.LogIn;

public class TestEmployee {

	private static WebDriver driver;
	private static WebDriverWait wait;

	@BeforeMethod
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
	}

//	@BeforeMethod
//	public void login() {
//		driver.get(Home.URL_HOME_PAGE);
//		Home.closeAnnouncement(driver);
//		Home.openLogIn(driver);
//		LogIn.enterEmail(driver, "proba@mt2015.com");
//		LogIn.enterPassword(driver, "Test123");
//		LogIn.clickLogin(driver);
//		Dashboard.getStaffButton(wait);
//	}

	@AfterMethod
	public void closeDriverAfterMethod() {
		driver.close();
	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}

	@Test(priority = 1)
	public void addEmployee() {
		driver.get(Home.URL_HOME_PAGE);
		Home.closeAnnouncement(driver);
		Home.openLogIn(driver);
		LogIn.enterEmail(driver, "proba@mt2015.com");
		LogIn.enterPassword(driver, "Test123");
		LogIn.clickLogin(driver);
		Dashboard.getStaffButton(wait);
		Employee.addEmployee(wait, "Mali", "Vrabac", "mali.vrabac@mt2015.com");
		String expectedSTRING = "Mali Vrabac";
		Assert.assertTrue(driver.getPageSource().contains(expectedSTRING));

	}

	@Test(priority = 2)
	public void testChangeName() {
		driver.get(Home.URL_HOME_PAGE);
		Home.closeAnnouncement(driver);
		Home.openLogIn(driver);
		LogIn.enterEmail(driver, "proba@mt2015.com");
		LogIn.enterPassword(driver, "Test123");
		LogIn.clickLogin(driver);
		Dashboard.getStaffButton(wait);
		Employee.changeName(wait, "TEST123");

		String expectedSTRING = "TEST123 Probic";
		Assert.assertEquals(Employee.getName(wait), expectedSTRING);

	}

	@Test(priority = 3)
	public void testCredentials() {
		File f = new File("TableEmployees.xlsx");
		try {
			InputStream is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(0);

			driver.get(Home.URL_HOME_PAGE);
			Home.closeAnnouncement(driver);
			Home.openLogIn(driver);
			LogIn.enterEmail(driver, "proba@mt2015.com");
			LogIn.enterPassword(driver, "Test123");
			LogIn.clickLogin(driver);
			Dashboard.getStaffButton(wait);

			for (int i = 0; i < 5; i++) {

				Row row = sheet.getRow(i);
				Cell c0 = row.getCell(0);
				Cell c1 = row.getCell(1);
				Cell c2 = row.getCell(2);

				String name = c0.toString();
				String lastname = c1.toString();
				String email = c2.toString();

				Employee.addEmployee(wait, name, lastname, email);

			}
			wb.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
