package saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class failedlogin {
    @Test
    public void open_browser() {
        WebDriver open;
        String basUrl = "https://www.saucedemo.com/";
        WebDriverManager.chromedriver().setup();
        open = new ChromeDriver();
        open.manage().window().maximize();
        open.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        open.get(basUrl);

        WebElement username = open.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");
        username.getText();

        WebElement password = open.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce1");
        password.getText();

        WebElement submit = open.findElement(By.id("login-button"));
        submit.isDisplayed();
        submit.click();

        String errorlogin = submit.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button/svg")).getText();
        Assert.assertEquals(errorlogin,"error salah password");

    }

}
