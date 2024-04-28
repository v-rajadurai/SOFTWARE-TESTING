package com.example;

import org.openqa.selenium.By;
import java.io.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{
    WebDriver driver;
    Actions action;
    @BeforeTest
    public void beforeTest()
    {
        
        driver=new ChromeDriver();
        driver.get("https://groww.in/");

    }
    @Test
    public void testing() throws IOException
    {
        
        try {

            Thread.sleep(3000);
            WebElement scroll = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div/div[1]/div/div[1]/div[2]/div[3]/a[2]"));
            new Actions(driver).scrollToElement(scroll).perform();
        scroll.click();
        if(driver.getTitle().equals("Calculators"))
        {
            System.out.print("Successful");
        }
        else
        {
            System.out.print("Failed");
            
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/a[15]/div")).click();
        
        driver.findElement(By.xpath("//*[@id='LOAN_AMOUNT']")).clear;
        // driver.findElement(By.className("c-eSYZiJ c-eSYZiJ-hchblo-variant-default bodyXLargeHeavy")).clear();
        
        } 
        catch (InterruptedException e) {
        
            e.printStackTrace();
        }
    }
    @AfterTest
    public void after() throws InterruptedException
    {
        Thread.sleep(30000);
        driver.close();
    }

}
