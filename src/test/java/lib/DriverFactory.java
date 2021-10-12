package lib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver createDriver(Browser browser){

        switch (browser){

            case Edge:
                return createEdgeDriver();
            case Firefox:
                return createFirefoxDriver();
            case Chrome:
            default:
                return createChromeDriver();

        }

    }

    private static WebDriver createChromeDriver(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }
    private static WebDriver createFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();


        return new FirefoxDriver();
    }
    private static WebDriver createEdgeDriver(){
        WebDriverManager.edgedriver().setup();


        return new EdgeDriver();
    }
}
