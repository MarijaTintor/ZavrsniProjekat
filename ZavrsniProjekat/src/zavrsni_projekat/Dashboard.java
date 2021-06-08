package zavrsni_projekat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

	// Lokatori-Meni

	public static final String AVATAR = "tr_avatar";
	public static final String DASHBOARD_BUTTON = "sn_dashboard";
	public static final String SHIFTPLANNING_BUTTON = "//*[@id=\"sn_schedule\"]/span";
	public static final String TIMECLOCK_BUTTON = "sn_timeclock";
	public static final String LEAVE_BUTTON = "sn_requests";
	public static final String TRAINING_BUTTON = "sn_training";
	public static final String STAFF_BUTTON = "sn_staff";
	public static final String STAFF = "_topnavLabel";
	public static final String AVAILABILITY_BUTTON = "sn_availability";
	public static final String PAYROLL = "//*[@id=\"root\"]/div[2]/div/div/div[1]/div/div/div[2]/div[8]/a/p";
	public static final String REPORTS_BUTTON = "sn_reports";

	// Lokatori-Staff

	// public static final String CONFIRMATION =
	// "//*[@id=\"_cd_staff\"]/div[2]/div[2]/table/tbody/tr/td[2]/div[2]/div/table/tbody/tr[7]/td[1]";
	// public static final String CONFIRMED_EMPLOYEES =
	// "//*[@id=\"staff-list-container\"]/div[2]";

	// Metode-Meni

	public static boolean findDashboard(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(By.id(AVATAR)).isDisplayed();
	}

	public static void getDashboard(WebDriver driver) {
		driver.findElement(By.id(DASHBOARD_BUTTON)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void getShiftPlanning(WebDriver driver) {
		driver.findElement(By.xpath(SHIFTPLANNING_BUTTON)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void getTimeClock(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id(TIMECLOCK_BUTTON)).click();
	}

	public static void getLeave(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id(LEAVE_BUTTON)).click();
	}

	public static void getTraining(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id(TRAINING_BUTTON)).click();
	}

	public static void getStaffButton(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(STAFF_BUTTON))).click();
	}

	public static String getStaffText(WebDriverWait wait) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(STAFF))).getText();
	}

	public static void getAvailability(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(AVAILABILITY_BUTTON))).click();
	}

	public static void getPayroll(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PAYROLL))).click();
	}

	public static void getReports(WebDriver driver) {
		driver.findElement(By.id(REPORTS_BUTTON)).click();
	}

	// Metoda-Staff

}
