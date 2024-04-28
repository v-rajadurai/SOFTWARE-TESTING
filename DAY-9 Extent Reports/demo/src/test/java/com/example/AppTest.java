package com.example;


import java.io.*;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





public class AppTest 
{
    WebDriver driver;
    WebDriverWait wait;
    @Test
    public void before() throws IOException
    {
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        // FileInputStream f=new FileInputStream("C:\\Users\\ELCOT\\Downloads\\romen.xlsx");

        XSSFWorkbook workbook=new XSSFWorkbook();
        workbook.createSheet("Login");

        XSSFSheet Sheet=workbook.getSheet("login");
        Row row;
        row=Sheet.createRow(0);
        row.createCell(0).setCellValue("username");
        row.createCell(1).setCellValue("password");

        row=Sheet.createRow(1);

        row.createCell(0).setCellValue("romen@gmail.com");
        row.createCell(1).setCellValue("Romen@123");

        row=Sheet.createRow(2);

        row.createCell(0).setCellValue("hello@gmail.com");
        row.createCell(1).setCellValue("Hello@123");
       

        try{

            FileOutputStream out=new FileOutputStream("login.xlsx");
            workbook.write(out);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        workbook.close();
    }
    

}
