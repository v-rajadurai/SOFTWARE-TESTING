package com.example.practice_at_home;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeAtHomeApplication {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		try
		{

			driver.findElement(By.id("search")).sendKeys("Shoes");
			driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[2]/div[2]/form/div[2]/button")).click();
		


		WebElement hover=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[3]/a/span[1]"));
		new Actions(driver).moveToElement(hover).perform();
		
		Thread.sleep(3000);
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File file=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("/screenshot/image.png"));
	


		WebElement hover2=driver.findElement(By.id("ui-id-17"));
		new Actions(driver).moveToElement(hover2).perform();
		driver.findElement(By.id("ui-id-20")).click();
		driver.navigate().back();
		driver.navigate().back();
		
		
		WebElement scroll=driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/div/a[2]/span[2]/span[2]"));
		new Actions(driver).scrollToElement(scroll).perform();
		scroll.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[4]/ol/li[3]/div")).click();

		WebElement tees=driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/form/div[1]/div/div/div[1]/div/div[3]"));
		new Actions(driver).scrollToElement(tees).perform();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/form/div[1]/div/div/div[1]/div/div[3]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/form/div[1]/div/div/div[2]/div/div[2]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/form/div[2]/div/div/div[1]/div/input")).clear();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/form/div[2]/div/div/div[1]/div/input")).sendKeys("4");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/form/div[2]/div/div/div[2]/button/span")).click();
	
	
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		// SpringApplication.run(PracticeAtHomeApplication.class, args);
	}

}
