package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");

        driver.manage().window().maximize();
        //   driver.manage().window().setSize(new Dimension(900,400));
        //  driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementByTagName() {
        //find one element
        //by tag - h1
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
        //by tag - h2
        WebElement title2 = driver.findElement(By.tagName("h2"));
        System.out.println(title2.getText());
        //by tag - a
        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getText());
        //by tag - label
        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println(label.getText());

        //find list of elements
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println(labels.size());
    }

    @Test
    public void findElementById() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getDomAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getDomAttribute("id"));
    }

    @Test
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement search = driver.findElement(By.className("navigation-link"));
        System.out.println(search.getText());
        System.out.println(search.getDomAttribute("class"));
    }

    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());

        WebElement linkText2 = driver.findElement(By.linkText("Los Angeles"));
        System.out.println(linkText2.getText());
    }

    @Test
    public void findElementByPartialLinkText() {
        WebElement partialLinkText = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLinkText.getText());
    }

    @Test
    public void findElementByCssSelector() {
        //  driver.findElement(By.tagName("h1"));
        // tag name "h1" -> "h1"
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("h2"));

        //driver.findElement(By.id("city"));
        //id ="city" -> #city
        driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.cssSelector("#dates"));

        //driver.findElement(By.className("telephone"));
        //class="telephone" -> .telephone
        driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.cssSelector(".navigation-link"));

        //contains -> *
        driver.findElement(By.cssSelector("[class*='pristine']"));
        //start -> ^
        driver.findElement(By.cssSelector("[class^='ng']"));
        //end to -> $
        driver.findElement(By.cssSelector("[class$='invalid']"));

        //[key='value']
        driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        driver.findElement(By.cssSelector("[for='dates']"));
        driver.findElement(By.cssSelector("[href='/search']"));

        //composite cssSelector
        driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));//tag+class+pare
        driver.findElement(By.cssSelector(".fas.fa-bars"));// class + class

        driver.findElement(By.cssSelector(".logo>img")); // > one step below
        driver.findElement(By.cssSelector(".feedback-body .feedback-date"));// <space> one or more steps below

        //<tag> or <class> or <id>:nth-child(n)
        WebElement feedback = driver.findElement(By.cssSelector(".feedback:nth-child(1)"));
        System.out.println(feedback.getText());
        WebElement search = driver.findElement(By.cssSelector(".navigation-link:nth-child(2)"));
        System.out.println(search.getText());


    }
    @Test
    public void findElementByXpath() {
        driver.findElement(By.xpath("//h1"));

        //driver.findElement(By.xpath("#city"));
        driver.findElement(By.xpath("//*[@id='city']"));

        driver.findElement(By.xpath("//*[@class='telephone']"));

        driver.findElement(By.xpath("//*[@ng-reflect-name='city']"));

        driver.findElement(By.xpath("//*[starts-with(@class,'ng')]"));

        WebElement text = driver.findElement(By.xpath("//span[contains(text(),'best services')]"));
        System.out.println(text.getText());

        driver.findElement(By.xpath("//*[text()='Find your car now!']"));

        driver.findElement(By.xpath("//a[@class='navigation-link'][@href='/search']"));

        driver.findElement(By.xpath("//*[@class='fas fa-bars']"));

        driver.findElement(By.xpath("//*[@class='logo']/img"));

        driver.findElement(By.xpath("//*[@class='feedback-body']//*[@class='feedback-date']"));

        driver.findElement(By.xpath("//h1/parent::*"));

        driver.findElement(By.xpath("//h1/ancestor::*"));

        driver.findElement(By.xpath("//h1/ancestor::div"));

        driver.findElement(By.xpath("//h1/ancestor::div[2]"));
    }

}
