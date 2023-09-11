package com.selenium.opportunity;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC001_CerateNewOpportunity {

    @Test
    public void createNewOpportunity() throws InterruptedException{

        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);*/

        //Launch the app
        WebDriver driver = new FirefoxDriver();
        FirefoxOptions option = new FirefoxOptions();
        option.addArguments("--disable-notifications");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://login.salesforce.com/");

        //Click Login
        //Login with the credentials
        driver.findElement(By.id("username")).sendKeys("balajisara1997@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Balaji@008");
        driver.findElement(By.id("Login")).click();
        Thread.sleep(2000);

        //Click on Global Actions SVG icon
        driver.findElement(By.xpath("//*[@class='slds-icon-waffle']")).click();

        WebElement ele = driver.findElement(By.xpath("//button[text()='View All']"));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();

        //click on 'Opportubties'
        driver.findElement(By.linkText("Opportunities")).click();

        //Click on New Opportunity
        driver.findElement(By.partialLinkText("New")).click();
        driver.findElement(By.name("Name")).sendKeys("Salesforce Automation By Srikanth");

        //Select the date
        driver.findElement(By.name("CloseDate")).click();
        Date date = new Date();
        int currDate = date.getDate();
        System.out.println(currDate);
        driver.findElement(By.xpath("//div[contains(@class,'slds-datepicker')]//span[text()='"+currDate+"']")).click();

        //Click on the 'Stage'
        WebElement dropDown = driver.findElement(By.xpath("//button[@role='combobox']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", dropDown);

        //click on 'Needs Analysis'
        driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();

        //click on 'Save' button
        driver.findElement(By.xpath("//*[@type='button' and text()='Save']")).click();

        driver.quit();

    }




}
