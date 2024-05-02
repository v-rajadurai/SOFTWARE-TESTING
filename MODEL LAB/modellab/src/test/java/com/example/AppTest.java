package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{
     WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    JavascriptExecutor js;
    @BeforeTest
    public void shouldAnswerWithTrue()
    {
        
        driver = new ChromeDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }
    @Test
    public void testing() throws InterruptedException
    {
        driver.get("https://www.moneycontrol.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("search_str")));


        driver.findElement(By.id("search_str")).sendKeys("Reliance Industries");

        actions.moveToElement(driver.findElement(By.id("search_str"))).click();

        // Explicit wait
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/div[2]/div[2]/ul/li[1]")));

        driver.findElement(
                By.xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/div[2]/div[2]/ul/li[1]"))
                .click();

        js.executeScript("window.scrollBy(0,500)");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Reliance Industries Ltd.")));
        WebElement reliance = driver.findElement(By.linkText("Reliance Industries Ltd."));

        if (reliance.isDisplayed()) {
            System.out.println("Reliance Industries is present in the page");
        } else {
            System.out.println("Reliance Industries is not present in the page");
        }

        driver.findElement(By.linkText("Mutual Funds")).click();
        Thread.sleep(1000);

        js.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.xpath(
                "/html/body/section/section[1]/div/div/div[1]/div[5]/div/div/div/div[1]/div/div[3]/div[1]/div[1]/ul/li[2]/a"))
                .click();
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
       
        
        Select fund=new Select(driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/div[2]/form/select")));
        fund.selectByValue("AA");

        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        Select scheme=new Select(driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/div[4]/form/select")));
        scheme.selectByValue("MAA589");

        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[2]/input")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[2]/input")).sendKeys("100000");
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[6]/div[2]/input")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[6]/div[2]/input")).sendKeys("2021-08-02");
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[6]/div[4]/input")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[6]/div[4]/input")).sendKeys("2023-08-17");
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input")).click();
        WebElement ele=driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[1]/td[2]"));
        System.out.println("Investment Period "+ele.getText());
        WebElement total=driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[3]/td[2]"));
        System.out.println("Total Amount Of Invested "+total.getText());
    }
    @AfterTest
    public void after()
    {
        driver.quit();
    }
}
