package saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    @Test
    public void open_browser(){
        WebDriver open;
        String basUrl = "https://www.saucedemo.com/";
        WebDriverManager.chromedriver().setup();
        open = new ChromeDriver();
        open.manage().window().maximize();
        open.get(basUrl);

        WebElement username = open.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");
        username.getText();

        WebElement password = open.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");
        password.getText();

        WebElement submit = open.findElement(By.id("login-button"));
        submit.isDisplayed();
        submit.click();

    }
}
