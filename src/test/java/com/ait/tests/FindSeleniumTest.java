package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindSeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementByTagName() {
        //by tag - h1
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
        //by tag - h2
        WebElement title2 = driver.findElement(By.tagName("h2"));
        System.out.println(title2.getText());
        //by tag - a
        WebElement title3 = driver.findElement(By.tagName("a"));
        System.out.println(title3.getText());

        //find list of elements
        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println(list.size());
        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println(labels.size());
    }
}
