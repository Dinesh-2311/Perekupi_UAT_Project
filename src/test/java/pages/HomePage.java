package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Filter locators
    private static final By BRAND = By.cssSelector("#brandFilter");
    private static final By MODEL = By.cssSelector("#modelFilter");
    private static final By VOLUME = By.cssSelector("#volumeFilter");
    private static final By YEAR_FROM = By.cssSelector("#yearFrom");
    private static final By YEAR_TO = By.cssSelector("#yearTo");
    private static final By PRICE_FROM = By.cssSelector("#priceFrom");
    private static final By PRICE_TO = By.cssSelector("#priceTo");
    private static final By MILEAGE_FROM = By.cssSelector("#mileageFrom");
    private static final By MILEAGE_TO = By.cssSelector("#mileageTo");
    private static final By CLEAR_FILTERS = By.cssSelector("#clearFilters");

    // Table and actions
    private static final By TABLE_ROWS = By.cssSelector("#carsTableBody > tr");
    private static final By PENCIL_BUTTON = By.cssSelector("#carsTableBody > tr:nth-child(1) > td.text-end.pe-4 > div > div > button");
    private static final By ACTIONS_MENU = By.cssSelector("#carsTableBody > tr:nth-child(1) > td.text-end.pe-4 > div > div > div.actions-menu.show");
    private static final By MARK_AS_NEW = By.cssSelector("#carsTableBody > tr:nth-child(1) .actions-menu.show > button.dropdown-item.mark-new");
    private static final By ADD_COMMENT = By.cssSelector("#carsTableBody > tr:nth-child(1) .actions-menu.show > button.dropdown-item.add-comment");
    private static final By COMMENT_TEXTAREA = By.cssSelector("#carsTableBody > tr:nth-child(1) .comment-dialog textarea");
    private static final By SAVE_COMMENT = By.cssSelector("#carsTableBody > tr:nth-child(1) .comment-dialog .comment-save");

    // Safe click helper
    private void safeClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    // Dropdown filters
    public void setBrand(String brand) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(BRAND));
        new Select(dropdown).selectByVisibleText(brand);
    }

    public void setModel(String model) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(MODEL));
        new Select(dropdown).selectByVisibleText(model);
    }

    public void setVolume(String volume) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(VOLUME));
        new Select(dropdown).selectByVisibleText(volume);
    }

    // Text input filters
    public void setYearFrom(String year) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(YEAR_FROM));
        input.clear();
        input.sendKeys(year);
    }

    public void setYearTo(String year) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(YEAR_TO));
        input.clear();
        input.sendKeys(year);
    }

    public void setPriceFrom(String price) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(PRICE_FROM));
        input.clear();
        input.sendKeys(price);
    }

    public void setPriceTo(String price) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(PRICE_TO));
        input.clear();
        input.sendKeys(price);
    }

    public void setMileageFrom(String mileage) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(MILEAGE_FROM));
        input.clear();
        input.sendKeys(mileage);
    }

    public void setMileageTo(String mileage) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(MILEAGE_TO));
        input.clear();
        input.sendKeys(mileage);
    }

    public void clearFilters() {
        safeClick(CLEAR_FILTERS);
    }

    public int getRowCount() {
        return driver.findElements(TABLE_ROWS).size();
    }

    // Action menu
    public void openActionMenu() {
        // Click pencil button to open menu
        safeClick(PENCIL_BUTTON);
        // Wait for menu to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACTIONS_MENU));
    }

    public void clickMarkAsNew() {
        safeClick(MARK_AS_NEW);
    }

    public void clickAddComment() {
        safeClick(ADD_COMMENT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(COMMENT_TEXTAREA));
    }

    public void enterComment(String comment) {
        WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(COMMENT_TEXTAREA));
        textarea.clear();
        textarea.sendKeys(comment);
    }

    public void saveComment() {
        safeClick(SAVE_COMMENT);
    }
}