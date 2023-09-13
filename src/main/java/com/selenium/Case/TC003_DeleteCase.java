package com.selenium.Case;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC003_DeleteCase {

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
        driver.findElement(By.xpath("//*[@title='Delete']")).click();

        //Confirm Deletion
        driver.findElement(By.xpath("//button/*[contains(text(), 'Delete')]")).click();


        //Verify Success message
        WebElement deleted = driver.findElement(By.xpath("//*[contains(text(), 'deleted')]"));
        /*wait.until(ExpectedConditions.visibilityOf(saved));
        Assert.assertTrue(saved.isDisplayed());*/
        deleted.isDisplayed();

        driver.close();

    }
}
