package tests.solenium;

import lib.Browser;
import lib.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ScenarioTwo {
private String username;

private String password;
private String firstName;
private String lastName;
    @Test
    public void registerForNewAccount() {
        setUsername(UUID.randomUUID().toString());
        setPassword(UUID.randomUUID().toString());
        setFirstName(UUID.randomUUID().toString());
        setLastName(UUID.randomUUID().toString());
        String email = username + "@test.com";

        WebDriver driver =
                DriverFactory.createDriver(Browser.Chrome);
        driver.get("https://vgp-shop.polteq-testing.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//li[contains(@class,'my-account')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='reg_username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@name='register']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean actual = driver.findElement(By.xpath("//nav[contains(@class, 'MyAccount-navigation')]")).isDisplayed();
        boolean expected = true;
        Assert.assertEquals( true, actual);
        driver.findElement(By.xpath("//li[contains(@class,'edit-account')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='account_first_name']")).sendKeys(firstName);

        driver.findElement(By.xpath("//input[@id='account_last_name']")).sendKeys(lastName);
        driver.findElement(By.xpath("//button[@name='save_account_details']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[contains(@class,'logout')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name= 'login']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[contains(@class,'edit-account')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String actualSecond = driver.findElement(By.xpath("//input[@id= 'account_first_name']")).getAttribute("value");
        String expectedSecond = firstName;
        Assert.assertEquals(expectedSecond, actualSecond);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
