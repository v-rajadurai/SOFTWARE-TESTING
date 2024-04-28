package com.example;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{
    WebDriver driver;
    WebDriverWait wait;
    String username;
    String password;

    @BeforeTest
    public void before() throws IOException
    {
        driver =new ChromeDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(100));

        FileInputStream file=new FileInputStream("c:\\Users\\ELCOT\\Downloads\\romen (1).xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        
        XSSFSheet sheet=workbook.getSheet("Sheet1");

        username = sheet.getRow(1).getCell(0).getStringCellValue();
        password = sheet.getRow(1).getCell(1).getStringCellValue();
        
    }
    @Test
    public void testing()
    {
        driver.get("http://dbankdemo.com/bank/login");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }
}
