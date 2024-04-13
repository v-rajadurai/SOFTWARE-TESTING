package com.example.class_exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClassExerciseApplication {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		try
		{

			driver.get("https://demoblaze.com/");	
			Thread.sleep(3000);
			driver.findElement(By.linkText("Laptops")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("MacBook air")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Add to cart")).click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Cart")).click();
			Thread.sleep(3000);
			List<WebElement> list=driver.findElements(By.tagName("td"));
			
			System.out.println("Title: "+list.get(1).getText());
			System.out.println("Price: "+list.get(2).getText());
			

		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		// SpringApplication.run(ClassExerciseApplication.class, args);
	}

}
