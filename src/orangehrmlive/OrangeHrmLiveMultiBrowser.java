package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OrangeHrmLiveMultiBrowser {
    static String baseurl = "https://opensource-demo.orangehrmlive.com/";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        //baseurl
        driver.get(baseurl);
        //implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Print title of the page
        String title = driver.getTitle();
        System.out.println("The title of the page is :" + title);
        //Print the current Url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("The current URL is :" + currentUrl);
        //Print the page source
        System.out.println("The page source is :" + driver.getPageSource());
        //Click on forgot password link
        driver.findElement(By.className("orangehrm-login-forgot-header")).click();
        //Print the current url
        System.out.println("The current Url is : " + driver.getCurrentUrl());
        //Navigate back to the login page
        driver.navigate().back();
        //Refresh the page
        driver.navigate().refresh();
        //Enter email to email field
        WebElement email = driver.findElement(By.name("username"));
        email.sendKeys("Admin");
        //Enter password to password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        //click on login button
        driver.findElement(By.className("orangehrm-login-button")).click();
        driver.quit();
    }
}

