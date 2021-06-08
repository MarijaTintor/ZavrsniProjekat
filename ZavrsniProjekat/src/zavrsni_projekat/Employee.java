package zavrsni_projekat;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Employee {

	// Lokatori
	public static final String EMPLOYEE = "Proba Probic";
	public static final String EDIT_DETAILS_BUTTON = "Edit Details";
	public static final String FIRST_NAME = "first_name";
	public static final String SAVE_EMPLOYEE = "act_primary";
	public static final String OVERVIEW = "Overview";
	public static final String EMPLOYEE_NAME = "staffPage__itemContent";

	public static final String ADD_EMPLOYEE_BUTTON = "act_primary";
	public static final String EMPLOYEE_FIRST_NAME = "_asf1";
	public static final String EMPLOYEE_LAST_NAME = "_asl1";
	public static final String EMPLOYEE_EMAIL = "_ase1";
	public static final String CONFIRM_EMPLOYEE = "_as_save_multiple";
	public static final String CLOSE_LINK = "close";
	public static final String EMPLOYEE_STAFF_FILTER = "EmployeeStaffFilter";

	// Metode
	public static void changeName(WebDriverWait wait, String name) {
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(EMPLOYEE))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(EDIT_DETAILS_BUTTON))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(FIRST_NAME))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(FIRST_NAME))).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(SAVE_EMPLOYEE))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(OVERVIEW))).click();

	}

	public static void addEmployee(WebDriverWait wait, String name, String lastname, String email) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(ADD_EMPLOYEE_BUTTON))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(EMPLOYEE_FIRST_NAME))).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(EMPLOYEE_LAST_NAME))).sendKeys(lastname);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(EMPLOYEE_EMAIL))).sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(CONFIRM_EMPLOYEE))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(CLOSE_LINK))).click();

	}

	public static String getName(WebDriverWait wait) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.className(EMPLOYEE_NAME))).getText();
	}

}