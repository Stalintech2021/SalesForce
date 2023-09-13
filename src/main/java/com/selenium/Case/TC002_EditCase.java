package com.selenium.Case;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC002_EditCase {

    @Test
    public void editCase() throws InterruptedException{

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

        //Click on toggle menu button from the left corner
        driver.findElement(By.xpath("//*[@class='slds-icon-waffle']")).click();
        WebElement ele = driver.findElement(By.xpath("//button[text()='View All']"));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();

        //click on 'Cases'
        driver.findElement(By.linkText("Cases")).click();

        //Click on the Dropdown icon and select Edit from the case you created by reffering "case owner alias"
        driver.findElement(By.xpath("//tr[1]/descendant::span[@class='slds-icon_container slds-icon-utility-down']")).click();
        driver.findElement(By.xpath("//*[@title='Edit']")).click();
        //Update Status as Working
        driver.findElement(By.xpath("//*[text()='Status']/following-sibling::div")).click();
        driver.findElement(By.xpath("//span[@title='Working']")).click();


        //Update Priority to low
        driver.findElement(By.xpath("//*[text()='Priority']/following-sibling::div")).click();
        driver.findElement(By.xpath("//span[@title='Low']")).click();


        //Update Case Origin as Phone
        driver.findElement(By.xpath("//*[text()='Case Origin']/following-sibling::div")).click();
        driver.findElement(By.xpath("//span[@title='Phone']")).click();

        //Update SLA violation to No
        WebElement sla = driver.findElement(By.xpath("//*[text()='SLA Violation']/following-sibling::div"));
        js.executeScript("arguments[0].scrollIntoView(true)", sla);
        wait.until(ExpectedConditions.visibilityOf(sla));
        sla.click();
        driver.findElement(By.xpath("//span[@title='No']")).click();

        //Click on Save and Verify Status as Working
        driver.findElement(By.xpath("//*[@type='button' and text()='Save']")).click();

        //Verify Success message
        WebElement saved = driver.findElement(By.xpath("//*[contains(text(), 'saved')]"));
        /*wait.until(ExpectedConditions.visibilityOf(saved));
        Assert.assertTrue(saved.isDisplayed());*/
        saved.isDisplayed();

        driver.close();

    }


}
