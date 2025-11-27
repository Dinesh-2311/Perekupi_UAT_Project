package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPages;
import utils.ExtentManager;
import utils.ScreenshotUtil;
import utils.ExtentTestNGListener;
import com.aventstack.extentreports.MediaEntityBuilder;

@Listeners(ExtentTestNGListener.class)
public class LoginTests extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginPages login = new LoginPages(driver);

        login.open();

        // Enter credentials and capture screenshot
        login.enterCredentials("admin", "admin");
        ExtentManager.getTest().info("Entered valid credentials (admin/admin)",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        // Click login and capture screenshot
        login.clickLogin();
        ExtentManager.getTest().info("Clicked Login button with valid credentials",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        Assert.assertTrue(login.loginSuccess(),
                "Login should succeed with valid credentials!");

        // Logout and capture screenshot
        login.logout();
        ExtentManager.getTest().info("Clicked Logout",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        ExtentManager.getTest().pass("Successfully logged out",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());
    }

    @Test
    public void unsuccessfulLoginTest() {
        LoginPages login = new LoginPages(driver);

        login.open();

        // Enter invalid credentials and capture screenshot
        login.enterCredentials("wrong", "wrong");
        ExtentManager.getTest().info("Entered invalid credentials (wrong/wrong)",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        // Click login and capture screenshot
        login.clickLogin();
        ExtentManager.getTest().info("Clicked Login button with invalid credentials",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());

        Assert.assertTrue(login.loginFailed(),
                "Login should fail with invalid credentials!");

        ExtentManager.getTest().pass("Invalid login detected correctly",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotUtil.captureScreenshotBase64(driver)).build());
    }
}