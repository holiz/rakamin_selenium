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

        WebElement password = open.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement submit = open.findElement(By.id("login-button"));
        submit.click();

        WebElement kebab_menu = open.findElement(By.id("react-burger-menu-btn"));
        kebab_menu.click();

        WebElement logout = open.findElement(By.id("logout_sidebar_link"));

    }
}
