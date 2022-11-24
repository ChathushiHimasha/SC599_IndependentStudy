package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class LoginTest {

    public static WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @AfterAll
//    public static void tearDown(){
//        driver.quit();
//    }

    @Test
    public void openGoogle(){
        driver.get("https://auth.geeksforgeeks.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        WebElement input_userName = driver.findElement(By.id("luser"));
        input_userName.sendKeys("rapomi8544@turuma.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        WebElement input_password = driver.findElement(By.id("password"));
        input_password.sendKeys("1qaz2wsx@E");

        WebElement clickSignIn_button = driver.findElement(By.xpath("//*[@id=\"Login\"]/button"));
        clickSignIn_button.click();

        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals("https://auth.geeksforgeeks.org/roadBlock_v2.php")){
            System.out.println("Test case is Passed");
        }
        else{
            System.out.println("Test case is Failed");
        }

    }
}