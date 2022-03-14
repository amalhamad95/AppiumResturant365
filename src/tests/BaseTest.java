package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {

	public static AndroidDriver<MobileElement> driver;
	public static DesiredCapabilities caps = new DesiredCapabilities();
	public static final long WAIT = 3 * 1000;

	public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(WAIT)), this);
	}

	@BeforeClass
	public static void driverSetUp() {
		caps.setCapability("deviceName", "Hope95");
//		caps.setCapability("udid", "TMF4C19509001736");
		caps.setCapability("platformName", "Android");
//		caps.setCapability("platformVersion", "10");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		File app = new File("app\\R365dev.apk");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		caps.setCapability("appPackage", "com.restaurant365.dev");
		caps.setCapability("appActivity", "com.restaurant365.ui.splash.SplashActivity");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitVisibilityOf(MobileElement element) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT);
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}
}
