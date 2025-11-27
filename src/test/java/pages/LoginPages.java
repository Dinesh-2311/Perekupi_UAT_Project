package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPages {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Selectors
    private static final By USERNAME = By.cssSelector("#name");
    private static final By PASSWORD = By.cssSelector("#password");
    private static final By LOGIN_BUTTON = By.cssSelector(
            "body > div > div > div > div > div.card-body.p-4 > form > div:nth-child(4) > button"
    );
    private static final By LOGOUT = By.cssSelector("body > header > div > div > div > a");
    private static final By ERROR = By.cssSelector(".invalid-feedback, .alert, [role='alert']");
    private static final By HOME_TABLE = By.cssSelector("#carsTableBody");

    public void open() {
        driver.get("https://perekupi-1.onrender.com/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
    }

    // Step 1: Enter credentials
    public void enterCredentials(String user, String pass) {
        WebElement u = wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
        WebElement p = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD));

        u.clear();
        u.sendKeys(user);
        p.clear();
        p.sendKeys(pass);
    }

    // Step 2: Click login button
    public void clickLogin() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public boolean loginSuccess() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_TABLE)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean loginFailed() {
        try {
            return !driver.findElements(ERROR).isEmpty()
                    || driver.getCurrentUrl().contains("login")
                    || driver.findElements(LOGOUT).isEmpty();
        } catch (Exception e) {
            return true;
        }
    }

    public void logout() {
        if (!driver.findElements(LOGOUT).isEmpty()) {
            driver.findElement(LOGOUT).click();
        }
    }
}