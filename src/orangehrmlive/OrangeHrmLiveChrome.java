package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OrangeHrmLiveChrome {
    public static void main(String[] args) {
        String baseUrl = "https://opensource-demo.orangehrmlive.com/";
        //Launch Chrome Browser
        WebDriver driver = new ChromeDriver();
        //Open baseurl
        driver.get(baseUrl);
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
