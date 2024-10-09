package com.makemytrip.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.makemytrip.testbase.TestBase;

public class MMT_Methods extends TestBase {
	//Mouse click
		public static void doClick(String locator)
		{
			driver.findElement(By.xpath(locator)).click();
		}
		//get the webelements size
		public static List<WebElement> getWebElements(String locator)
		{
			List<WebElement> elements = driver.findElements(By.xpath(locator));
			
			return elements;
		}
		public static List<String> getWebElementsText(String locator)
		{
			List<String> resultList = new ArrayList<>();
			List<WebElement> elements = driver.findElements(By.xpath(locator));
			for(WebElement element:elements)
			{
				String text = element.getText();
				resultList.add(text);
			}
			
			return resultList;
		}
		
		//Search element and click
		public static void doMoveTOElementClick(String locator)
		{
			WebElement element = driver.findElement(By.xpath(locator));
			js.executeScript("arguments[0].click();", element);
		}
		
		//Enter key
		public static void doEnter(String locator)
		{
			driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
		}
		
		//enter data in input data
		public static void doTypeText(String locator, String value)
		{
			driver.findElement(By.xpath(locator)).sendKeys(value);
		}
		//isSelected
		public static boolean isSelected(String locator)
		{
			boolean selected = driver.findElement(By.xpath(locator)).isSelected();
			return selected;
		}
		//expWait
		public static void expWait(String locator, int seconds)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		}
		
		//Screenshot
		public static String takeScreenShot(ITestResult iTestResult)
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss aa").format(new Date());
			String dest = System.getProperty("user.dir") + "/Screenshots/" + iTestResult.getName() + timeStamp + ".png";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(dest));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return dest;
		}
}
