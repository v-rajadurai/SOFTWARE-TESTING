//wwe.google.com
package com.google.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumdemoApplication {

	public static void main(String[] args){
		try{

		
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().fullscreen();
		driver.findElement(By.className("gb_Ld")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("identifierId")).sendKeys("727722euit141@skcet.ac.in");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[2]/div/div/div/form/span/section[2]/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")).sendKeys("12345678");
		Thread.sleep(5000);
		driver.findElement(By.className("VfPpkd-muHVFf-bMcfAe")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button/span")).click();
		// SpringApplication.run(SeleniumdemoApplication.class, args);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
