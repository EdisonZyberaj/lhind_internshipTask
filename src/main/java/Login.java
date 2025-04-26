import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
// needs refactor
public class Login {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;

        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Browser drivers\\chromedriver.exe");
            driver = new ChromeDriver();

            driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");

            driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("edisonzyberaj@gmail.com");
            Thread.sleep(5000);

            driver.findElement(By.cssSelector("input[name='login[password]']")).sendKeys("Edison1234@gmail.com");
            Thread.sleep(5000);

            driver.findElement(By.name("send")).click();
            Thread.sleep(90000);

            WebElement loggedInElement = driver.findElement(By.cssSelector("div[class='panel header'] span[class='logged-in']"));
            Assert.assertTrue("Thank you for registering with Main Webside Store", loggedInElement.isDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
