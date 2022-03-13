package helpers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileElement;

public class Helper {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		Path dest = Paths.get("./Screenshots/", screenshotName + ".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Screenshot Exception" + e.getMessage());
		}
	}

	public static int convertStringToInteger(MobileElement element) {
		String textWithNumber = element.getText().replaceAll("[^\\d.]", "");
		return Integer.parseInt(textWithNumber);
	}

	public static double convertStringToDouble(MobileElement element) {
		String textWithNumber = element.getText().replaceAll("[^\\d.]", "");
		return Double.parseDouble(textWithNumber);
	}

}
