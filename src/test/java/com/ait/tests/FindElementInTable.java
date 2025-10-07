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

public class FindElementInTable {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void tableCssSelector(){
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());

        for (int i = 0; i<rows.size(); i++){
            System.out.println(rows.get(i).getText());
        }
        System.out.println("************************");

        for (WebElement element : rows){
            System.out.println(element.getText());
        }
        System.out.println("************************");

        WebElement austria = driver.findElement(By.cssSelector("#customers tr:nth-child(5)"));
        System.out.println(austria.getText());
        System.out.println("************************");

        WebElement country = driver.findElement(By.cssSelector("#customers tr:nth-child(5) td:nth-child(3)"));
        System.out.println(country.getText());
    }
}
