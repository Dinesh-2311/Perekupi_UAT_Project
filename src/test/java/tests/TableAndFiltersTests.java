package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPages;
import utils.ExtentManager;
import utils.ScreenshotUtil;
import utils.ExtentTestNGListener;
import com.aventstack.extentreports.MediaEntityBuilder;

@Listeners(ExtentTestNGListener.class)
public class TableAndFiltersTests extends BaseTest {

    @Test
    public void filtersTestBMW() {
        LoginPages login = new LoginPages(driver);
        login.open();

        // Screenshot after entering credentials
        login.enterCredentials("admin", "admin");
        ExtentManager.getTest().info("Entered valid credentials (admin/admin)",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        // Screenshot when clicking login
        login.clickLogin();
        ExtentManager.getTest().info("Clicked Login button",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        HomePage home = new HomePage(driver);

        ExtentManager.getTest().info("Before applying BMW filters",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        home.setBrand("BMW");
        home.setModel("118");
        home.setVolume("2.0");
        home.setYearFrom("2010");
        home.setYearTo("2022");
        home.setPriceFrom("0");
        home.setPriceTo("30000");
        home.setMileageFrom("0");
        home.setMileageTo("80000");

        ExtentManager.getTest().info("After entering BMW filters",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        home.clearFilters();
        ExtentManager.getTest().pass("After clearing BMW filters",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        Assert.assertTrue(home.getRowCount() > 0, "Table should have rows after clearing filters");
    }

    @Test
    public void filtersTestAudi() {
        LoginPages login = new LoginPages(driver);
        login.open();

        login.enterCredentials("admin", "admin");
        ExtentManager.getTest().info("Entered valid credentials (admin/admin)",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        login.clickLogin();
        ExtentManager.getTest().info("Clicked Login button",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        HomePage home = new HomePage(driver);

        ExtentManager.getTest().info("Before applying AUDI filters",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        home.setBrand("AUDI");
        home.setModel("A4");
        home.setVolume("2.0");
        home.setYearFrom("2005");
        home.setYearTo("2025");
        home.setPriceFrom("1000");
        home.setPriceTo("15000");
        home.setMileageFrom("0");
        home.setMileageTo("100000");

        ExtentManager.getTest().info("After entering AUDI filters",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        home.clearFilters();
        ExtentManager.getTest().pass("After clearing AUDI filters",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        Assert.assertTrue(home.getRowCount() > 0, "Table should have rows after clearing filters");
    }

    @Test
    public void markAsNewTest() {
        LoginPages login = new LoginPages(driver);
        login.open();

        login.enterCredentials("admin", "admin");
        ExtentManager.getTest().info("Entered valid credentials (admin/admin)",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        login.clickLogin();
        ExtentManager.getTest().info("Clicked Login button",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        HomePage home = new HomePage(driver);

        Assert.assertTrue(home.getRowCount() > 0, "Table should have rows after login");

        home.openActionMenu();
        ExtentManager.getTest().info("Opened action menu",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        home.clickMarkAsNew();
        ExtentManager.getTest().pass("Clicked 'Mark as new'",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());
    }

    @Test
    public void writeCommentTest() {
        LoginPages login = new LoginPages(driver);
        login.open();

        login.enterCredentials("admin", "admin");
        ExtentManager.getTest().info("Entered valid credentials (admin/admin)",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        login.clickLogin();
        ExtentManager.getTest().info("Clicked Login button",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        HomePage home = new HomePage(driver);

        Assert.assertTrue(home.getRowCount() > 0, "Table should have rows after login");

        home.openActionMenu();
        ExtentManager.getTest().info("Opened action menu",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        home.clickAddComment();
        ExtentManager.getTest().info("Clicked add/edit comment",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        home.enterComment("excellent vehicles");
        ExtentManager.getTest().info("Entered comment text",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        home.saveComment();
        ExtentManager.getTest().pass("Saved comment",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());
    }
}