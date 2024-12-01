package com.leaftaps.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AnimakerLogindemo {
    public static void main(String[] args) {
        // Set up WebDriver Manager for Edge
        WebDriverManager.chromedriver().setup();
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        
        // Open the Animaker login page
        driver.get("https://app.animaker.com");

        // Maximize the browser window
        driver.manage().window().maximize();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");


        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String pagetitle = driver.getTitle();
        System.out.println(pagetitle);
        // Find the username input field and enter the username
        WebElement usernameField = driver.findElement(By.name("email")); 
        usernameField.sendKeys("Mvignesh@animaker.com"); 
        
        WebElement passwordField = driver.findElement(By.name("password")); 
        passwordField.sendKeys("vicky@live"); 
        
//        driver.findElement(By.className("login_button")).click();
//        
//        driver.findElement(By.xpath("//button[text()='Continue']")).click();
//        driver.findElement(By.xpath("//h4[text()='lifetime pro plan']")).click();
//        //driver.findElement(By.xpath("//div[@role='button' and contains(text(), 'Create')]")).click();
//        //driver.findElement(By.xpath("(//button[text()=' Generate'])[2]")).click();
//        
//     
//        // Set up WebDriverWait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//     // Wait for the loader to disappear
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dashboard-loader")));
//        
//        // Wait for the generate button to be visible
//        WebElement generateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()=' Generate'])[2]")));
//
//        // Click the generate button
//        generateButton.click();
//        
//     // Click on the button that opens a new tab
////        WebElement generateButton = driver.findElement(By.xpath("(//button[text()=' Generate'])[2]"));
////        generateButton.click();
//
//        // Wait for the new tab to open
//        WebDriverWait winwait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        winwait.until(ExpectedConditions.numberOfWindowsToBe(2));
//
//        // Get the handles of all open tabs
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//
//        // Switch to the new tab (second tab)
//        driver.switchTo().window(tabs.get(1));
//
//        // Now you can interact with the new tab
//        // For example, print the title of the new tab
//        System.out.println("Title of the new tab: " + driver.getTitle());
//        
//        
        
        
        
        // Click the login button
        driver.findElement(By.className("login_button")).click();

        // Click the 'Continue' button
        driver.findElement(By.xpath("//button[text()='Continue']")).click();

        // Click on 'lifetime pro plan'
        driver.findElement(By.xpath("//h4[text()='lifetime pro plan']")).click();

        // Set up WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for the loader to disappear
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dashboard-loader")));
        } catch (TimeoutException e) {
            System.out.println("Loader did not disappear within the timeout period.");
        }

        // Wait for the generate button to be visible
        WebElement generateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()=' Generate'])[2]")));

        // Click the generate button
        generateButton.click();

        // Wait for the new tab to open
        WebDriverWait winwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        winwait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Get the handles of all open tabs
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to the new tab (second tab)
        driver.switchTo().window(tabs.get(1));

        // Print the title of the new tab
        System.out.println("Title of the new tab: " + driver.getTitle());
        
     
        
//        driver.findElement(By.xpath("//div[@class='sc-dhKdcB iBcOor']//textarea[1]")).click();
//        String str = driver.findElement(By.xpath("//div[@class='sc-dhKdcB iBcOor']//textarea[1]")).getText();


       
        // Wait until the <textarea> is clickable
        //(//textarea)[1]
        
      //WebElement textarea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sc-dhKdcB iBcOor']//textarea[1]")));
        	
        WebElement textarea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[1]")));
        // Click the <textarea>
        textarea.click();

        // Type text into the <textarea>
        textarea.sendKeys("I need to create a video on the DevOps lifecycle");
        
        driver.findElement(By.xpath("//div[text()='IT']")).click();       
      
        
        driver.findElement(By.xpath("//div[contains(text(), 'Next')]")).click();
        driver.findElement(By.xpath("//div[text()='Continue']")).click();
        
      

        
      
        
        // Close the browser
        //driver.quit();
    }
}
