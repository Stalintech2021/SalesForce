package com.selenium.Case;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC001_CerateNewCase {

    @Test
    public void createNewCase() throws InterruptedException{

        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);*/

        //Launch the app
        WebDriver driver = new FirefoxDriver();
        FirefoxOptions option = new FirefoxOptions();
        option.addArguments("--disable-notifications");
        JavascriptExecutor js = (JavascriptExecutor) driver;

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

        //click on 'Cases'
        driver.findElement(By.linkText("Cases")).click();
        //Click on 'New'
        driver.findElement(By.partialLinkText("New")).click();

        //Select status as Escalated
        driver.findElement(By.xpath("//*[text()='Status']/following-sibling::div")).click();
        driver.findElement(By.xpath("//span[@title='Escalated']")).click();

        //Choose Contact Name from the dropdown
        driver.findElement(By.xpath("//*[text()='Contact Name']/following-sibling::div")).click();
        driver.findElement(By.xpath("//span[@title='Naveen Elumalai']")).click();

        //Select Case origin as email
        driver.findElement(By.xpath("//*[text()='Case Origin']/following-sibling::div")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        try{
            WebElement caseOrigin = driver.findElement(By.xpath("//span[@title='Email']"));
            wait.until(ExpectedConditions.elementToBeClickable(caseOrigin));
            caseOrigin.click();
        }catch (TimeoutException e){
            driver.findElement(By.xpath("//*[text()='Case Origin']/following-sibling::div")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        }


        //Enter Subject as 'Testing' and description as 'Dummy'
        driver.findElement(By.name("Subject")).sendKeys("Testing");
        WebElement ele2 = driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div"));
        Actions action = new Actions(driver);
        action.moveToElement(ele2);
        js.executeScript("arguments[0].scrollIntoView(true)", ele2);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/textarea")).sendKeys("Dummy");

        //click on 'Save' button
        driver.findElement(By.xpath("//*[@type='button' and text()='Save']")).click();

        driver.quit();

    }




}
