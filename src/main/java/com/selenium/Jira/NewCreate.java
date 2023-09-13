package com.selenium.Jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewCreate  {

    @Test
    public void JiraCreate() throws InterruptedException{

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://api-training.atlassian.net/");

        //Enter Login details and Submit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.name("username")).sendKeys("hari.radhakrishnan@testleaf.com");
        //stalinindialearn21@gmail.com
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        WebElement pass = driver.findElement(By.name("password"));
        wait.until(ExpectedConditions.elementToBeClickable(pass));
        pass.sendKeys("India@123");
        driver.findElement(By.id("login-submit")).click();

        //Select 'SDET-5'
        Thread.sleep(5000);
        WebElement sdet = driver.findElement(By.xpath("//p[text()='SDET-5']"));
        wait.until(ExpectedConditions.elementToBeClickable(sdet));
        sdet.click();
        Thread.sleep(3000);
        WebElement create = driver.findElement(By.id("createGlobalItem"));
        wait.until(ExpectedConditions.elementToBeClickable(create));
        create.click();

        //Enter 'Summary' details
        driver.findElement(By.name("summary")).sendKeys("NewStory for Automation -- Stalin Durai23");

        WebElement createBtn = driver.findElement(By.xpath("//*[@type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        createBtn.click();

        Thread.sleep(3000);
        WebElement searchIssues = driver.findElement(By.linkText("Backlog"));
        wait.until(ExpectedConditions.elementToBeClickable(searchIssues));
        wait.until(ExpectedConditions.visibilityOf(searchIssues));
        searchIssues.click();

        driver.findElement(By.name("search")).sendKeys("Story for Automation -- Stalin Durai");

        driver.quit();












    }

}
