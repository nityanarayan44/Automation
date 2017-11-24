package org.nng.test.utills;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotCapture {
	public static String captureScreen(WebDriver driver, String folder) {
		String path;
		try {
			//WebDriver augmentedDriver = new Augmenter().augment(driver);
			//File source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			path = "./screenshots/" + folder + "/" + source.getName();
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			path = "Failed to capture screenshot: " + e.getMessage();
		}
		return path;
	}
}
