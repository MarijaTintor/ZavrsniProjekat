package zavrsni_projekat;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings {

	// Lokatori
	public static final String SETTINGS_BUTTON = "sn_admin";
	public static final String DEFAULT_LANGUAGE = "//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select";
	public static final String SAVE_SETTINGS = "act_primary";
	public static final String SERBIAN_WORD = "primNavQtip__itemName";

	public static final String NOTIFICATION_EMAIL = "pref_pref_email";
	public static final String NOTIFICATION_SMS = "pref_pref_sms";
	public static final String NOTIFICATION_MOBILE = "pref_pref_mobile_push";

	public static final String LOGIN_WITH_FACEBOOK = "pref_pref_login_facebook";
	public static final String MASSAGE_WALL = "pref_pref_message_wall_on";

	// Metode

	public static void chooseLanguage(WebDriverWait wait, String slovo) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(SETTINGS_BUTTON))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DEFAULT_LANGUAGE))).sendKeys(slovo);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(SAVE_SETTINGS))).click();

	}

	public static String findWord(WebDriverWait wait) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.className(SERBIAN_WORD))).getText();
	}

	public static void disableNotifications(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(SETTINGS_BUTTON))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(NOTIFICATION_EMAIL))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(NOTIFICATION_SMS))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(NOTIFICATION_MOBILE))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(SAVE_SETTINGS))).click();
	}

	public static boolean isEmailBoxSelected(WebDriverWait wait) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id(NOTIFICATION_EMAIL))).isSelected();
	}

	public static boolean isSmsBoxSelected(WebDriverWait wait) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id(NOTIFICATION_SMS))).isSelected();
	}

	public static boolean isMobileBoxSelected(WebDriverWait wait) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id(NOTIFICATION_MOBILE))).isSelected();
	}

	public static void facebookLogin(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(SETTINGS_BUTTON))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(LOGIN_WITH_FACEBOOK))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(SAVE_SETTINGS))).click();
	}

	public static void massageWall(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(SETTINGS_BUTTON))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(MASSAGE_WALL))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(SAVE_SETTINGS))).click();
	}

	public static boolean isFacebookLoginSelected(WebDriverWait wait) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id(LOGIN_WITH_FACEBOOK))).isSelected();
	}

	public static boolean isMassageWallSelected(WebDriverWait wait) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id(MASSAGE_WALL))).isSelected();
	}
}
